package expert.os.books.architecture.patterns;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.SystemMessage;

@RegisterAIService
public interface AssistantService {

    @SystemMessage("You are a helpful assistant.")
    String chat(String userMessage);
}