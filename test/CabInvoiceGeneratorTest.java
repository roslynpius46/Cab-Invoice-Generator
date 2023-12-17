import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;
import com.bridgelabz.cabinvoicegenerator.Ride;

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
}
