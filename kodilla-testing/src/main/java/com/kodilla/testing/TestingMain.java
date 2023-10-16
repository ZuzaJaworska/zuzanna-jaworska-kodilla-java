package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        // testing Calculator Class
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // tu umieść kolejny test ->
        System.out.println("Test - pierwszy test jednostkowy:");

        Calculator calculator = new Calculator();

        int resultAdd = calculator.add(5, 7);
        if (resultAdd == 12) {
            System.out.println("adding - test OK");
        } else {
            System.out.println("adding - error");
        }

        int resultSubstract = calculator.subtract(5, 3);
        if (resultSubstract == 2) {
            System.out.println("substring - test OK");
        } else {
            System.out.println("substracting - error");
        }
    }
}