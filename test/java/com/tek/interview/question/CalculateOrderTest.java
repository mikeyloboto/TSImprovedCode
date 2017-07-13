package com.tek.interview.question;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.CalculateOrder;

public class CalculateOrderTest {
	
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
		
	String expected="*******Order 1*******\nbook: 13.74\nmusic CD: 16.49\nchocolate bar: 0.94\nSales Tax: 2.84\nTotal: 28.33\n*******Order 2*******\nimported box of chocolate: 11.5\nimported bottle of perfume: 54.63\nSales Tax: 8.63\nTotal: 57.5\n*******Order 3*******\nImported bottle of perfume: 32.19\nbottle of perfume: 20.89\npacket of headache pills: 10.73\nbox of imported chocolates: 12.94\nSales Tax: 8.77\nTotal: 67.98\nSum of orders: 153.81\n";
	CalculateOrder order=new CalculateOrder();
	order.main(null);
	assertEquals(expected,outContent.toString());
		
	}


}
