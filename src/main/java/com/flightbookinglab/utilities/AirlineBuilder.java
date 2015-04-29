package com.flightbookinglab.utilities;

import com.flightbookinglab.model.Flight;
import com.flightbookinglab.model.airline.Airline;
import com.flightbookinglab.model.airline.Operator;

import java.util.ArrayList;
import java.util.List;

public class AirlineBuilder {

    private Operator operator;
    private List<Flight> flights = new ArrayList<Flight>();

    public static AirlineBuilder getInstance() {
        AirlineBuilder airlineBuilder = new AirlineBuilder();
        return airlineBuilder;
    }

    public AirlineBuilder forOperator(Operator operator)
    {
        this.operator = operator;
        return this;
    }

    public AirlineBuilder withFlight(Flight flight)
    {
        flights.add(flight);
        return this;
    }

    public Airline build()
    {
        Airline airline = new Airline(operator);
        flights.forEach(airline::addFlight);
        return airline;
    }
}
