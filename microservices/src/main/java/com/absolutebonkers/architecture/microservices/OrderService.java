package com.absolutebonkers.architecture.microservices;

import java.math.BigDecimal;
import java.util.Objects;

public final class OrderService {
    private final CatalogClient catalog;
    private final PaymentClient payments;

    public OrderService(CatalogClient catalog, PaymentClient payments) {
        this.catalog = Objects.requireNonNull(catalog, "catalog");
        this.payments = Objects.requireNonNull(payments, "payments");
    }

    public OrderResult placeOrder(String sku, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        var total = catalog.priceOf(sku).multiply(BigDecimal.valueOf(quantity));
        var paymentId = payments.charge(total);
        return new OrderResult(sku, quantity, total, paymentId);
    }

    @FunctionalInterface
    public interface CatalogClient {
        BigDecimal priceOf(String sku);
    }

    @FunctionalInterface
    public interface PaymentClient {
        String charge(BigDecimal amount);
    }

    public record OrderResult(String sku, int quantity, BigDecimal total, String paymentId) {}
}
