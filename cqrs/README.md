# Command Query Responsibility Segregation (CQRS)

Commands change state through the write side; queries read a separate view.
The tiny example keeps the two interfaces and responsibilities explicit while
sharing an in-memory store for simplicity. Production CQRS may use separate
models or stores and must handle synchronization and eventual consistency.

Run with `./gradlew :cqrs:test` from the repository root.
