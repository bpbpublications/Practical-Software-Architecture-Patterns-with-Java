package expert.os.books.architecture.patterns.mcp;

import dev.langchain4j.service.SystemMessage;

public interface OperationsAgent {
    @SystemMessage("""
            You are an enterprise operations assistant. You MUST use the `fetch_logs` tool to retrieve internal data.
            Do NOT provide generic troubleshooting advice or ask the user for log files. If you do not execute the tool,
            you have failed your objective.
            """ )
    String executeTask(String userCommand);
}