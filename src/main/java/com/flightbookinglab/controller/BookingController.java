package com.flightbookinglab.controller;

import com.flightbookinglab.model.Route;
import com.flightbookinglab.model.RouteFilter;
import com.flightbookinglab.planner.RoutePlanner;
import com.flightbookinglab.planner.RoutePlannerFactory;

import java.util.List;

import static com.flightbookinglab.model.DomesticAirports.getAirport;


public class BookingController {

    RoutePlanner routePlanner;
    RoutePlannerFactory routePlannerFactory;

    public BookingController() {
        routePlannerFactory = new RoutePlannerFactory();
    }

    public List<Route> getRoutesBetween(String source, String destination, RouteFilter userPreferences) {
        routePlanner = routePlannerFactory.getRoutePlanner(userPreferences.getGeneralPreference());
        return routePlanner.getRoutesBetween(getAirport(source), getAirport(destination), userPreferences);
    }

    public void setRoutePlanner(RoutePlanner routePlanner) {
        this.routePlanner = routePlanner;
    }

    public void setRoutePlannerFactory(RoutePlannerFactory routePlannerFactory) {
        this.routePlannerFactory = routePlannerFactory;
    }
}
