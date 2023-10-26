package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {

    public RouteNotFoundException(final String errorDetails) {
        super(errorDetails);
    }
}
