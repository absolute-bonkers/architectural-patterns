package com.absolutebonkers.architecture.eventsourcing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class BankAccount {
    private final List<AccountEvent> events = new ArrayList<>();

    public void open(String accountId) {
        if (accountId == null || accountId.isBlank()) {
            throw new IllegalArgumentException("Account ID is required");
        }
        if (!events.isEmpty()) {
            throw new IllegalStateException("Account is already open");
        }
        events.add(new AccountOpened(accountId));
    }

    public void deposit(BigDecimal amount) {
        if (events.isEmpty()) {
            throw new IllegalStateException("Open the account before depositing");
        }
        Objects.requireNonNull(amount, "amount");
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

    public record AccountOpened(String accountId) implements AccountEvent {
        public AccountOpened {
            if (accountId == null || accountId.isBlank()) {
                throw new IllegalArgumentException("Account ID is required");
            }
        }
    }

    public record MoneyDeposited(BigDecimal amount) implements AccountEvent {
        public MoneyDeposited {
            Objects.requireNonNull(amount, "amount");
            if (amount.signum() <= 0) {
                throw new IllegalArgumentException("Deposit must be positive");
            }
        }
    }
}
