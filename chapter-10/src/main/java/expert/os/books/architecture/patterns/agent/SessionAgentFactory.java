package expert.os.books.architecture.patterns.agent;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@ApplicationScoped
public class SessionAgentFactory {

    @Inject
    private ChatModel chatModel;

    @Produces
    public SessionAwareAgent createAgent() {

        // This provider executes once per unique sessionId.
        // AiServices internally caches the instantiated ChatMemory for future calls.
        ChatMemoryProvider memoryProvider = memoryId ->
                MessageWindowChatMemory.withMaxMessages(10); // Retains last 10 messages per user

        return AiServices.builder(SessionAwareAgent.class)
                .chatModel(chatModel)
                .chatMemoryProvider(memoryProvider) // Bind the dynamic provider
                .build();
    }
}