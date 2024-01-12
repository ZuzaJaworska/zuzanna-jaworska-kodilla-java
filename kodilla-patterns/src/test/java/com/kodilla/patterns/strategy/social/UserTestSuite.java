package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User older = new XGeneration("slightly old");
        User bestGen = new Millenials("best generation");
        User child = new ZGeneration("basically a child");

        //When
        String oldersMedia = older.sharePost();
        System.out.println("Gen X post on: " + oldersMedia);
        String bestsMedia = bestGen.sharePost();
        System.out.println("Millenials post on: " + bestsMedia);
        String childrensMedia = child.sharePost();
        System.out.println("Gen Z post on: " + childrensMedia);

        //Then
        assertEquals("Twitter", oldersMedia);
        assertEquals("Facebook", bestsMedia);
        assertEquals("Snapchat", childrensMedia);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User bestGen = new Millenials("best generation");

        //When
        String bestsMedia = bestGen.sharePost();
        System.out.println("Millenials post on: " + bestsMedia);
        bestGen.setSocialPublisher(new TwitterPublisher());
        bestsMedia = bestGen.sharePost();
        System.out.println("Millenials now post on: " + bestsMedia);

        //Then
        assertEquals("Twitter", bestsMedia);
    }
}
