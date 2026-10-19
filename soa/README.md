# Service-Oriented Architecture (SOA)

The shared customer-profile service exposes a business capability through a
stable contract. Both the order and support consumers reuse it instead of
duplicating profile lookup rules. This illustrates service reuse and contracts;
it does not prescribe a particular transport or enterprise service bus.

Run with `./gradlew :soa:test` from the repository root.
