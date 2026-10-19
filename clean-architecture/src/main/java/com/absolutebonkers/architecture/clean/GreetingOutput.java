package com.absolutebonkers.architecture.clean;

@FunctionalInterface
public interface GreetingOutput {
    void present(Greeting greeting);
}
