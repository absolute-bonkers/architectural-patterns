package com.absolutebonkers.architecture.hexagonal;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class InMemoryTaskRepository implements TaskRepository {
    private final Map<String, Task> tasks = new HashMap<>();

    @Override
    public void save(Task task) {
        tasks.put(task.id(), task);
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.ofNullable(tasks.get(id));
    }
}
