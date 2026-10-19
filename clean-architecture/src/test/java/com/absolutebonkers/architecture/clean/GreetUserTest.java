package com.absolutebonkers.architecture.clean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GreetUserTest {
    @Test
    void useCaseCreatesDomainOutputAndHandsItToAnOuterAdapter() {
        var presenter = new ConsoleGreetingPresenter();

        new GreetUser(presenter).execute("Ada");

        assertEquals("Hello, Ada", presenter.lastMessage());
    }
}
