package com.absolutebonkers.architecture.monolithic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class MonolithTest {
    @Test
    void coordinatesCheckoutInsideOneApplication() {
        var receipt = new Monolith().checkout("book", 2);

        assertEquals(new BigDecimal("24.00"), receipt.total());
        assertEquals(2, receipt.quantity());
    }

    @Test
    void rejectsInvalidCheckoutRequests() {
        assertThrows(IllegalArgumentException.class, () -> new Monolith().checkout("missing", 1));
    }
}
