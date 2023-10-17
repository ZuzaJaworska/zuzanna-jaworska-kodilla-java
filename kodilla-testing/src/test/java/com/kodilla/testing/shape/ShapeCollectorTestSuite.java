package com.kodilla.testing.shape;

import com.kodilla.testing.shape.ShapeCollector;

import org.junit.jupiter.api.*;
import java.lang.*;
import java.util.*;


public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("#" + testCounter + " Test Case: begin");
    }

    @AfterEach
    public void afterEveryTest() {
        System.out.println("#" + testCounter + " Test Case: end");
    }

    @Nested
    @DisplayName("Tests for addFigure()")
    class TestsAdd {

        //test poprawnego dodania figury do kolekcji
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Triangle(2, 4);

            //When
            shapeCollector.addFigure(shape);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeCollection().size());
        }
    }

    @Nested
    @DisplayName("Tests for removeFigure()")
    class TestsRemove {

        //test poprawnego usuwania figury z kolekcji
        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle(4);
            Shape shape1 = new Square(5);
            shapeCollector.addFigure(shape);
            shapeCollector.addFigure(shape1);

            //When
            shapeCollector.removeFigure(shape);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeCollection().size());
        }

        //test usuwania z kolekcji figury nieistniejącej w kolekcji
        @Test
        void testRemoveFigureNonexistentInCollection() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shapeInCollection = new Square(2);
            shapeCollector.addFigure(shapeInCollection);
            Shape shapeNotInCollection = new Circle(2);

            //When
            boolean result = shapeCollector.removeFigure(shapeNotInCollection);

            //Then
            Assertions.assertFalse(result);
            Assertions.assertEquals(1, shapeCollector.getShapeCollection().size());
        }
    }

    @Nested
    @DisplayName("Tests for getFigure()")
    class TestsGetFigure {

        //test pobierania figury z n listy
        @Test
        void testGetFigureFromList() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Triangle(3, 5);
            shapeCollector.addFigure(shape);

            //When
            Shape result = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(shape, result);
        }

        //test pobierania figury spoza n listy
        @Test
        void testGetFigureOutOfList() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(6);
            shapeCollector.addFigure(shape);

            //When
            Shape result = shapeCollector.getFigure(1);

            //Then
            Assertions.assertNull(result);
        }
    }

    @Nested
    @DisplayName("Tests for showFigures()")
    class TestsShowFigures {
        //test zwracania wszystkich figur w jednym Stringu
        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle(5);
            shapeCollector.addFigure(shape);
            List<Shape> comparingList = new ArrayList<>();
            comparingList.add(shape);

            //When
            String result = shapeCollector.showFigures();

            //Then
            Assertions.assertEquals(comparingList.toString(), result);
        }
    }
}