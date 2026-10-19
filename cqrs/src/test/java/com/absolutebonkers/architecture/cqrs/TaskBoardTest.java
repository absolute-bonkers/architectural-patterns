package com.absolutebonkers.architecture.cqrs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TaskBoardTest {
    @Test
    void commandsChangeStateAndQueriesReadTheProjection() {
        var board = new TaskBoard();
        board.addTask("t-1", "Ship example");
        assertEquals("Ship example [open]", board.taskSummary("t-1").orElseThrow());

        board.completeTask("t-1");

        assertEquals("Ship example [done]", board.taskSummary("t-1").orElseThrow());
    }
}
