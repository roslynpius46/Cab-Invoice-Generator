package com.bridgelabz.cabinvoicegenerator;

public class Main{
    public static void main(String[] args)
    {
        System.out.println("Cab Invoice Generator Implementation");

        // Example journey details: 5 kilometers, 15 minutes
        double distance = 5;
        double time = 15;

        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(distance, time);

        System.out.println("Total Fare: Rs. " + fare);
    }
}
