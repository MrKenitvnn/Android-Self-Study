package com.example.appdemo.test;

import com.example.appdemo.process.Calculator;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase{
	
	Calculator cal;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		cal = new Calculator();
	}
	
	
	public void testDivisionCalculate (double expect, double act) {
		
		double expected = 5;
		System.out.println("Kết quả mong đợi = " + expected);
		
		double actual = 0;
		try {
			actual  = cal.divisionCalculate(10, 2);
			System.out.println( " \n\rKết quả thực tế = " + actual);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot div by 0");
		}
		
		assertEquals(true, expected == actual);
	}

}
