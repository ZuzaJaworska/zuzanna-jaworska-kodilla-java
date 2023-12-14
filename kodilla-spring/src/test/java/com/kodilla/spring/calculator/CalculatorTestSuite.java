package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {
        //Given

        //When
        double addVal = calculator.add(6, 2);
        double subVal = calculator.sub(6, 2);
        double mulVal = calculator.mul(6, 2);
        double divVal = calculator.div(6, 2);

        //Then
        assertEquals(8, addVal);
        assertEquals(4, subVal);
        assertEquals(12, mulVal);
        assertEquals(3, divVal);
    }
}
