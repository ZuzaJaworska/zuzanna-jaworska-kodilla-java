package com.kodilla.testing.shape;

public class Square implements Shape{

    private final static String name = "Square";
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    //getters
    public double getSquareSideLength() {
        return sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(sideLength, square.sideLength) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(sideLength);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.pow(sideLength, 2);
    }
}