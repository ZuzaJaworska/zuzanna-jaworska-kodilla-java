package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        //Given
        //When
        Logger.getInstance().log("randomLogName");
        Logger.getInstance().log("testLogName");
        String resultName = Logger.getInstance().getLastLog();
        //Then
        assertEquals("testLogName", resultName);
    }
}
