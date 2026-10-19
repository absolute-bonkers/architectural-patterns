package com.absolutebonkers.architecture.eventsourcing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class BankAccountTest {
    @Test
    void rebuildsBalanceByReplayingImmutableEvents() {
        var account = new BankAccount();
        account.open("a-1");
        account.deposit(new BigDecimal("10.00"));
        account.deposit(new BigDecimal("4.25"));

        assertEquals(new BigDecimal("14.25"), account.balance());
        assertEquals(3, account.history().size());
    }
}
