package com.tek.interview.question;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.CalculateOrder;

public class CalculateUtilTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testHappyPath() throws Exception {
		
	String expected="*******Order 1*******\nbook: 13.74\nmusic CD: 16.49\nchocolate bar: 0.94\nSales Tax: 2.84\nTotal: 28.33\n*******Order 2*******\nimported box of chocolate: 11.5\nimported bottle of perfume: 54.63\nSales Tax: 8.63\nTotal: 57.5\n*******Order 3*******\nImported bottle of perfume: 64.38\nbottle of perfume: 20.89\npacket of headache pills: 10.73\nbox of imported chocolates: 25.88\nSales Tax: 14.66\nTotal: 107.22\nSum of orders: 193.05\n";
	//Linked Hash Map for preventing the order.
    Map<String, Order> orderMap = new LinkedHashMap<String, Order>();

    Order order = new Order();


    order.addOrderDetails(new OrderDetails(new ItemDetails("book", (float) 12.49), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("music CD", (float) 14.99), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("chocolate bar", (float) 0.85), 1));

    orderMap.put("Order 1", order);

    // Reuse cart for an other order
    order = new Order();

    order.addOrderDetails(new OrderDetails(new ItemDetails("imported box of chocolate", 10), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("imported bottle of perfume", (float) 47.50), 1));

    orderMap.put("Order 2", order);

    // Reuse cart for an other order
    order = new Order();

    order.addOrderDetails(new OrderDetails(new ItemDetails("Imported bottle of perfume", (float) 27.99), 2));
    order.addOrderDetails(new OrderDetails(new ItemDetails("bottle of perfume", (float) 18.99), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("packet of headache pills", (float) 9.75), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("box of imported chocolates", (float) 11.25), 2));

    orderMap.put("Order 3", order);
    
    CalculateUtil util=new CalculateUtil();

    util.calculate(orderMap);
	
	assertEquals(expected,outContent.toString());
		
	}
	
	@Test
	public void testHappyPath2() throws Exception {
		
	String expected="*******Order 1*******\nbook: 13.74\nmusic CD: 16.49\nchocolate bar: 0.94\nSales Tax: 2.84\nTotal: 28.33\n*******Order 2*******\nimported box of chocolate: 11.5\nimported bottle of perfume: 54.63\nSales Tax: 8.63\nTotal: 57.5\n*******Order 3*******\nImported bottle of perfume: 32.19\nbottle of perfume: 20.89\npacket of headache pills: 10.73\nbox of imported chocolates: 12.94\nSales Tax: 8.77\nTotal: 67.98\nSum of orders: 153.81\n";

	//Linked Hash Map for preventing the order.
    Map<String, Order> orderMap = new LinkedHashMap<String, Order>();

    Order order = new Order();


    order.addOrderDetails(new OrderDetails(new ItemDetails("book", (float) 12.49), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("music CD", (float) 14.99), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("chocolate bar", (float) 0.85), 1));

    orderMap.put("Order 1", order);

    // Reuse cart for an other order
    order = new Order();

    order.addOrderDetails(new OrderDetails(new ItemDetails("imported box of chocolate", 10), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("imported bottle of perfume", (float) 47.50), 1));

    orderMap.put("Order 2", order);

    // Reuse cart for an other order
    order = new Order();

    order.addOrderDetails(new OrderDetails(new ItemDetails("Imported bottle of perfume", (float) 27.99), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("bottle of perfume", (float) 18.99), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("packet of headache pills", (float) 9.75), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("box of imported chocolates", (float) 11.25), 1));

    orderMap.put("Order 3", order);
    
    CalculateUtil util=new CalculateUtil();

    util.calculate(orderMap);
	
	assertEquals(expected,outContent.toString());
		
	}
	
	@Test
	public void testHappyWithZeroItem() throws Exception {
		
	String expected="*******Order 1*******\nbook: 13.74\nmusic CD: 16.49\nchocolate bar: 0.94\nSales Tax: 2.84\nTotal: 28.33\n*******Order 2*******\nimported box of chocolate: 11.5\nimported bottle of perfume: 54.63\nSales Tax: 8.63\nTotal: 57.5\n*******Order 3*******\nImported bottle of perfume: 0.0\nbottle of perfume: 20.89\npacket of headache pills: 10.73\nbox of imported chocolates: 12.94\nSales Tax: 4.57\nTotal: 39.99\nSum of orders: 125.82\n";

	//Linked Hash Map for preventing the order.
    Map<String, Order> orderMap = new LinkedHashMap<String, Order>();

    Order order = new Order();


    order.addOrderDetails(new OrderDetails(new ItemDetails("book", (float) 12.49), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("music CD", (float) 14.99), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("chocolate bar", (float) 0.85), 1));

    orderMap.put("Order 1", order);

    // Reuse cart for an other order
    order = new Order();

    order.addOrderDetails(new OrderDetails(new ItemDetails("imported box of chocolate", 10), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("imported bottle of perfume", (float) 47.50), 1));

    orderMap.put("Order 2", order);

    // Reuse cart for an other order
    order = new Order();

    order.addOrderDetails(new OrderDetails(new ItemDetails("Imported bottle of perfume", (float) 27.99), 0));
    order.addOrderDetails(new OrderDetails(new ItemDetails("bottle of perfume", (float) 18.99), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("packet of headache pills", (float) 9.75), 1));
    order.addOrderDetails(new OrderDetails(new ItemDetails("box of imported chocolates", (float) 11.25), 1));

    orderMap.put("Order 3", order);
    
    CalculateUtil util=new CalculateUtil();

    util.calculate(orderMap);
	
	assertEquals(expected,outContent.toString());
		
	}


}
