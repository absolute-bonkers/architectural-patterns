package com.absolutebonkers.architecture.layered;

import java.math.BigDecimal;
import java.util.Map;

public final class ProductRepository {
    private final Map<String, BigDecimal> prices = Map.of(
            "mug", new BigDecimal("8.00"),
            "plate", new BigDecimal("6.50"));

    public BigDecimal priceOf(String sku) {
        var price = prices.get(sku);
        if (price == null) {
            throw new IllegalArgumentException("Unknown product: " + sku);
        }
        return price;
    }
}
