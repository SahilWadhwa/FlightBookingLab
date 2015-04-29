package com.flightbookinglab.planner;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.Flight;
import com.flightbookinglab.model.airline.Airlines;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AirportNode {
    private AirportNode previousAirport;
    private Airport currentAirport;
    private Flight incomingFlight;

    public AirportNode(Airport currentAirport, Flight flight) {
        this.currentAirport = currentAirport;
        this.incomingFlight = flight;
    }

    public AirportNode(Airport currentAirport) {
        this.currentAirport = currentAirport;
    }

    public Set<AirportNode> getConnectedAirportNodes() {
        return Airlines.getAirportOutGoingFlights(currentAirport).stream().map(outgoingFlights -> new AirportNode(outgoingFlights.getDestination(), outgoingFlights)).collect(Collectors.toSet());
    }


    @Override
    public boolean equals(Object obj) {
        boolean cityIsSame = obj instanceof AirportNode && ((AirportNode) obj).currentAirport.getCityName().equals(this.currentAirport.getCityName());
        boolean flightIsSame = true;
        AirportNode node = (AirportNode) obj;

        if (node.getIncomingFlight() != null && getIncomingFlight() != null) {
            flightIsSame = node.getIncomingFlight().getFlightName().equals(this.getIncomingFlight().getFlightName());
        }
        return cityIsSame &&
                flightIsSame;
    }

    public Flight getIncomingFlight() {
        return incomingFlight;
    }

    public void setPreviousAirport(AirportNode previousAirport) {
        this.previousAirport = previousAirport;
    }

    public AirportNode getPreviousAirport() {
        return previousAirport;
    }
}
