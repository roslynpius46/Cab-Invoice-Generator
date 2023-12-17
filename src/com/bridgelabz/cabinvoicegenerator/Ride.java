package com.bridgelabz.cabinvoicegenerator;

/**
 * @desc Represents a ride with distance and time details.
 */
public class Ride {

    private double distance;
    private double time;
    private RideCategory rideCategory;

    /**
     * @desc Constructs a new Ride object with the given distance and time.
     * @param distance The distance traveled in kilometers.
     * @param time     The time taken for the ride in minutes.
     */
    public Ride(double distance, double time, RideCategory rideCategory) {
        this.distance = distance;
        this.time = time;
        this.rideCategory = rideCategory;
    }

    /**
     * @desc Gets the distance of the ride.
     * @return The distance of the ride in kilometers.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @desc Gets the time taken for the ride.
     * @return The time taken for the ride in minutes.
     */
    public double getTime() {
        return time;
    }

    /**
     * @desc Gets the ride category.
     * @return Ride category
     */
    public RideCategory getRideCategory() {
        return rideCategory;
    }
}
