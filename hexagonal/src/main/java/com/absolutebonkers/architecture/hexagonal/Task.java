package com.absolutebonkers.architecture.hexagonal;

public record Task(String id, String title, boolean complete) {
    public Task markComplete() {
        return new Task(id, title, true);
    }
}
