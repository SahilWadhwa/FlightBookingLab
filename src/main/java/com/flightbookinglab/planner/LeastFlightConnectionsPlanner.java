package com.flightbookinglab.planner;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.Route;
import com.flightbookinglab.model.RouteFilter;

import java.util.*;


public class LeastFlightConnectionsPlanner extends GeneralRoutePlanner {
    @Override
    public java.util.List<Route> getRoutesBetween(Airport source, Airport destination, RouteFilter userPreferences) {
        List<Route> allPossibleFlightsBetween = getAllPossibleFlightRoutesBetween(source, destination);
        return getShortestRoutes(allPossibleFlightsBetween);
    }

    private List<Route> getShortestRoutes(List<Route> allPossibleFlightsBetween) {
        TreeMap<Integer, List<Route>> listTreeMap = new TreeMap<Integer, List<Route>>();
        for (Route route : allPossibleFlightsBetween) {
            int size = route.size();
            if (listTreeMap.containsKey(size)) {
                listTreeMap.get(size).add(route);
            } else{
                ArrayList<Route> routes = new ArrayList<>();
                routes.add(route);
                listTreeMap.put(size, routes);
            }
        }
        return listTreeMap.isEmpty()? Collections.EMPTY_LIST :  listTreeMap.firstEntry().getValue();
    }

}

