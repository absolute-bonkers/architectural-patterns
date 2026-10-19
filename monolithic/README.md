# Monolithic Architecture

One application coordinates a complete order workflow. Catalog, pricing, and
checkout are separate parts of the same deployable and call each other directly
in-process. This keeps local calls simple, while also making the application a
single deployment and scaling unit.

Run with `./gradlew :monolithic:test` from the repository root.
