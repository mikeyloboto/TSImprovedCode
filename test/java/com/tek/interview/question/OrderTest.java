package com.tek.interview.question;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testNullObject() {
		Order order=new Order();
		try{
			order.addOrderDetails(null);
			fail("Exception Should throw");
		}
		catch(IllegalArgumentException exp){
			assertEquals("Order is NULL", exp.getMessage());
		}
	}

}
