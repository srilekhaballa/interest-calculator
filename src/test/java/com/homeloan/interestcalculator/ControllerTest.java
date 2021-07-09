package com.homeloan.interestcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import com.homeloan.interestcalculator.controller.InterestCalculatorController;
import com.homeloan.interestcalculator.dao.HomeLoan;
import com.homeloan.interestcalculator.dao.TotalInterest;
import com.homeloan.interestcalculator.service.InterestCalculatorService;
import com.lowagie.text.DocumentException;

@WebMvcTest
public class ControllerTest extends InterestCalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private InterestCalculatorService interestCalculatorService;

	@InjectMocks
	private InterestCalculatorController interestCalculatorController;

	TotalInterest ti;

	@Test
	public void getLoanDetails(HomeLoan hi) throws Exception {
		TotalInterest ti = new TotalInterest();
		ti.setTotalAmount(4600000.0);
		ti.setTotalInterest(2600000.0);
		when(interestCalculatorService.getTotalInterest(hi.getLoanAmount(), hi.getTenure())).thenReturn(ti);
		assertEquals(HttpStatus.OK,interestCalculatorController.getLoanDetails(hi));
	}

	
	 @Test 
	 public void exportToPDF(HttpServletResponse response,HomeLoan hi) throws DocumentException, IOException {
		  doNothing().when(interestCalculatorController).exportToPDF(response,hi);
		  verify(interestCalculatorController,times(1)).exportToPDF(response,hi); 
	 }
	 
}
