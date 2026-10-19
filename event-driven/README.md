# Event-Driven Architecture (EDA)

The order producer emits an `OrderPlaced` fact without calling inventory
directly. Inventory and analytics subscribe independently and react to that
event. This tiny synchronous in-memory event bus is for illustrating
decoupling—not durable delivery, ordering, or broker guarantees.

Run with `./gradlew :event-driven:test` from the repository root.
