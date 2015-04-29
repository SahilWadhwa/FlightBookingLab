package com.flightbookinglab.fixture;

import com.flightbookinglab.model.Airport;
import com.flightbookinglab.model.DomesticAirports;
import fit.ColumnFixture;

public class GivenExistingAirport extends ColumnFixture {
    public String cityName;

    @Override
    public void execute() throws Exception {
        Airport airport = new Airport(cityName);
        DomesticAirports.add(airport);
        super.execute();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
