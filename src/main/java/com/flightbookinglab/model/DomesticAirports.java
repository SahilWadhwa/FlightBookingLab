package com.flightbookinglab.model;

import java.util.HashSet;
import java.util.Set;

public class DomesticAirports {

    private static Set<Airport> domesticeAirports = new HashSet<>();

    public static Airport getAirport(String name) {
        for (Airport airport : domesticeAirports) {
            if (airport.getCityName().equals(name)) {
                return airport;
            }
        }
        return null;
    }

    ;

    public static void add(Airport airport) {
        domesticeAirports.add(airport);
    }
}
