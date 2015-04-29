package com.flightbookinglab.planner;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.Flight;
import com.flightbookinglab.model.Route;
import com.flightbookinglab.model.RouteFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class CheapestFlightConnectionPlanner extends GeneralRoutePlanner {
    @Override
    public java.util.List<Route> getRoutesBetween(Airport source, Airport destination, RouteFilter userPreferences) {
        List<Route> allPossibleFlightsBetween = getAllPossibleFlightRoutesBetween(source, destination);
        return getCheapestRoutes(allPossibleFlightsBetween);
    }

    private List<Route> getCheapestRoutes(List<Route> allPossibleFlightsBetween) {
        TreeMap<Integer, List<Route>> listTreeMap = new TreeMap<Integer, List<Route>>();
        for (Route route : allPossibleFlightsBetween) {
            int routePrice = 0;
            for (Flight flight : route) {
                routePrice += flight.getPrice();
            }
            
            if (listTreeMap.containsKey(routePrice)) {
                listTreeMap.get(routePrice).add(route);
            } else {
                ArrayList<Route> routes = new ArrayList<>();
                routes.add(route);
                listTreeMap.put(routePrice, routes);
            }
        }
        return listTreeMap.isEmpty() ? Collections.EMPTY_LIST : listTreeMap.firstEntry().getValue();
    }
}
