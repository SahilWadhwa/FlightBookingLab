package com.flightbookinglab.fixture;

import com.flightbookinglab.model.Route;

import java.util.ArrayList;
import java.util.List;

public class RoutesResult {
    private static List<Route> routeList = new ArrayList<Route>();;
    public static String source;
    public static String destination;

    public static void addResult(List<Route> result, String s, String d)
    {
        routeList.clear();
        routeList.addAll(result);
        source = s;
        destination = d;
    }

    public static List<Route> getResult() {
        return routeList;
    }
}
