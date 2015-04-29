package com.flightbookinglab.model;

import com.flightbookinglab.planner.PlannerType;

public class RouteFilter {
    private PlannerType generalPreference = PlannerType.SHORTEST;

    public PlannerType getGeneralPreference() {
        return generalPreference;
    }

    public void setGeneralPreference(PlannerType generalPreference) {
        this.generalPreference = generalPreference;
    }
}
