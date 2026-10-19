package com.absolutebonkers.architecture.layered;

import java.math.BigDecimal;

public final class PricingService {
    private final ProductRepository products;

    public PricingService(ProductRepository products) {
        this.products = products;
    }

    public BigDecimal quote(String sku, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        return products.priceOf(sku).multiply(BigDecimal.valueOf(quantity));
    }
}
