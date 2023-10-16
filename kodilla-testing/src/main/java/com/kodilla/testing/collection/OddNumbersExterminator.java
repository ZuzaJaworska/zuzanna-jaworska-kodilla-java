package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> evenNumbersList = new ArrayList<>();

        for (int number: numbers) {
            if (number % 2 == 0) {
                evenNumbersList.add(number);
            }
        }
        return evenNumbersList;
    }
}