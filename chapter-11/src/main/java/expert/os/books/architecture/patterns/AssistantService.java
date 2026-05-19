package expert.os.books.architecture.patterns;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.SystemMessage;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAIService
@ApplicationScoped
public interface AssistantService {

    @SystemMessage("You are a helpful assistant.")
    String chat(String userMessage);
}