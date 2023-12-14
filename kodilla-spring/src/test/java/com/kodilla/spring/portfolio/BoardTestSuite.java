package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    private Board board;

    @Test
    void testTaskAdd() {
        //Given

        //When
        String toDoTask = "one task to do";
        String inProgressTask = "one task in progress";
        String doneTask = "one task done";
        board.getToDoList().getTasks().add(toDoTask);
        board.getInProgressList().getTasks().add(inProgressTask);
        board.getDoneList().getTasks().add(doneTask);

        //Then
        assertEquals("one task to do", board.getToDoList().getTasks().get(0));
        assertEquals("one task in progress", board.getInProgressList().getTasks().get(0));
        assertEquals("one task done", board.getDoneList().getTasks().get(0));
    }
}
