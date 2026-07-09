package expert.os.books.architecture.patterns.mcp;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class McpMain {

    public static void main(String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

            var agent = container.select(OperationsAgent.class).get();

            // We explicitly name the tool in the prompt to guarantee the LLM bridges
            // its probabilistic engine with our deterministic Node.js MCP server.
            String prompt = "Use the `fetch_logs` tool to check the logs for the 'billing' service, and then summarize the critical errors returned by the tool.";

            System.out.println("User: " + prompt);

            String response = agent.executeTask(prompt);

            System.out.println("Agent: " + response);
        }
    }
}
