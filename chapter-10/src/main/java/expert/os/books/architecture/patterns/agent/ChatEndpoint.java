package expert.os.books.architecture.patterns.agent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ChatEndpoint {

    @Inject
    private SessionAwareAgent agent;

    public void simulateConcurrentTraffic() {
        // Session 1: Alice establishes context
        agent.chat("session-alice-123", "Hi, my name is Alice and I am a Premium member.");

        // Session 2: Bob establishes context
        agent.chat("session-bob-999", "Hey, I'm Bob. I am on the free tier.");

        // Testing the isolated memory state:
        // The framework looks up "session-alice-123", fetches her specific 10-message window,
        // and appends it to the LLM prompt. Bob's data is completely isolated.
        String response = agent.chat("session-alice-123", "What is my membership level?");
        System.out.println(response); // "You are a Premium member, Alice."
    }
}