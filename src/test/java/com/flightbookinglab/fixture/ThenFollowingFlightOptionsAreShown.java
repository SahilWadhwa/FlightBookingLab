package com.flightbookinglab.fixture;

import com.flightbookinglab.model.Flight;
import com.flightbookinglab.model.Route;
import fit.RowFixture;

public class ThenFollowingFlightOptionsAreShown extends RowFixture {
    @Override
    public Object[] query() throws Exception {
        GivenFlights[] flightOptions;

        if(RoutesResult.getResult().isEmpty())
        {   flightOptions = new GivenFlights[1];
            flightOptions[0]=new GivenFlights("No Flight Available", RoutesResult.source, RoutesResult.destination,"No Flight Available",0);
            return flightOptions;
        }

        Route route = new Route();
        for(Route r : RoutesResult.getResult())
        {
            route.addAll(r);
        }
        flightOptions = new GivenFlights[route.size()];


        for (int i = 0; i < route.size(); i++) {
            Flight flight = route.get(i);
            GivenFlights flightOption = new GivenFlights();

            flightOption.setFlightName(flight.getFlightName());
            flightOption.setSource(flight.getSource().getCityName());
            flightOption.setDestination(flight.getDestination().getCityName());
            flightOption.setOperatorName(flight.getCareer().toString());
            flightOption.setPrice(flight.getPrice());

            flightOptions[i] = flightOption;

        }


        return flightOptions;
    }

    @Override
    public Class<?> getTargetClass() {
        return GivenFlights.class;
    }
}
