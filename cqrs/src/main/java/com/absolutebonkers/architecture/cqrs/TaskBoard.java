package com.absolutebonkers.architecture.cqrs;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class TaskBoard {
    private final Map<String, Task> writeModel = new HashMap<>();
    private final Map<String, String> readModel = new HashMap<>();

    public void addTask(String id, String title) {
        if (id == null || id.isBlank() || title == null || title.isBlank()) {
            throw new IllegalArgumentException("Task id and title are required");
        }
        if (writeModel.containsKey(id)) {
            throw new IllegalArgumentException("Task already exists: " + id);
        }
        var task = new Task(id, title, false);
        writeModel.put(id, task);
        readModel.put(id, title + " [open]");
    }

    public void completeTask(String id) {
        var task = Optional.ofNullable(writeModel.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Unknown task: " + id));
        writeModel.put(id, new Task(id, task.title(), true));
        readModel.put(id, task.title() + " [done]");
    }

    public Optional<String> taskSummary(String id) {
        return Optional.ofNullable(readModel.get(id));
    }

    private record Task(String id, String title, boolean complete) {}
}
