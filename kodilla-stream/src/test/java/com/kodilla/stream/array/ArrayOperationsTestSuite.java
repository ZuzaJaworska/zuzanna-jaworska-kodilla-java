package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int testArray [] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 42};
        double testAverage = 21.1;

        //When
        double result = ArrayOperations.getAverage(testArray);

        //Then
        assertEquals(testAverage, result);
    }
}
