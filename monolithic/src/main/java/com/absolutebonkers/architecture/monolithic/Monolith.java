package com.absolutebonkers.architecture.monolithic;

import java.math.BigDecimal;
import java.util.Map;

public final class Monolith {
    private final Map<String, BigDecimal> catalog = Map.of(
            "book", new BigDecimal("12.00"),
            "pen", new BigDecimal("2.50"));

    public Receipt checkout(String sku, int quantity) {
        var unitPrice = catalog.get(sku);
        if (unitPrice == null || quantity < 1) {
            throw new IllegalArgumentException("Unknown item or invalid quantity");
        }
        var total = unitPrice.multiply(BigDecimal.valueOf(quantity));
        return new Receipt(sku, quantity, total);
    }

    public record Receipt(String sku, int quantity, BigDecimal total) {}
}
