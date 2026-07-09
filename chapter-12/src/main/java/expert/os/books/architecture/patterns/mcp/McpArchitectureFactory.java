package expert.os.books.architecture.patterns.mcp;

import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.McpClient;
import dev.langchain4j.mcp.client.transport.McpTransport;
import dev.langchain4j.mcp.client.transport.http.StreamableHttpMcpTransport;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.tool.ToolProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.List;

@ApplicationScoped
public class McpArchitectureFactory {

    @Produces
    @ApplicationScoped
    public McpClient createMcpClient() {
        // Define the transport layer connecting to a remote Enterprise MCP Server
        // This server could be written in Python, TypeScript, or Go. It doesn't matter!
        McpTransport transport = StreamableHttpMcpTransport.builder()
                .url("http://localhost:8080/sse")
                .logRequests(true)
                .build();

        // Initialize the client and perform the connection handshake
        var mcpClient = DefaultMcpClient.builder()
                .transport(transport)
                .clientName("Java-Enterprise-Orchestrator")
                .clientVersion("1.0.0")
                .build();

        return mcpClient;
    }

    @Produces
    @ApplicationScoped
    public ToolProvider createToolProvider(McpClient mcpClient) {
        // The McpToolProvider is the magic architectural bridge.
        // It queries the external MCP Server, downloads the JSON schemas for all
        // available tools, and seamlessly converts them into LangChain4j-compatible tools.
        return McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();
    }

    @Produces
    @ApplicationScoped
    public OperationsAgent createAgent(ChatModel chatModel, ToolProvider mcpTools) {
        // We inject the dynamic tool provider directly into the Agent builder.
        // CRITICAL FIX: The Agent MUST have ChatMemory to successfully perform multi-step
        // tool execution loops. Without memory, it forgets it has to call the tool or
        // forgets the tool's result!
        return AiServices.builder(OperationsAgent.class)
                .chatModel(chatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .toolProvider(mcpTools)
                .build();
    }
}