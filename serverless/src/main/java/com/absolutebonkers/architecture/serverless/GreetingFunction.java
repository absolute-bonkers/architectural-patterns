package com.absolutebonkers.architecture.serverless;

public final class GreetingFunction {
    public Response handle(Request request) {
        if (request == null || request.name() == null || request.name().isBlank()) {
            return new Response(400, "Name is required");
        }
        return new Response(200, "Hello, " + request.name());
    }

    public record Request(String name) {}

    public record Response(int statusCode, String body) {}
}
