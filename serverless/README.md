# Serverless Architecture

`GreetingFunction` is a stateless request handler with an explicit request and
response contract. A cloud function runtime can invoke the handler; the test
calls it directly, without pretending to emulate cold starts, scaling,
permissions, or a provider's event envelope.

Run with `./gradlew :serverless:test` from the repository root.
