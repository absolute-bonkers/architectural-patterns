package com.absolutebonkers.architecture.eda;

import java.util.Objects;

public final class OrderProducer {
    private final EventBus eventBus;

    public OrderProducer(EventBus eventBus) {
        this.eventBus = Objects.requireNonNull(eventBus, "eventBus");
    }

    public void place(String orderId, int itemCount) {
        if (itemCount < 1) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        eventBus.publish(new EventBus.OrderPlaced(orderId, itemCount));
    }
}
