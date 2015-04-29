package com.flightbookinglab.planner;

import com.flightbookinglab.model.*;
import com.flightbookinglab.model.airline.Airline;
import com.flightbookinglab.model.airline.Airlines;
import com.flightbookinglab.utilities.AirlineBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.flightbookinglab.model.airline.Operator.JETAIRWAYS;
import static org.junit.Assert.assertTrue;

public class LeastFlightConnectionsPlannerTest {

    private Flight flightDJ;
    private Flight flightDJIndi;
    private Flight flightJP;
    private Flight flightJC;
    private Flight flightDP;
    private Airport delhi;
    private Airport pune;
    private Airport chennai;
    private LeastFlightConnectionsPlanner planner;

    @Before
    public void setUp() throws Exception {
        planner = new LeastFlightConnectionsPlanner();
        delhi = new Airport("delhi");
        pune = new Airport("pune");
        chennai = new Airport("chennai");
        Airport jaipur = new Airport("jaipur");

        DomesticAirports.add(delhi);
        DomesticAirports.add(pune);
        DomesticAirports.add(chennai);
        DomesticAirports.add(jaipur);

        flightDJ = new Flight("delhi-jaipur", JETAIRWAYS, delhi, jaipur, 100);
        flightJP = new Flight("jaipur-pune", JETAIRWAYS, jaipur, pune, 200);
        flightDP = new Flight("delhi-pune", JETAIRWAYS, delhi, pune, 10000);
        flightJC = new Flight("jaipur-chennai", JETAIRWAYS, jaipur, chennai, 10000);

        Airline jet = AirlineBuilder.getInstance().forOperator(JETAIRWAYS).withFlight(flightJC).withFlight(flightDJ).withFlight(flightDP).withFlight(flightJP).build();
        Airlines.addCareer(JETAIRWAYS, jet);
    }



    @Test
    public void shouldGetDirectRoutesBetweenDelhiPune() throws Exception {
        List<Route> routesBetween = planner.getRoutesBetween(delhi, pune, new RouteFilter());
        assertTrue(routesBetween.size() == 1);
        assertTrue(routesBetween.get(0).contains(flightDP));
    }

    @Test
    public void shouldGetShortestRouteIfNoDirectRouteAvailable() throws Exception {
        List<Route> routesBetween = planner.getRoutesBetween(delhi, chennai, new RouteFilter());
        assertTrue(routesBetween.get(0).size() == 2);
        assertTrue(routesBetween.get(0).contains(flightDJ));
        assertTrue(routesBetween.get(0).contains(flightJC));
    }

    @Test
    public void shouldReturnEmptyListIfNoRouteFound() throws Exception {
        List<Route> routesBetween = planner.getRoutesBetween(pune, chennai, new RouteFilter());
        assertTrue(routesBetween.isEmpty());

    }
}