package expert.os.books.architecture.patterns;

import dev.langchain4j.cdi.spi.RegisterAIService;
import dev.langchain4j.service.SystemMessage;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAIService
@ApplicationScoped
public interface AssistantService {

    @SystemMessage
    String chat(String userMessage);
}