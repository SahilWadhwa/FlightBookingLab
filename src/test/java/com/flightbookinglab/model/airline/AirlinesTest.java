package com.flightbookinglab.model.airline;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.Flight;
import com.flightbookinglab.utilities.AirlineBuilder;
import org.junit.Before;
import org.junit.Test;

import static com.flightbookinglab.model.airline.Operator.INDIGO;
import static org.junit.Assert.assertTrue;

public class AirlinesTest {

    private Airlines airlines;

    public static final String DELHI = "delhi";
    public static final String PUNE = "pune";
    Airport delhi;
    Airport pune;
    Flight indigoFlightDP;
    Airline indigo;


    @Before
    public void setUp() throws Exception {
        delhi = new Airport(DELHI);
        pune = new Airport(PUNE);

        indigoFlightDP = new Flight("delhi-pune", INDIGO, delhi, pune, 100);

        indigo = AirlineBuilder.getInstance().forOperator(INDIGO).withFlight(indigoFlightDP).build();
    }


    @Test
    public void shouldStoreAllOperatingAirlinesFlights() throws Exception {

        airlines.addCareer(INDIGO, indigo);
        assertTrue(airlines.getAirportOutGoingFlights(delhi).contains(indigoFlightDP));
    }

    @Test
    public void shouldReturnAirlineFleetByOperator() throws Exception {
        airlines.addCareer(INDIGO, indigo);
        assertTrue(airlines.getAirlinesByOperator(INDIGO).equals(indigo));

    }
}