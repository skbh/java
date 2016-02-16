package com.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {

	private Calculator cal; 

	@Before
	public void setUp() throws Exception {
		cal=new Calculator();
	}

	
	@Test
	public void testAdd() {
		int result=cal.add(1,25,69,85,12);
		assertEquals(192, result);
	}

	@Test
	public void testMult() {
		long result=cal.mult(1,2,3);
		assertEquals(6, result);
	}
	
	@Ignore
	@Test(expected=NullPointerException.class,timeout=1)
	public void testlengthOfString() {
		int result=cal.lengthOfString("sushil");
		assertEquals(6, result);
	}

}
