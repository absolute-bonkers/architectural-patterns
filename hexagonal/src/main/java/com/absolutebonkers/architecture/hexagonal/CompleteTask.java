package com.absolutebonkers.architecture.hexagonal;

import java.util.Objects;

public final class CompleteTask {
    private final TaskRepository tasks;

    public CompleteTask(TaskRepository tasks) {
        this.tasks = Objects.requireNonNull(tasks, "tasks");
    }

    public Task execute(String id) {
        var task = tasks.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unknown task: " + id))
                .markComplete();
        tasks.save(task);
        return task;
    }
}
