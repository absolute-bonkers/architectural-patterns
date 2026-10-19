package com.absolutebonkers.architecture.eventsourcing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void rejectsInvalidEventsBeforeTheyEnterTheStream() {
        var account = new BankAccount();
        assertThrows(IllegalArgumentException.class, () -> account.open(" "));
        assertThrows(IllegalStateException.class, () -> account.deposit(BigDecimal.ONE));

        account.open("a-1");
        assertThrows(NullPointerException.class, () -> account.deposit(null));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(BigDecimal.ZERO));
        assertEquals(1, account.history().size());
    }
}
