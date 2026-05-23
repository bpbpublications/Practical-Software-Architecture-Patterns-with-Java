package expert.os.books.architecture.patterns.agent;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

public interface SessionAwareAgent {
    String chat(@MemoryId String sessionId, @UserMessage String userMessage);
}