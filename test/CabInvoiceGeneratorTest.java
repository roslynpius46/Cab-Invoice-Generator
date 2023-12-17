import com.bridgelabz.cabinvoicegenerator.CabInvoiceGenerator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void calculateFare_ShouldReturnMinimumFareForShortJourney() {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(2, 5); // 2 kilometers, 5 minutes
        assertEquals(25.0, fare, 0.01);
    }
}
