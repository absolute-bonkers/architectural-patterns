# Clean Architecture

The use case depends on an output boundary (`GreetingOutput`), not on an
external delivery mechanism. The domain value is independent of I/O, and the
console presenter is an outer adapter. Dependencies point toward the policy
core; framework and delivery choices can change at the edge.

Run with `./gradlew :clean-architecture:test` from the repository root.
