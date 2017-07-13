package com.tek.interview.question;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderDetailsTest {

	@Test
	public void testNullObject() {

		try{
			new OrderDetails(null, 2);
			fail("Exception Should throw");
		}
		catch(IllegalArgumentException exp){
			assertEquals("Item is NULL", exp.getMessage());
		}
		
		
	}
	
	@Test
	public void testNoQuantity() {

			ItemDetails itemDetails=new ItemDetails("Test", (float)12.20);

			OrderDetails orderDetails=new OrderDetails(itemDetails,0);
			
			assertEquals(0, orderDetails.getQuantity());
		
		
	}
	
	@Test
	public void testSetPojo() {
		ItemDetails itemDetails=new ItemDetails("Test", (float)12.20);

		OrderDetails orderDetails=new OrderDetails(itemDetails, 2);
		orderDetails.setQuantity(3);
		assertEquals(3, orderDetails.getQuantity());
		
		
	}

}
