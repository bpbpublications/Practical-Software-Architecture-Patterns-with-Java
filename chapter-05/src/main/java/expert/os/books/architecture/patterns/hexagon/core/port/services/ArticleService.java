package expert.os.books.architecture.patterns.hexagon.core.port.services;

import expert.os.books.architecture.patterns.hexagon.core.Article;
import expert.os.books.architecture.patterns.hexagon.core.port.in.PublishArticleUseCase;
import expert.os.books.architecture.patterns.hexagon.core.port.out.ArticleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
class ArticleService implements PublishArticleUseCase {

    private final ArticleRepository repository;

    // CDI Constructor Injection: Inverts the dependency!
    @Inject
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void publishArticle(String articleId) {
        System.out.println("[Domain] Executing Publish Use Case for: " + articleId);

        // 1. Retrieve the domain entity via the Outbound Port
        Article article = repository.findById(articleId);

        if (article == null) {
            throw new IllegalArgumentException("Article not found.");
        }

        // 2. Execute core business logic
        article.publish();

        // 3. Persist the state via the Outbound Port
        repository.save(article);
        System.out.println("[Domain] Article successfully published.");
    }
}
