package com.absolutebonkers.architecture.serverless;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GreetingFunctionTest {
    @Test
    void handlesAnInvocationWithoutKeepingRequestState() {
        var function = new GreetingFunction();

        assertEquals(new GreetingFunction.Response(200, "Hello, Ada"),
                function.handle(new GreetingFunction.Request("Ada")));
        assertEquals(new GreetingFunction.Response(400, "Name is required"),
                function.handle(new GreetingFunction.Request(" ")));
        assertEquals(new GreetingFunction.Response(200, "Hello, Grace"),
                function.handle(new GreetingFunction.Request("Grace")));
    }
}
