# Microservices Architecture

An order service coordinates independently modeled catalog and payment
services through explicit client contracts. The example substitutes local
implementations for network calls: real microservices add deployment,
serialization, latency, retries, and partial-failure concerns that an
in-process test cannot demonstrate.

Run with `./gradlew :microservices:test` from the repository root.
