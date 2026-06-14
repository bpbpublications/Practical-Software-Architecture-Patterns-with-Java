package expert.os.books.architecture.patterns.hexagon.core.port.in;


import expert.os.books.architecture.patterns.hexagon.core.Article;

/**
 * INBOUND PORT (Driving)
 * Defines the Use Case. This is how the outside world commands the application.
 */
public interface PublishArticleUseCase {
    Article publishArticle(String articleId);
}