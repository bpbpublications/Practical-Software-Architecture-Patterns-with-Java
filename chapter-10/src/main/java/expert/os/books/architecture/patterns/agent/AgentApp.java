package expert.os.books.architecture.patterns.agent;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class AgentApp {

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            ChatEndpoint chatEndpoint = container.select(ChatEndpoint.class).get();
            chatEndpoint.simulateConcurrentTraffic();
        }

    }
}
