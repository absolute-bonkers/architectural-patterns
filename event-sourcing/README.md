# Event Sourcing

The event stream is the source of truth: `AccountOpened` and `MoneyDeposited`
are appended as immutable facts, and the account balance is rebuilt by replay.
This in-memory stream omits persistence, concurrency control, snapshots, and
schema evolution, which real event stores must address.

Run with `./gradlew :event-sourcing:test` from the repository root.
