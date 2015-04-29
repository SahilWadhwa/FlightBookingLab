package com.flightbookinglab.planner;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.Route;
import com.flightbookinglab.model.RouteFilter;

public interface RoutePlanner {
    java.util.List<Route> getRoutesBetween(Airport source, Airport destination, RouteFilter userPreferences);
}
