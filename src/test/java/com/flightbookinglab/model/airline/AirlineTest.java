package com.flightbookinglab.model.airline;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.Flight;
import org.junit.Before;
import org.junit.Test;

import static com.flightbookinglab.model.airline.Operator.INDIGO;
import static com.flightbookinglab.model.airline.Operator.JETAIRWAYS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AirlineTest {
    public static final String DELHI = "delhi";
    public static final String PUNE = "pune";
    Airport delhi;
    Airport pune;
    Flight indigoFlightDP;
    Flight indigoFlightPD;

    private Airline classUnderTest;

    @Before
    public void setUp() throws Exception {
        delhi = new Airport(DELHI);
        pune = new Airport(PUNE);

        indigoFlightDP = new Flight("delhi-pune", INDIGO, delhi, pune, 100);
        indigoFlightPD = new Flight("pune-delhi", INDIGO, pune, delhi, 100);
    }


    @Test
    public void shouldSetOperatorAndFlightDetails() throws Exception {
        classUnderTest = new Airline(INDIGO);
        classUnderTest.addFlight(indigoFlightDP);
        classUnderTest.addFlight(indigoFlightPD);
        assertTrue(classUnderTest.getOperator().equals(INDIGO));
        assertTrue(classUnderTest.getOutgoingFlights().containsKey(delhi));
        assertTrue(classUnderTest.getOutgoingFlights().containsKey(pune));
        assertTrue(classUnderTest.getOutgoingFlights().get(delhi).contains(indigoFlightDP));
        assertTrue(classUnderTest.getOutgoingFlights().get(pune).contains(indigoFlightPD));
    }

    @Test
    public void shouldNotAddFlightsFromOtherOperators() throws Exception {
        classUnderTest = new Airline(JETAIRWAYS);
        classUnderTest.addFlight(indigoFlightDP);
        assertFalse(classUnderTest.getOutgoingFlights().containsKey(delhi));
    }
}