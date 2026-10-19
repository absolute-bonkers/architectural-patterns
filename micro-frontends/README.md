# Micro-Frontends

The shell selects a feature by route and asks its module to render into a
shared host contract. Independently owned frontend bundles can implement that
contract and be deployed separately. Here, Java components stand in for those
bundles so the composition idea can be tested without a browser or JavaScript
build system.

Run with `./gradlew :micro-frontends:test` from the repository root.
