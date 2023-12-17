package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

/**
 * @desc This class represents a cab invoice generator
 */
public class CabInvoiceGenerator {

    private static final double NORMAL_COST_PER_KM = 10.0;
    private static final double NORMAL_COST_PER_MINUTE = 1.0;
    private static final double NORMAL_MINIMUM_FARE = 5.0;

    private static final double PREMIUM_COST_PER_KM = 15.0;
    private static final double PREMIUM_COST_PER_MINUTE = 2.0;
    private static final double PREMIUM_MINIMUM_FARE = 20.0;

    /**
     * @desc Calculate total fare given distance, time, and ride category
     * @param distance      total distance of journey
     * @param time          total time of journey
     * @param rideCategory  category of the ride (NORMAL or PREMIUM)
     * @return totalFare if it is more than the minimum fare
     */
    public double calculateFare(double distance, double time, RideCategory rideCategory) {
        if (rideCategory == RideCategory.NORMAL) {
            return calculateNormalFare(distance, time);
        } else if (rideCategory == RideCategory.PREMIUM) {
            return calculatePremiumFare(distance, time);
        }
        return 0.0; // Default case, should not happen in a valid scenario
    }

    /**
     * @desc Calculation of fare for normal ride
     * @param distance Total distance
     * @param time Total time
     * @return Total fare for normal ride
     */
    private double calculateNormalFare(double distance, double time) {
        double totalFare = distance * NORMAL_COST_PER_KM + time * NORMAL_COST_PER_MINUTE;
        return Math.max(totalFare, NORMAL_MINIMUM_FARE);
    }

    /**
     * @desc Calculation of fare for premium ride
     * @param distance Total distance
     * @param time Total time
     * @return Total fare for premium ride
     */
    private double calculatePremiumFare(double distance, double time) {
        double totalFare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MINUTE;
        return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
    }

    /**
     * @desc Calculates total fare for all the rides
     * @param rides The list of rides for which to calculate the total fare.
     * @return Total fare of all the rides
     */
    public double calculateTotalFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideCategory());
        }
        return totalFare;
    }

    /**
     * @desc Generates an invoice for a list of rides
     * @param rides The list of rides for which to generate the invoice.
     * @return Invoice object containing details such as total rides, total fare, and average fare per ride.
     */
    public Invoice generateInvoice(List<Ride> rides) {
        int totalRides = rides.size();
        double totalFare = calculateTotalFare(rides);
        return new Invoice(totalRides, totalFare);
    }
}
