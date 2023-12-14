package com.kodilla.spring.shape;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope("singleton")
public class Circle implements Shape {

    @Override
    public String getShapeName() {
        return "This is a circle";
    }
}
