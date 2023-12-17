package com.bridgelabz.cabinvoicegenerator;

/**
 * @desc Represents an invoice containing details such as the total number of rides,total fare, and average fare per ride.
 */
public class Invoice {

    private int totalRides;
    private double totalFare;

    /**
     * @desc Constructs a new Invoice object with the given total number of rides and total fare.
     * @param totalRides The total number of rides included in the invoice.
     * @param totalFare  The total fare for all rides in the invoice.
     */
    public Invoice(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
    }

    /**
     * @desc Gets the total number of rides included in the invoice.
     * @return The total number of rides.
     */
    public int getTotalRides() {
        return totalRides;
    }

    /**
     * @desc Gets the total fare for all rides included in the invoice.
     * @return The total fare for all rides.
     */
    public double getTotalFare() {
        return totalFare;
    }

    /**
     * @desc Calculates and returns the average fare per ride in the invoice.
     * @return The average fare per ride.
     */
    public double getAverageFare() {
        return totalFare / totalRides;
    }
}