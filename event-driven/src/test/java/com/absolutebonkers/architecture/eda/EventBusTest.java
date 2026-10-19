package com.absolutebonkers.architecture.eda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class EventBusTest {
    @Test
    void independentSubscribersReactToThePublishedFact() {
        var bus = new EventBus();
        var inventory = new ArrayList<String>();
        var analytics = new ArrayList<String>();
        bus.subscribe(event -> inventory.add(event.orderId()));
        bus.subscribe(event -> analytics.add(event.itemCount() + " items"));

        new OrderProducer(bus).place("o-17", 2);

        assertEquals(java.util.List.of("o-17"), inventory);
        assertEquals(java.util.List.of("2 items"), analytics);
    }
}
