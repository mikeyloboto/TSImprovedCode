package com.tek.interview.question;

import java.util.Map;

public class CalculateUtil {
	
	
	private static final float IMPORTED_ITEM_TAX = (float) 0.15; // That is 15%.
	private static final float STANDARD_TAX = (float) 0.10; // That is 10%.
	
	//Rounding Function which rounds the number in 2 Digit after decimal point.
    public static float rounding(double value) {
        return (float) Math.round(value * 100) / 100;
    }

    /**
     * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
     * is the item's price * quantity * taxes.
     *
     * For each order, print the total Sales Tax paid and Total price without taxes for this order
     */
    public void calculate(Map<String, Order> o) {

        double grandTotal = 0;

        // Iterate through the orders
        for (Map.Entry<String, Order> entry : o.entrySet()) {
            System.out.println("*******" + entry.getKey() + "*******");

            Order order = entry.getValue();

            double totalTax = 0;
            double totalForOrder = 0;

            // Iterate through the items in the order
            for (int i = 0; i < order.getOrderSize(); i++) {

                //Initializing Tax
                double tax = 0;

                String itemDescription=order.get(i).getItemDetails().getDescription();
                
                //Total Price for Item without Tax. i.e. No Of Items*Item Price.
                float totalIteamPriceWithoutTax=order.get(i).getItemDetails().getPrice()*order.get(i).getQuantity();                

                // Calculate the taxes
                if (itemDescription.toLowerCase().contains("imported")) {
                    // Imported items
                    tax = rounding(totalIteamPriceWithoutTax * IMPORTED_ITEM_TAX); // Extra 5% tax on
                } else {
                    tax = rounding(totalIteamPriceWithoutTax * STANDARD_TAX);
                }

                // Calculate the total price
                double totalPriceWithTax = totalIteamPriceWithoutTax+ tax;
                
                // Print out the item's price with Tax
                System.out.println(itemDescription + ": " + rounding(totalPriceWithTax));

                // Keep a running total
                totalTax += tax;
                totalForOrder += totalIteamPriceWithoutTax;
            }

            // Print out the total taxes
            System.out.println("Sales Tax: " + rounding(totalTax));

            // Print out the total amount
            System.out.println("Total: " + rounding(totalForOrder));
            grandTotal += totalForOrder;
        }

        System.out.println("Sum of orders: " + rounding(grandTotal));
    }

}
