package com.absolutebonkers.architecture.microservices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class OrderServiceTest {
    @Test
    void coordinatesServicesThroughTheirContracts() {
        var service = new OrderService(
                sku -> new BigDecimal("4.25"),
                amount -> "pay-42");

        var result = service.placeOrder("tea", 3);

        assertEquals(new BigDecimal("12.75"), result.total());
        assertEquals("pay-42", result.paymentId());
    }
}
