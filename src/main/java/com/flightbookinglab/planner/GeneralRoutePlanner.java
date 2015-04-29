package com.flightbookinglab.planner;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.Route;
import com.flightbookinglab.model.RouteFilter;

import java.util.*;

public class GeneralRoutePlanner implements RoutePlanner {
    @Override
    public List<Route> getRoutesBetween(Airport source, Airport destination, RouteFilter userPreferences) {
        return getAllPossibleFlightRoutesBetween(source, destination);
    }

    protected List<Route> getAllPossibleFlightRoutesBetween(Airport source, Airport destination) {
        AirportNode sourceNode = new AirportNode(source);
        AirportNode destinationNode = new AirportNode(destination);

        Queue<AirportNode> airportNodes = new LinkedList<>();

        airportNodes.add(sourceNode);
        ArrayList<Route> routes = new ArrayList<>();

        while (!airportNodes.isEmpty()) {
            AirportNode airportNode = airportNodes.poll();
            for (AirportNode e : airportNode.getConnectedAirportNodes()) {
                if (airportNode != sourceNode) {
                    e.setPreviousAirport(airportNode);
                }
                airportNodes.add(e);

                if (e.equals(destinationNode)) {
                    routes.add(getLinkedPathToDestination(e));
                }
            }
        }
        return routes;
    }

    private Route getLinkedPathToDestination(AirportNode target) {
        Route route = new Route();
        for (AirportNode node = target; node != null; node = node.getPreviousAirport())
            route.add(node.getIncomingFlight());

        Collections.reverse(route);
        return route;
    }
}
