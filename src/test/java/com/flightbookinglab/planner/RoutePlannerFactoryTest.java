package com.flightbookinglab.planner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RoutePlannerFactoryTest {

    private RoutePlannerFactory classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new RoutePlannerFactory();
    }

    @Test
    public void shouldReturnShortestRoutePlanner() throws Exception {
        RoutePlanner routePlanner = classUnderTest.getRoutePlanner(PlannerType.SHORTEST);
        assertTrue(routePlanner instanceof LeastFlightConnectionsPlanner);
    }

    @Test
    public void shouldReturnCheapestRoutePlanner() throws Exception {
        RoutePlanner routePlanner = classUnderTest.getRoutePlanner(PlannerType.CHEAPEST);
        assertTrue(routePlanner instanceof CheapestFlightConnectionPlanner);
    }
}