```mermaid
flowchart LR
    Client([Web / Mobile Client]) -->|1. GET /users/123/orders| API[REST Controller Adapter]
    API -->|2. getOrders| Domain[[Core Domain]]
    Domain -.->|3. List of Orders| API
    API -.->|4. HTTP 200 OK JSON| Client
    
    style Client fill:#F8F7F7,stroke:#1D5183,stroke-width:2px,color:#1D5183
    style API fill:#F8F7F7,stroke:#019DDC,stroke-width:2px,color:#1D5183
    style Domain fill:#1D5183,stroke:#019DDC,stroke-width:2px,color:#F8F7F7

```