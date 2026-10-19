package com.absolutebonkers.architecture.hexagonal;

import java.util.Optional;

public interface TaskRepository {
    void save(Task task);

    Optional<Task> findById(String id);
}
