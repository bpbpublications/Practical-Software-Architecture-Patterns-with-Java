package expert.os.books.architecture.patterns;

@RegisterAIService
public interface AssistantService {

    @SystemMessage("You are a helpful assistant.")
    String chat(String userMessage);
}