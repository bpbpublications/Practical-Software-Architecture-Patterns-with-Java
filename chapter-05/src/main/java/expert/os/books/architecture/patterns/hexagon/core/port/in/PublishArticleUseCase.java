package expert.os.books.architecture.patterns.hexagon.core.port.in;


/**
 * INBOUND PORT (Driving)
 * Defines the Use Case. This is how the outside world commands the application.
 */
public interface PublishArticleUseCase {
    void publishArticle(String articleId);
}