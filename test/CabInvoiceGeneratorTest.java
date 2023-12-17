import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
import com.bridgelabz.cabinvoicegenerator.Ride;
import com.bridgelabz.cabinvoicegenerator.Invoice;
import com.bridgelabz.cabinvoicegenerator.RideRepository;
import com.bridgelabz.cabinvoicegenerator.InvoiceService;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CabInvoiceGeneratorTest {

    /**
     * @desc Test case to verify if fare returned is the minimum value assigned for short journeys
     */
    @Test
    public void calculateFare_ShouldReturnMinimumFareForShortJourney() {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(0.0004, 5);
        assertEquals(5.0, fare, 0.01);
    }

    /**
     * @desc To verify if Total For Multiple Rides is returned
     */
    @Test
    public void calculateTotalFare_ShouldReturnTotalForMultipleRides() {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();

        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(5, 15)); // Ride 1: 5 kilometers, 15 minutes
        rides.add(new Ride(3, 10)); // Ride 2: 3 kilometers, 10 minutes

        double totalFare = invoiceGenerator.calculateTotalFare(rides);

        assertEquals(105.0, totalFare, 0.01);
    }

    /**
     * @desc To verify enhanced invoice
     */
    @Test
    public void generateInvoice_ShouldReturnEnhancedInvoice() {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();

        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(5, 15)); // Ride 1: 5 kilometers, 15 minutes
        rides.add(new Ride(3, 10)); // Ride 2: 3 kilometers, 10 minutes

        Invoice invoice = invoiceGenerator.generateInvoice(rides);

        assertEquals(2, invoice.getTotalRides());
        assertEquals(105.0, invoice.getTotalFare(), 0.01);
        assertEquals(52.5, invoice.getAverageFare(), 0.01);
    }

    /**
     * To verify if the function returns invoice for a given user
     */
    @Test
    public void generateInvoiceForUser_ShouldReturnInvoiceForGivenUserId() {
        InvoiceService invoiceService = new InvoiceService();
        RideRepository rideRepository = new RideRepository();

        // Assume rides for a specific user with ID "user1"
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(5, 15));
        rides.add(new Ride(3, 10));

        // Assume the user ID "user1"
        String userId = "user1";

        // Stub the RideRepository to return rides for the given user ID
        rideRepository.addRides(userId, rides);
        invoiceService.setRideRepository(rideRepository);

        Invoice invoice = invoiceService.generateInvoiceForUser(userId);

        assertEquals(2, invoice.getTotalRides());
        assertEquals(105.0, invoice.getTotalFare(), 0.01);
        assertEquals(52.5, invoice.getAverageFare(), 0.01);
    }

}
