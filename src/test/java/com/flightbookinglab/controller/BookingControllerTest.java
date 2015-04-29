package com.flightbookinglab.controller;

import com.flightbookinglab.model.*;
import com.flightbookinglab.model.airline.Airline;
import com.flightbookinglab.model.airline.Airlines;
import com.flightbookinglab.planner.RoutePlanner;
import com.flightbookinglab.planner.RoutePlannerFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.flightbookinglab.model.airline.Operator.JETAIRWAYS;
import static com.flightbookinglab.planner.PlannerType.CHEAPEST;
import static com.flightbookinglab.planner.PlannerType.SHORTEST;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {

    public static final String DELHI = "delhi";
    public static final String PUNE = "pune";
    Airport delhi;
    Airport pune;
    public BookingController classUnderTest = new BookingController();

    @Before
    public void setUp() throws Exception {

        delhi = new Airport(DELHI);
        pune = new Airport(PUNE);

        DomesticAirports.add(delhi);
        DomesticAirports.add(pune);

    }

    @Test
    public void testGetShortestRoute() throws Exception {
        RoutePlanner routePlanner = mock(RoutePlanner.class);
        RoutePlannerFactory routePlannerFactory = mock(RoutePlannerFactory.class);
        classUnderTest.setRoutePlanner(routePlanner);
        classUnderTest.setRoutePlannerFactory(routePlannerFactory);

        when(routePlannerFactory.getRoutePlanner(SHORTEST)).thenReturn(routePlanner);
        List<Route> expectedResult = new ArrayList<Route>();
        RouteFilter userPreferences = new RouteFilter();
        when(routePlanner.getRoutesBetween(delhi, pune, userPreferences)).thenReturn(expectedResult);
        List<Route> actualResult = classUnderTest.getRoutesBetween(DELHI, PUNE, userPreferences);
        assertEquals("Incorrect routes returned", expectedResult, actualResult);


    }


    @Test
    public void shouldGetShortestRoute() throws Exception {

        Airport delhi = new Airport("delhi");
        Airport pune = new Airport("pune");
        Airport jaipur = new Airport("jaipur");
        Airport chennai = new Airport("chennai");
        Airport ambala = new Airport("ambala");

        DomesticAirports.add(delhi);
        DomesticAirports.add(pune);
        DomesticAirports.add(jaipur);
        DomesticAirports.add(chennai);
        DomesticAirports.add(ambala);

        Flight flightDJ = new Flight("delhi-jaipur", JETAIRWAYS, delhi, jaipur, 100);
        Flight flightDJL = new Flight("delhi-jaipur-Low", JETAIRWAYS, delhi, jaipur, 1);
        Flight flightDA = new Flight("delhi-ambala", JETAIRWAYS, delhi, ambala, 100);
        Flight flightJP = new Flight("jaipur-pune", JETAIRWAYS, jaipur, pune, 200);
        Flight flightPC = new Flight("pune-chennai", JETAIRWAYS, pune, chennai, 100);
        Flight flightJC = new Flight("jaipur-chennai", JETAIRWAYS, delhi, chennai, 10000);

        Airline jet = new Airline(JETAIRWAYS);
        jet.addFlight(flightDJ);
        jet.addFlight(flightDJL);
        jet.addFlight(flightJP);
        jet.addFlight(flightPC);
        jet.addFlight(flightDA);
        jet.addFlight(flightJC);
        Airlines.addCareer(JETAIRWAYS, jet);

        RouteFilter userPreferences = new RouteFilter();
        List<Route> routesBetween = classUnderTest.getRoutesBetween("delhi", "chennai", userPreferences);
        for (Route r : routesBetween) {
            System.out.println("------");
            for (Flight f : r)
                System.out.println(f.getFlightName() + "  " + f.getPrice());
        }

        userPreferences.setGeneralPreference(CHEAPEST);
        routesBetween = classUnderTest.getRoutesBetween("delhi", "chennai", userPreferences);
        for (Route r : routesBetween) {
            System.out.println("------");
            for (Flight f : r)
                System.out.println(f.getFlightName() + "  " + f.getPrice());
        }
    }
}