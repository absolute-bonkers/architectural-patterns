package com.absolutebonkers.architecture.eventsourcing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class BankAccount {
    private final List<AccountEvent> events = new ArrayList<>();

    public void open(String accountId) {
        if (!events.isEmpty()) {
            throw new IllegalStateException("Account is already open");
        }
        events.add(new AccountOpened(accountId));
    }

    public void deposit(BigDecimal amount) {
        if (events.isEmpty()) {
            throw new IllegalStateException("Open the account before depositing");
        }
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        events.add(new MoneyDeposited(amount));
    }

    public BigDecimal balance() {
        return events.stream()
                .map(event -> event instanceof MoneyDeposited deposited
                        ? deposited.amount() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<AccountEvent> history() {
        return List.copyOf(events);
    }

    public sealed interface AccountEvent permits AccountOpened, MoneyDeposited {}

    public record AccountOpened(String accountId) implements AccountEvent {}

    public record MoneyDeposited(BigDecimal amount) implements AccountEvent {}
}
