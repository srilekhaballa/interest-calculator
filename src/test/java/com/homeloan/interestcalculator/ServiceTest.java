package com.homeloan.interestcalculator;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.homeloan.interestcalculator.service.InterestCalculatorService;

public class ServiceTest extends InterestCalculatorApplicationTests {
	
	@Test
	public void getTotalInterest() {
		double loanAmount=2000000.0;
		double tenure= 20.0;
		
		InterestCalculatorService interestCalculator =new InterestCalculatorService();
		assertNotNull(interestCalculator.getTotalInterest(loanAmount, tenure));
	}
}
