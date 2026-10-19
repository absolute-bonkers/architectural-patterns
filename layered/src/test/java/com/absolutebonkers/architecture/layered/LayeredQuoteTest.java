package com.absolutebonkers.architecture.layered;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class LayeredQuoteTest {
    @Test
    void requestFlowsThroughPresentationBusinessAndDataLayers() {
        var repository = new ProductRepository();
        var service = new PricingService(repository);
        var controller = new QuoteController(service);

        assertEquals(new BigDecimal("16.00"), controller.quote("mug", 2).total());
    }
}
