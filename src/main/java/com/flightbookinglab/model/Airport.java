package com.flightbookinglab.model;

public class Airport {

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public Airport(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object obj) {
        return cityName.equals(((Airport)obj).getCityName());
    }
}
