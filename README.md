# 🏛️ Architectural Patterns

Runnable, focused Java examples for 11 common software architecture patterns.
Each pattern is an independent Gradle module with its own guide, example, and
JUnit tests. The examples emphasize the shape and trade-offs of each
architecture without requiring cloud accounts or external services.

Built with **Java 21** and Gradle 9.8.1. Install JDK 21, then run from this
repository root:

```sh
./gradlew test
./gradlew build
./gradlew :hexagonal:test
```

| Architecture | Module | The quick idea |
| --- | --- | --- |
| Monolithic | [monolithic](monolithic/README.md) | One deployable application owns and coordinates the whole workflow. |
| Microservices | [microservices](microservices/README.md) | Independently owned services communicate through explicit contracts. |
| Service-Oriented (SOA) | [soa](soa/README.md) | Reusable business services expose capabilities to multiple consumers. |
| Event-Driven (EDA) | [event-driven](event-driven/README.md) | Producers publish facts; interested consumers react independently. |
| Hexagonal (Ports & Adapters) | [hexagonal](hexagonal/README.md) | Keep application policy inside; connect the outside through ports. |
| Clean Architecture | [clean-architecture](clean-architecture/README.md) | Dependencies point inward toward policy and entities. |
| Layered (N-Tier) | [layered](layered/README.md) | Separate presentation, business logic, and data access. |
| CQRS | [cqrs](cqrs/README.md) | Separate commands that change state from queries that read it. |
| Event Sourcing | [event-sourcing](event-sourcing/README.md) | Store state changes as events and rebuild current state by replaying them. |
| Serverless | [serverless](serverless/README.md) | Run a stateless function in response to an invocation. |
| Micro-Frontends | [micro-frontends](micro-frontends/README.md) | Compose independently developed frontend features behind a shell. |

These are teaching examples, not production infrastructure. In-memory adapters
stand in for databases, brokers, remote services, and cloud runtimes where
those dependencies would distract from the architectural idea.
