# Layered (N-Tier) Architecture

The request follows a clear direction: controller → service → repository.
Presentation handles the request, business logic calculates the price, and
data access supplies the product. This example uses in-process layers; N-tier
deployment can place layers on separate processes or machines.

Run with `./gradlew :layered:test` from the repository root.
