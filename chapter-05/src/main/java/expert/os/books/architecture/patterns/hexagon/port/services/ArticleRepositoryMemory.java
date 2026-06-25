package expert.os.books.architecture.patterns.hexagon.port.services;

import expert.os.books.architecture.patterns.hexagon.core.Article;
import expert.os.books.architecture.patterns.hexagon.port.out.ArticleRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.logging.Logger;

@ApplicationScoped
public class ArticleRepositoryMemory implements ArticleRepository {
    private static final Logger LOGGER = Logger.getLogger(ArticleRepositoryMemory.class.getName());

    @Override
    public Article findById(String articleId) {
        LOGGER.info("Finding article with ID: " + articleId);
        return new Article(articleId, "Sample Title", "Sample Content");
    }

    @Override
    public void save(Article article) {
        LOGGER.info("Saving article with ID: " + article.getId());
    }
}
