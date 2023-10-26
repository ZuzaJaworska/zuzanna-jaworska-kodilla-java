package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightsTableFromDepartureAirport = new HashMap<>();
        flightsTableFromDepartureAirport.put("JFK", true);
        flightsTableFromDepartureAirport.put("ICN", true);
        flightsTableFromDepartureAirport.put("NRT", true);
        flightsTableFromDepartureAirport.put("REP", false);
        flightsTableFromDepartureAirport.put("SIN", false);
        flightsTableFromDepartureAirport.put("MRU", false);

        if (flightsTableFromDepartureAirport.containsKey(flight.arrivalAirport)) {
            for (Map.Entry<String, Boolean> flights : flightsTableFromDepartureAirport.entrySet()) {
                if (flights.getKey().equals(flight.getArrivalAirport())) {
                    if (flights.getValue()) {
                        System.out.println("You can fly from " + flight.getDepartureAirport() + " to " + flights.getKey());
                    } else {
                        System.out.println("There's no route from " + flight.getDepartureAirport() + " to " + flights.getKey());
                    }
                }
            }
        } else {
            throw new RouteNotFoundException("arrival airport not found in database");
        }
    }

    public static void main(String[] args) {

        FlightFinder flightFinder = new FlightFinder();

        try {
            flightFinder.findFlight(new Flight("WAW", "JFK"));
            // for different results try arrivalAirport:
            // "SIN" (airport does exist in database, but there's no available route)
            // "BER" (airport does not exist in database)
        } catch (RouteNotFoundException e) {
            System.out.println("Error:" + e);
        } finally {
            System.out.println("Thank you for using our FlightFinder app!");
        }
    }
}
