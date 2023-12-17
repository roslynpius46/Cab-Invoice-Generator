package com.bridgelabz.cabinvoicegenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc Class to store and retrieve ride details for users.
 */
public class RideRepository {

    private Map<String, List<Ride>> userRides;

    /**
     * @desc Initializes an empty RideRepository with a map to store user rides.
     */
    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    /**
     * @desc Adds rides for a specific user to the repository.
     * @param userId The unique identifier for the user.
     * @param rides  A list of Ride objects representing the rides for the user.
     */
    public void addRides(String userId, List<Ride> rides) {
        userRides.put(userId, rides);
    }

    /**
     * @desc Retrieves the list of rides for a specific user from the repository.
     * @param userId The unique identifier for the user.
     * @return A List of Ride objects representing the rides for the user.
     *         Returns null if no rides are found for the user ID.
     */
    public List<Ride> getRides(String userId) {
        return userRides.getOrDefault(userId, null);
    }
}