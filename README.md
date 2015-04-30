# FlightBookingLab 
Build Status:  <img src="https://travis-ci.org/SahilWadhwa/FlightBookingLab.svg?branch=master" alt="Travis CI Status"/>    https://travis-ci.org/SahilWadhwa/FlightBookingLab


**To Run Fitnesse Test:**
1. From terminal Goto :     /FlightBookingLab/Fitnesse
2. Run fitnesse server:     java -jar fitnesse.jar -p 8081
3. Open Browesr and goto:   http://localhost:8081/FitNesse.SuiteAcceptanceTests.FlightPlanner



**Scenarios covered**
1. User can search for flights with less connection between source and destination.
2. User can search for flights with cheapest connection between source and destination.
3. Multiple route connections can be returned if avaialble.

**Scalability (Scenarios that can be added with ease)**
1. New Airline Operators can be added by Modifying Operator.java
2. Any number of flights can be added to an Airline.
3. RouteFilter can modified to set user preferences like Airline Operator preference, Flight Name Preference etc.
4. International airports can be added with ease by using similar business logic as of Domestic Airports.
