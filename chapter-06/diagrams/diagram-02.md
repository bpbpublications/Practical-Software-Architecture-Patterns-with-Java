```mermaid
flowchart LR
    Client([Data / AI Client]) -->|1. QUERY /orders<br>+ Complex JSON Body| API[REST Controller Adapter]
    API -->|2. queryOrders| Domain[[Core Domain]]
    Domain -.->|3. Filtered Results| API
    API -.->|4. HTTP 200 OK JSON| Client

    style Client fill:#F8F7F7,stroke:#1D5183,stroke-width:2px,color:#1D5183
    style API fill:#F8F7F7,stroke:#019DDC,stroke-width:2px,color:#1D5183
    style Domain fill:#1D5183,stroke:#019DDC,stroke-width:2px,color:#F8F7F7
```