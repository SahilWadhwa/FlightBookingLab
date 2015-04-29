package com.flightbookinglab.planner;

public class RoutePlannerFactory {


    public RoutePlanner getRoutePlanner(PlannerType plannerType) {

        switch (plannerType) {
            case SHORTEST:
                return new LeastFlightConnectionsPlanner();
            case CHEAPEST:
                return new CheapestFlightConnectionPlanner();
            default:
                return new LeastFlightConnectionsPlanner();
        }
    }
}
