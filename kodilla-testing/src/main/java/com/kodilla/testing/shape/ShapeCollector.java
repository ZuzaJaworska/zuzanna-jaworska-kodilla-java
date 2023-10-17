package com.kodilla.testing.shape;

import java.lang.*;
import java.util.*;

public class ShapeCollector {

    private List<Shape> shapeCollection = new ArrayList<>();

    //getters
    public List<Shape> getShapeCollection() {
        return shapeCollection;
    }

    //metoda dodająca figurę do kolekcji
    public void addFigure(Shape shape) {
        shapeCollection.add(shape);
    }

    //metoda usuwająca figurę z kolekcji
    public boolean removeFigure(Shape shape) {
        return shapeCollection.remove(shape);
    }

    //metoda pobierająca z kolekcji figurę z pozycji n listy
    public Shape getFigure(int n) {
        if (n >= 0 && n < shapeCollection.size()) {
            return shapeCollection.get(n);
        } else {
            return null;
        }
    }

    //metoda zwracająca nazwy wszystkich figur w postaci jednego Stringa
    public String showFigures() {
        return shapeCollection.toString();
    }
}