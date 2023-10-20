package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class AdvancedStatisticsTestSuite {

    AdvancedStatistics advancedStatistics = new AdvancedStatistics();

    private List<String> generateListOfUsers(int usersQuantity) {
        List<String> listOfUsers = new ArrayList<>();
        for (int n = 0; n < usersQuantity; n++) {
            listOfUsers.add(0, "user" + n);
        }
        return listOfUsers;
    }

    @Mock
    Statistics statisticsMock = mock(Statistics.class);

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("The beginning of tests");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("The end of tests");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("#" + testCounter + " Test Case: begin");
    }

    @AfterEach
    public void afterEveryTest() {
        System.out.println("#" + testCounter + " Test Case: end\n");
    }

    // test gdy liczba postów = 0
    @Test
    void testWhenZeroPosts() {
        //Given
        List<String> listOfUsersMock = generateListOfUsers(10);

        when(statisticsMock.usersNames()).thenReturn(listOfUsersMock);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(10);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, advancedStatistics.getUsersAll());
        assertEquals(0, advancedStatistics.getPostsAll());
        assertEquals(10, advancedStatistics.getCommentsAll());
        assertEquals(0, advancedStatistics.calcAvgPostsPerUser());
        assertEquals(1, advancedStatistics.calcAvgCommentsPerUser());
        assertEquals(0, advancedStatistics.calcAvgCommentsPerPost());
    }

    // test gdy liczba postów = 1000
    @Test
    void testWhen1000Posts() {
        //Given
        List<String> listOfUsersMock = generateListOfUsers(10);

        when(statisticsMock.usersNames()).thenReturn(listOfUsersMock);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, advancedStatistics.getUsersAll());
        assertEquals(1000, advancedStatistics.getPostsAll());
        assertEquals(100, advancedStatistics.getCommentsAll());
        assertEquals(100, advancedStatistics.calcAvgPostsPerUser());
        assertEquals(10, advancedStatistics.calcAvgCommentsPerUser());
        assertEquals(0.1, advancedStatistics.calcAvgCommentsPerPost());
    }

    // test gdy liczba komentarzy = 0
    @Test
    void testWhenZeroComments() {
        //Given
        List<String> listOfUsersMock = generateListOfUsers(10);

        when(statisticsMock.usersNames()).thenReturn(listOfUsersMock);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, advancedStatistics.getUsersAll());
        assertEquals(100, advancedStatistics.getPostsAll());
        assertEquals(0, advancedStatistics.getCommentsAll());
        assertEquals(10, advancedStatistics.calcAvgPostsPerUser());
        assertEquals(0, advancedStatistics.calcAvgCommentsPerUser());
        assertEquals(0, advancedStatistics.calcAvgCommentsPerPost());
    }

    // test gdy liczba postów > liczba komentarzy
    @Test
    void testWhenCommentsLessThanPosts() {
        //Given
        List<String> listOfUsersMock = generateListOfUsers(10);

        when(statisticsMock.usersNames()).thenReturn(listOfUsersMock);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, advancedStatistics.getUsersAll());
        assertEquals(1000, advancedStatistics.getPostsAll());
        assertEquals(100, advancedStatistics.getCommentsAll());
        assertEquals(100, advancedStatistics.calcAvgPostsPerUser());
        assertEquals(10, advancedStatistics.calcAvgCommentsPerUser());
        assertEquals(0.1, advancedStatistics.calcAvgCommentsPerPost());
    }

    // test gdy liczba postów < liczba komentarzy
    @Test
    void testWhenCommentsMoreThanPosts() {
        //Given
        List<String> listOfUsersMock = generateListOfUsers(10);

        when(statisticsMock.usersNames()).thenReturn(listOfUsersMock);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, advancedStatistics.getUsersAll());
        assertEquals(100, advancedStatistics.getPostsAll());
        assertEquals(1000, advancedStatistics.getCommentsAll());
        assertEquals(10, advancedStatistics.calcAvgPostsPerUser());
        assertEquals(100, advancedStatistics.calcAvgCommentsPerUser());
        assertEquals(10, advancedStatistics.calcAvgCommentsPerPost());
    }

    // gdy liczba użytkowników = 0
    @Test
    void testWhenZeroUsers() {
        //Given
        List<String> listOfUsersMock = new ArrayList<>();

        when(statisticsMock.usersNames()).thenReturn(listOfUsersMock);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(10);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, advancedStatistics.getUsersAll());
        assertEquals(10, advancedStatistics.getPostsAll());
        assertEquals(10, advancedStatistics.getCommentsAll());
        assertEquals(0, advancedStatistics.calcAvgPostsPerUser());
        assertEquals(0, advancedStatistics.calcAvgCommentsPerUser());
        assertEquals(1, advancedStatistics.calcAvgCommentsPerPost());
    }

    // gdy liczba użytkowników = 100
    @Test
    void testWhen100Users() {
        //Given
        List<String> listOfUsersMock = generateListOfUsers(100);

        when(statisticsMock.usersNames()).thenReturn(listOfUsersMock);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10000);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, advancedStatistics.getUsersAll());
        assertEquals(1000, advancedStatistics.getPostsAll());
        assertEquals(10000, advancedStatistics.getCommentsAll());
        assertEquals(10, advancedStatistics.calcAvgPostsPerUser());
        assertEquals(100, advancedStatistics.calcAvgCommentsPerUser());
        assertEquals(10, advancedStatistics.calcAvgCommentsPerPost());
    }
}
