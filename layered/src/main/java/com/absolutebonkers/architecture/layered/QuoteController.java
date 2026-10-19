package com.absolutebonkers.architecture.layered;

import java.math.BigDecimal;

public final class QuoteController {
    private final PricingService pricing;

    public QuoteController(PricingService pricing) {
        this.pricing = pricing;
    }

    public QuoteResponse quote(String sku, int quantity) {
        return new QuoteResponse(sku, quantity, pricing.quote(sku, quantity));
    }

    public record QuoteResponse(String sku, int quantity, BigDecimal total) {}
}
