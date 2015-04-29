package com.flightbookinglab.fixture;

import com.flightbookinglab.controller.BookingController;
import com.flightbookinglab.model.Route;
import com.flightbookinglab.model.RouteFilter;
import fit.ColumnFixture;

import java.util.List;

import static com.flightbookinglab.planner.PlannerType.CHEAPEST;

public class WhenUserSearchForFlightWithCheapestConnectionsBetween extends ColumnFixture {
    private String Source;
    private String Destination;

    public void execute() throws Exception {
        RouteFilter userPreference = new RouteFilter();
        userPreference.setGeneralPreference(CHEAPEST);

        BookingController bookingController = new BookingController();
        List<Route> result = bookingController.getRoutesBetween(getSource(), getDestination(), userPreference);
        RoutesResult.addResult(result, getSource(), getDestination());
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }
}
