package com.kodilla.exception.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Look at all these tests:\n");
    }

    private static int testCounter = 0;

    @BeforeEach
    void beforeEachTest() {
        testCounter++;
        System.out.println("#" + testCounter + " Test Case: begin");
    }

    @AfterEach
    public void afterEveryTest() {
        System.out.println("#" + testCounter + " Test Case: end\n");
    }

    //tests correct numbers (x >= 2 || x < 1 || y == 1.5)
    @Test
    void testTheMethodForCorrectNumbers() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 2));
    }

    //test for x < 1 and y == 1.5
    @Test
    void testTheMethodWhenXAndYAreIncorrect() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3, 1.5));
    }

    @Nested
    @DisplayName("Tests for x")
    class TestsForX {

        //test for x < 1 and y is correct
        @Test
        void testTheMethodWhenXSmallerThanOne() {
            //Given
            SecondChallenge secondChallenge = new SecondChallenge();

            //When & Then
            assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0, 1));
        }

        //test for x == 1 and y is correct
        @Test
        void testTheMethodWhenXIsOne() {
            //Given
            SecondChallenge secondChallenge = new SecondChallenge();

            //When & Then
            assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 1));
        }

        //test for x > 2 and y is correct
        @Test
        void testTheMethodWhenXIsBiggerThanTwo() {
            //Given
            SecondChallenge secondChallenge = new SecondChallenge();

            //When & Then
            assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3, 1));
        }

        //test for x == 2 and y is correct
        @Test
        void testTheMethodWhenXIsTwo() {
            //Given
            SecondChallenge secondChallenge = new SecondChallenge();

            //When & Then
            assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1));
        }
    }

    @Nested
    @DisplayName("Tests for y")
    class TestsForY {

        //test for y == 1.5 and x is correct
        @Test
        void testTheMethodWhenYIsIncorrect() {
            //Given
            SecondChallenge secondChallenge = new SecondChallenge();

            //When & Then
            assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5));
        }
    }
}
