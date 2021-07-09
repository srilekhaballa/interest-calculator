package com.homeloan.interestcalculator.service;

import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import com.homeloan.interestcalculator.dao.TotalInterest;

@Service
public class InterestCalculatorService {
	
	private static final Logger logger = java.util.logging.Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public TotalInterest getTotalInterest(double loanAmount,double tenure) {
		TotalInterest ti=new TotalInterest();
		try {
		if(loanAmount > 0 && loanAmount < 3000000) {
			ti.totalInterest =  (loanAmount*tenure*6.5)/100;
		}
		else if(loanAmount >= 3100000 && loanAmount < 5000000) {
			ti.totalInterest=(loanAmount*tenure*7.5)/100;
		}
		else if(loanAmount >= 5000000 && loanAmount < 9000000) {
			ti.totalInterest=(loanAmount*tenure*9.0)/100;
		}
		ti.totalAmount=loanAmount+ti.totalInterest;
		
	}
		catch (IllegalArgumentException e)
		{
			logger.info("Invalid input");
		}
		return ti;
	}	
	
}
