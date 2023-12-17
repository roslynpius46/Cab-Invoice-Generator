package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

/**
 * @desc This class represents a cab invoice generator
 */
public class CabInvoiceGenerator {

    private static final double COST_PER_KM = 10.0;
    private static final double COST_PER_MINUTE = 1.0;
    private static final double MINIMUM_FARE = 5.0;

    /**
     * @desc Calculate total fare given distance and time
     * @param distance total distance of journey
     * @param time total time of journey
     * @return totalFare if it is more than the minimum fare
     */
    public double calculateFare(double distance, double time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * @desc Calculates total fare for all the rides
     * @param rides The list of rides for which to calculate the total fare.
     * @return Total fare of all the rides
     */
    public double calculateTotalFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

}