package com.flightbookinglab.model.airline;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.Flight;

import java.util.*;

public class Airlines {
    private static Map<Operator, Airline> airlines = new HashMap<>();
    private static Map<Airport, List<Flight>> airportOutGoingFlights = new HashMap<>();


    public static void addCareer(Operator operator, Airline airlineFleet) {
        airlines.put(operator, airlineFleet);

        for (Airport source : airlineFleet.getOutgoingFlights().keySet()) {
            if (airportOutGoingFlights.containsKey(source)) {
                airportOutGoingFlights.get(source).addAll(airlineFleet.getOutgoingFlights().get(source));
            } else {
                airportOutGoingFlights.put(source, airlineFleet.getOutgoingFlights().get(source));
            }
        }
    }

    public static List<Flight> getAirportOutGoingFlights(Airport source) {
        if (airportOutGoingFlights.containsKey(source))
            return airportOutGoingFlights.get(source);
        else return new ArrayList<>();
    }


    public static Airline getAirlinesByOperator(Operator operator) {
        return airlines.containsKey(operator)? airlines.get(operator):null;
    }

    public static void resetAirlines()
    {
        airlines.clear();
        airportOutGoingFlights.clear();
    }
}
