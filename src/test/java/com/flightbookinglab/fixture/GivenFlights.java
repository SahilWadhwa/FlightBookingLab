package com.flightbookinglab.fixture;

import com.flightbookinglab.model.DomesticAirports;
import com.flightbookinglab.model.Flight;
import com.flightbookinglab.model.airline.Airline;
import com.flightbookinglab.model.airline.Airlines;
import com.flightbookinglab.model.airline.Operator;
import com.flightbookinglab.utilities.AirlineBuilder;
import fit.ColumnFixture;

public class GivenFlights extends ColumnFixture {
    private String operatorName;
    private String Source;
    private String Destination;
    private String flightName;
    private Integer Price;


    public void execute() throws Exception {
        Operator airlineOperator = Operator.lookup(operatorName);
        Flight flight = new Flight(flightName, airlineOperator, DomesticAirports.getAirport(getSource()), DomesticAirports.getAirport(getDestination()), getPrice());
        Airline airline = Airlines.getAirlinesByOperator(airlineOperator);
        if (airline != null) {
            airline.addFlight(flight);
        } else {
            Airlines.addCareer(airlineOperator, AirlineBuilder.getInstance().forOperator(airlineOperator).withFlight(flight).build());
        }

    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public GivenFlights() {
        Airlines.resetAirlines();
    }

    public GivenFlights(String operatorName, String source, String destination, String flightName, Integer price) {
        this.operatorName = operatorName;
        Source = source;
        Destination = destination;
        this.flightName = flightName;
        Price = price;
    }
}
