package expert.os.books.architecture.patterns.hexagon.core.port.services;

import expert.os.books.architecture.patterns.hexagon.core.Article;
import expert.os.books.architecture.patterns.hexagon.core.port.in.PublishArticleUseCase;
import expert.os.books.architecture.patterns.hexagon.core.port.out.ArticleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.logging.Logger;

@ApplicationScoped
class ArticleService implements PublishArticleUseCase {

    private static final Logger LOGGER = Logger.getLogger(ArticleService.class.getName());

    private final ArticleRepository repository;

    @Inject
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Article publishArticle(String articleId) {
        LOGGER.info("[Domain] Executing Publish Use Case for: " + articleId);

        Article article = repository.findById(articleId);

        if (article == null) {
            throw new IllegalArgumentException("Article not found.");
        }

        article.publish();

        repository.save(article);
        LOGGER.info("[Domain] Article successfully published.");
        return article;
    }
}
