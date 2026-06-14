package expert.os.books.architecture.patterns.hexagon.core.adapter.in;

import expert.os.books.architecture.patterns.hexagon.core.port.in.PublishArticleUseCase;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class HexagonalMain {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
        var useCase = container.select(PublishArticleUseCase.class).get();
        useCase.publishArticle("123");
        }
    }
}
