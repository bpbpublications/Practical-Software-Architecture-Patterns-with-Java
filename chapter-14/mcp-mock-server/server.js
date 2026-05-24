import express from "express";
import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { SSEServerTransport } from "@modelcontextprotocol/sdk/server/sse.js";
import { z } from "zod";

const app = express();

// 1. Initialize the MCP Server
const server = new McpServer({
    name: "Enterprise-Mock-Server",
    version: "1.0.0",
});

// 2. Register the specific tool expected by our Java Client
server.tool(
    "fetch_logs",
    "Fetches the latest critical errors for a specific service",
    {
        serviceName: z.string().describe("The name of the service (e.g., 'billing')"),
    },
    async ({ serviceName }) => {
        console.log(`[MCP Server] Executing fetch_logs for: ${serviceName}`);

        // Return mock data for the LLM to parse
        return {
            content: [
                {
                    type: "text",
                    text: `[CRITICAL] [${serviceName}] Database connection timeout at 10:42 AM. \n[ERROR] [${serviceName}] Payment Gateway rejected transaction.`,
                },
            ],
        };
    }
);

// 3. Setup the SSE Transport Layer
let transport;
app.get("/sse", async (req, res) => {
    console.log("[MCP Server] New Client Connected via SSE");
    transport = new SSEServerTransport("/message", res);
    await server.connect(transport);
});

// 4. Handle incoming JSON-RPC tool execution requests
app.post("/message", async (req, res) => {
    if (transport) {
        await transport.handlePostMessage(req, res);
    }
});

// 5. Start listening
app.listen(8080, () => {
    console.log("✅ MCP Mock Server running on http://localhost:8080/sse");
});