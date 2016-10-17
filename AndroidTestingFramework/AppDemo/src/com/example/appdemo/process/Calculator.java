package com.example.appdemo.process;

public class Calculator {

	public double divisionCalculate (double firstNum, double secondNum) throws Exception {
		double result = 0;
		
		if (secondNum == 0) {
			throw new Exception("Error: Division by zero");
		} else {
			result = firstNum/secondNum;
		}
		
		return result;
	}
	
	
}
