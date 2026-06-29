```mermaid
graph TD
V[View] <-->|UI Events / Formats Data| P[Presenter]
P <-->|Updates / Reads| M[Model]

style V fill:#F8F7F7,stroke:#019DDC,stroke-width:2px,color:#1D5183
style P fill:#F8F7F7,stroke:#1D5183,stroke-width:2px,color:#1D5183
style M fill:#1D5183,stroke:#019DDC,stroke-width:2px,color:#F8F7F7
```