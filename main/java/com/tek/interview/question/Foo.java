//package com.tek.interview.question;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
///* ****************************************************************************************
//
//Please remove all bugs from the code below to get the following output:
//
//<pre>
//
//*******Order 1*******
//1 book: 13.74
//1 music CD: 16.49
//1 chocolate bar: 0.94
//Sales Tax: 2.84
//Total: 28.33
//*******Order 2*******
//1 imported box of chocolate: 11.5
//1 imported bottle of perfume: 54.62
//Sales Tax: 8.62
//Total: 57.5
//*******Order 3*******
//1 Imported bottle of perfume: 32.19
//1 bottle of perfume: 20.89
//1 packet of headache pills: 10.73
//1 box of imported chocolates: 12.94
//Sales Tax: 8.77
//Total: 67.98
//Sum of orders: 153.81
//
//</pre>
//
//******************************************************************************************** */
//
///*
// * represents an item, contains a price and a description.
// *
// */
//class Item {
//
//    private String description;
//    private float price;
//
//    public Item(String description, float price) {
//        super();
//        this.description = description;
//        this.price = price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//}
//
///*
// * represents an order line which contains the @link Item and the quantity.
// *
// */
//class OrderLine {
//
//    private int quantity;
//    private Item item;
//
//    /*
//     * @param item Item of the order
//     *
//     * @param quantity Quantity of the item
//     */
//    public OrderLine(Item item, int quantity) throws Exception {
//        if (item == null) {
//            System.err.println("ERROR - Item is NULL");
//            throw new Exception("Item is NULL");
//        }
//        assert quantity > 0;
//        this.item = item;
//        this.quantity = quantity;
//    }
//
//    public Item getItem() {
//        return item;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//}
//
//class Order {
//
//    private List<OrderLine> orderLines;
//
//    public Order() {
//        orderLines=new ArrayList<>();
//    }
//
//    public void add(OrderLine o) throws Exception {
//
//        if (o == null) {
//            System.err.println("ERROR - Order is NULL");
//            throw new IllegalArgumentException("Order is NULL");
//        }
//        orderLines.add(o);
//    }
//
//    public int size() {
//        return orderLines.size();
//    }
//
//    public OrderLine get(int i) {
//        return orderLines.get(i);
//    }
//
//
//    public void clear() {
//        this.orderLines.clear();
//    }
//}
//
//class calculator {
//	//Rounding Function which rounds the number in 2 Digit after decimal point.
//	public static float rounding(double value) {
//        return (float) Math.round(value * 100) / 100;
//    }
//
//	/**
//     * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
//     * is the item's price * quantity * taxes.
//     *
//     * For each order, print the total Sales Tax paid and Total price without taxes for this order
//     */
//    public void calculate(Map<String, Order> o) {
//
//        double grandtotal = 0;
//
//        // Iterate through the orders
//        for (Map.Entry<String, Order> entry : o.entrySet()) {
//            System.out.println("*******" + entry.getKey() + "*******");
//            
//
//            Order r = entry.getValue();
//
//            double totalTax = 0;
//            double total = 0;
//
//            // Iterate through the items in the order
//            for (int i = 0; i < r.size(); i++) {
//
//                //Initializing Tax
//                double tax = 0;
//
//                // Calculate the taxes
//                if (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
//                	// imported items
//                    tax = rounding(r.get(i).getItem().getPrice() *r.get(i).getQuantity() * 0.15); // Extra 5% tax on
//                 } else {
//                    tax = rounding(r.get(i).getItem().getPrice() *r.get(i).getQuantity()* 0.10);
//                }
//
//                // Calculate the total price
//                double totalprice = (r.get(i).getItem().getPrice()*r.get(i).getQuantity())+ tax;
//
//                // Print out the item's price
//                System.out.println(r.get(i).getItem().getDescription() + ": " + rounding(totalprice));
//
//                // Keep a running total
//                totalTax += tax;
//                total += r.get(i).getItem().getPrice()*r.get(i).getQuantity();
//            }
//
//            // Print out the total taxes
//            System.out.println("Sales Tax: " + rounding(totalTax));
//
//            // Print out the total amount
//            System.out.println("Total: " + rounding(total));
//            grandtotal += total;
//        }
//
//        System.out.println("Sum of orders: " + rounding(grandtotal) );
//    }
//}
//
//public class Foo {
//
//    public static void main(String[] args) throws Exception {
//    	
//    	//Linked Hash Map for preventing the order.
//        Map<String, Order> o = new LinkedHashMap<String, Order>();
//
//        Order c = new Order();
//
//
//        c.add(new OrderLine(new Item("book", (float) 12.49), 1));
//        c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
//        c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));
//
//        o.put("Order 1", c);
//
//        // Reuse cart for an other order
//        c = new Order();
//
//        c.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
//        c.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));
//
//        o.put("Order 2", c);
//
//        // Reuse cart for an other order
//        c = new Order();
//
//        c.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
//        c.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
//        c.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
//        c.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));
//
//        o.put("Order 3", c);
//
//        new calculator().calculate(o);
//
//    }
//}