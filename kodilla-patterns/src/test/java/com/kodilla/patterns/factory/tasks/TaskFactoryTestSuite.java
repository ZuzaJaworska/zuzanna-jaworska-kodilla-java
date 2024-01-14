package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.makeTasks(TaskFactory.SHOPPING);


        //Then
        assertEquals("zakupy", shopping.getTaskName());
        assertFalse(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task painting = factory.makeTasks(TaskFactory.PAINTING);

        //Then
        assertEquals("malowanie", painting.getTaskName());
        assertFalse(painting.isTaskExecuted());
    }

    @Test
    void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task driving = factory.makeTasks(TaskFactory.DRIVING);

        //Then
        assertEquals("jazda", driving.getTaskName());
        assertFalse(driving.isTaskExecuted());
    }

    @Test
    void testExecutingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.makeTasks(TaskFactory.SHOPPING);
        shopping.executeTask();

        //Then
        assertTrue(shopping.isTaskExecuted());
    }
}
