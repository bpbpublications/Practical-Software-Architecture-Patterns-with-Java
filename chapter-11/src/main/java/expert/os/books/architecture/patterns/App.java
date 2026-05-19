package expert.os.books.architecture.patterns;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class App {

    public static void main(String[] args) {
        try(SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            var service = container.select(AssistantService.class).get();
            String chat = service.chat("Hello, how are you?");
            System.out.println(chat);

        }
    }
}
