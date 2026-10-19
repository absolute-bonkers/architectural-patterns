package com.absolutebonkers.architecture.clean;

import java.util.Objects;

public final class GreetUser {
    private final GreetingOutput output;

    public GreetUser(GreetingOutput output) {
        this.output = Objects.requireNonNull(output, "output");
    }

    public void execute(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        output.present(new Greeting("Hello, " + name));
    }
}
