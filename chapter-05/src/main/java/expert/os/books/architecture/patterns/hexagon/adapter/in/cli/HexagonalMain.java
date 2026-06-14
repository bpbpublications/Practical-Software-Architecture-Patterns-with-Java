package expert.os.books.architecture.patterns.hexagon.adapter.in.cli;

import expert.os.books.architecture.patterns.hexagon.core.Article;
import expert.os.books.architecture.patterns.hexagon.port.in.PublishArticleUseCase;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.util.logging.Logger;

public class HexagonalMain {

    private static final Logger LOGGER = Logger.getLogger(HexagonalMain.class.getName());

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
        var useCase = container.select(PublishArticleUseCase.class).get();
            Article article = useCase.publishArticle("123");
            LOGGER.info("[Main] Article published: " + article);
        }
    }
}
