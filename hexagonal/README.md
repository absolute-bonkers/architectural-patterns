# Hexagonal Architecture (Ports & Adapters)

The application core defines a `TaskRepository` port. A use case depends on
that port, while the in-memory repository is a replaceable adapter. The core
does not need to know whether a future adapter uses SQL, a file, or a remote
service.

Run with `./gradlew :hexagonal:test` from the repository root.
