package expert.os.books.architecture.patterns.mvc.cli;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class App {


    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            TaskController controller = container.select(TaskController.class).get();
            controller.handleUserInput("Master Pure MVC Architecture");
        }
    }
}
