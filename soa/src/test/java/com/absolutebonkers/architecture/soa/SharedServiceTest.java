package com.absolutebonkers.architecture.soa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class SharedServiceTest {
    @Test
    void multipleConsumersReuseTheSameBusinessService() {
        var profileService = new CustomerProfileService(Map.of(
                "c-1", new CustomerProfileService.CustomerProfile("c-1", "Ada", "ada@example.com")));

        assertEquals("ada@example.com", new OrderDesk(profileService).addressOrder("c-1"));
        assertEquals("Hello, Ada", new SupportDesk(profileService).greetCustomer("c-1"));
    }
}
