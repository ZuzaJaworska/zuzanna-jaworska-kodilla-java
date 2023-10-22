package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String line = "I love \"Disc world\"";
        System.out.println("Let's beautify this line - " + line);
        poemBeautifier.beautify(line, text -> "ABC  " + line + "  ABC");
        poemBeautifier.beautify(line, text -> line.toUpperCase());

        poemBeautifier.beautify(line, text -> "--- " + line + " ---");
        poemBeautifier.beautify(line, text -> line.toLowerCase());
        poemBeautifier.beautify(line, text -> line.repeat(3));
        poemBeautifier.beautify(line, text -> line.replace('"', '/'));
        poemBeautifier.beautify(line, text -> line.concat("!!!"));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
