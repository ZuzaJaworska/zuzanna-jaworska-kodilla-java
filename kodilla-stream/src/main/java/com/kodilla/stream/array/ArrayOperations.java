package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] average) {
        System.out.println("Array of " + average.length + " elements:");

        IntStream.range(0, average.length)
                .map(n -> average[n])
                .forEach(System.out::println);

        double averageNumber = IntStream.range(0, average.length)
                .map(n -> average[n])
                .average()
                .getAsDouble();

        System.out.println("average = " + averageNumber);

        return averageNumber;
    }
}
