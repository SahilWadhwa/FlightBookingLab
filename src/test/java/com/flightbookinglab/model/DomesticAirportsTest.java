package com.flightbookinglab.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertSame;

public class DomesticAirportsTest {

    private DomesticAirports domesticAirports;
    public static final String DELHI = "delhiAirport";
    public static final String PUNE = "puneAirport";
    Airport delhiAirport;
    Airport puneAirport;


    @Before
    public void setUp() throws Exception {
        delhiAirport = new Airport(DELHI);
        puneAirport = new Airport(PUNE);
    }

    @Test
    public void shouldAddAndGetAirportByName() throws Exception {
        domesticAirports.add(delhiAirport);
        domesticAirports.add(puneAirport);
        assertSame(domesticAirports.getAirport(DELHI), delhiAirport);
        assertSame(domesticAirports.getAirport(PUNE), puneAirport);


    }
}