package com.kodilla.testing.collection;
import com.kodilla.testing.collection.OddNumbersExterminator;

import org.junit.jupiter.api.*;
import java.util.*;

class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("when create an empty list, " +
                 "then exterminate should return empty list"
    )

    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        System.out.println("---Testing empty list---");
        OddNumbersExterminator oddNumbersExterminatorEmpty = new OddNumbersExterminator();
        List<Integer> emptyNumbersList = new ArrayList<>();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> resultEmpty = oddNumbersExterminatorEmpty.exterminate(emptyNumbersList);
        //Then
        Assertions.assertEquals(emptyList, resultEmpty);
    }

    @DisplayName("when create a numbers list, " +
                 "then exterminate should return even numbers list"
    )

    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        System.out.println("---Testing normal list---");
        OddNumbersExterminator oddNumbersExterminatorNormal = new OddNumbersExterminator();
        List<Integer> normalList = new ArrayList<>();
        normalList.add(1);
        normalList.add(2);
        normalList.add(3);
        normalList.add(4);
        normalList.add(5);
        normalList.add(6);
        normalList.add(7);
        normalList.add(8);
        normalList.add(9);
        normalList.add(10);

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(4);
        expectedList.add(6);
        expectedList.add(8);
        expectedList.add(10);
        //When
        List<Integer> resultNormal = oddNumbersExterminatorNormal.exterminate(normalList);
        //Then
        Assertions.assertEquals(expectedList, resultNormal);
    }
}