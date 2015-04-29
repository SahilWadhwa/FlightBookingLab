package com.flightbookinglab.model.airline;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airline {
    Operator operator;
    private Map<Airport, List<Flight>> outgoingFlights = new HashMap<>();

    public Airline(Operator operator) {
        this.operator = operator;
    }

    public Map<Airport, List<Flight>> getOutgoingFlights() {
        return outgoingFlights;
    }

    public Operator getOperator() {
        return operator;
    }

    public void addFlight(Flight flight) {
        if (flight.getCareer().equals(getOperator())) {
            if (outgoingFlights.containsKey(flight.getSource())) {
                outgoingFlights.get(flight.getSource()).add(flight);
            } else {
                ArrayList<Flight> flights = new ArrayList<>();
                flights.add(flight);
                outgoingFlights.put(flight.getSource(), flights);
            }
        }
    }


}
