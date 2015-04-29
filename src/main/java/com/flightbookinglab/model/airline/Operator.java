package com.flightbookinglab.model.airline;

public enum Operator {
    INDIGO,
    JETAIRWAYS,
    AIRINDIA;

    public static Operator lookup(String name) {
        try {
            return Operator.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
