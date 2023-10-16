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
        Integer a[] = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> normalList = Arrays.asList(a);
        Integer b[] = new Integer[] { 2, 4, 6, 8, 10 };
        List<Integer> expectedList = Arrays.asList(b);
        //System.out.println(expectedList);

        //When
        List<Integer> resultNormal = oddNumbersExterminatorNormal.exterminate(normalList);
        //System.out.println(resultNormal);

        //Then
        Assertions.assertEquals(expectedList, resultNormal);
    }
}