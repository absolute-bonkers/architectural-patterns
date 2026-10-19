package com.absolutebonkers.architecture.hexagonal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CompleteTaskTest {
    @Test
    void useCaseWorksThroughTheRepositoryPortAndAdapter() {
        var repository = new InMemoryTaskRepository();
        repository.save(new Task("t-1", "Write guide", false));

        var completed = new CompleteTask(repository).execute("t-1");

        assertTrue(completed.complete());
        assertTrue(repository.findById("t-1").orElseThrow().complete());
    }
}
