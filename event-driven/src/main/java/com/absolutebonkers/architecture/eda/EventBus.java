package com.absolutebonkers.architecture.eda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class EventBus {
    private final List<Consumer<OrderPlaced>> subscribers = new ArrayList<>();

    public void subscribe(Consumer<OrderPlaced> subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(OrderPlaced event) {
        List.copyOf(subscribers).forEach(subscriber -> subscriber.accept(event));
    }

    public record OrderPlaced(String orderId, int itemCount) {}
}
