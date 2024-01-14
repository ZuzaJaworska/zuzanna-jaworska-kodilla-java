package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTasks(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("zakupy", "jajka", 10.0);
            case PAINTING -> new PaintingTask("malowanie", "czarny", "salon");
            case DRIVING -> new DrivingTask("jazda", "do domu", "rowerem");
            default -> null;
        };
    }
}
