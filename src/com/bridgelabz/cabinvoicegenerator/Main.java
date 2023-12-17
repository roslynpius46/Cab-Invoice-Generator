package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args)
    {
        System.out.println("Cab Invoice Generator Implementation");

        // Example journey details: 5 kilometers, 15 minutes
        double distance = 5;
        double time = 15;

        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(distance, time,RideCategory.NORMAL);

        System.out.println("Total Fare: Rs. " + fare);
        System.out.println();


        // Create instances of the classes
        InvoiceService invoiceService = new InvoiceService();
        RideRepository rideRepository = new RideRepository();

        // Set the RideRepository for the InvoiceService
        invoiceService.setRideRepository(rideRepository);

        // Add rides for a user
        List<Ride> userRides = new ArrayList<>();
        userRides.add(new Ride(5, 15,RideCategory.NORMAL)); // Ride 1: 5 kilometers, 15 minutes
        userRides.add(new Ride(3, 10,RideCategory.NORMAL)); // Ride 2: 3 kilometers, 10 minutes
        rideRepository.addRides("user1", userRides);

        // Generate an invoice for the user
        String userId = "user1";
        Invoice invoice = invoiceService.generateInvoiceForUser(userId);

        // Display the invoice details
        if (invoice != null) {
            System.out.println("Invoice for User ID: " + userId);
            System.out.println("Total Rides: " + invoice.getTotalRides());
            System.out.println("Total Fare: Rs. " + invoice.getTotalFare());
            System.out.println("Average Fare Per Ride: Rs. " + invoice.getAverageFare());
        } else {
            System.out.println("No rides found for User ID: " + userId);
        }
    }
}
