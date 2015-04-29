package com.flightbookinglab.model;


import com.flightbookinglab.model.airline.Operator;

public class Flight {

    private String flightName;
    private Operator career;
    private Airport source;
    private Airport destination;
    private Integer price;

    public Flight(String flightName, Operator career, Airport source, Airport destination, Integer price) {
        this.flightName = flightName;
        this.career = career;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public String getFlightName() {
        return flightName;
    }


    public Operator getCareer() {
        return career;
    }


    public Integer getPrice() {
        return price;
    }


    public Airport getSource() {
        return source;
    }


    public Airport getDestination() {
        return destination;
    }

}
