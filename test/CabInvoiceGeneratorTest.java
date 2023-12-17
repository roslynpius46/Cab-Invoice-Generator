import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
}
