package com.homeloan.interestcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homeloan.interestcalculator.controller.InterestCalculatorController;

@SpringBootTest
class InterestCalculatorApplicationTests {

	@Autowired
	private InterestCalculatorController interestCalculator;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(interestCalculator).isNotNull();
	}

}
