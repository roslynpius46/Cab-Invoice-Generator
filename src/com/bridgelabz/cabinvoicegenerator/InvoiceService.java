package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

/**
 * @desc Class to generate invoices for a given user ID based on rides stored in a repository.
 */
public class InvoiceService {

    private RideRepository rideRepository;

    /**
     * @desc Sets the RideRepository for the InvoiceService.
     * @param rideRepository The RideRepository instance to be set.
     */
    public void setRideRepository(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    /**
     * @desc Generates an invoice for a given user ID.
     * @param userId The unique identifier for the user.
     * @return An Invoice object containing details such as the total number of rides,
     *         total fare, and average fare per ride. Returns null if no rides are found for the user ID.
     */
    public Invoice generateInvoiceForUser(String userId) {
        List<Ride> rides = rideRepository.getRides(userId);
        if (rides == null) {
            // Handle the case when no rides are found for the given user ID
            return null;
        }

        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        return invoiceGenerator.generateInvoice(rides);
    }
}
