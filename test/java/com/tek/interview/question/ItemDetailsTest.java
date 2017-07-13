package com.tek.interview.question;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemDetailsTest {

	@Test
	public void test() {
		ItemDetails detail=new ItemDetails("Test", (float)12.20);
		detail.setPrice((float)12.30);
		detail.setDescription("TestDesc");
		assertEquals((float)12.30,detail.getPrice(),0);	
		assertEquals("TestDesc",detail.getDescription());
	}

}
