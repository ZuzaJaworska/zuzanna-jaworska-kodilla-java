package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(1.25, 2);
            System.out.println("Correct numbers");
        } catch (Exception e) {
            System.out.println("Incorrect numbers - error:" + e);
        } finally {
            System.out.println("That's it. All done.");
        }
    }
}
