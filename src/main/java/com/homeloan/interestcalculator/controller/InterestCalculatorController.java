package com.homeloan.interestcalculator.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.homeloan.interestcalculator.dao.HomeLoan;
import com.homeloan.interestcalculator.dao.TotalInterest;
import com.homeloan.interestcalculator.service.InterestCalculatorService;
import com.homeloan.interestcalculator.utils.TotalInterestPDFExporter;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping
public class InterestCalculatorController {

	@Autowired
	private InterestCalculatorService interestCalculatorService;
	
	@PostMapping("/getLoanDetails")
	public ResponseEntity<?> getLoanDetails(@Valid @RequestBody HomeLoan hi ) {
		try {
			
		 if (hi.getTenure() <= 0  && hi.getLoanAmount() <= 0 ) {
			return new ResponseEntity<String>("loanAmount and tenure are invalid", HttpStatus.CONFLICT);
		}
		 if (String.valueOf(hi.getTenure()) == null && String.valueOf(hi.getLoanAmount()) == null) {
				return new ResponseEntity<String>("loanAmount and tenure are invalid", HttpStatus.CONFLICT);
			}
				}
		catch(MethodArgumentTypeMismatchException e) {
			return new ResponseEntity<String>("loanAmount and tenure are invalid", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<TotalInterest>(interestCalculatorService.getTotalInterest(hi.getLoanAmount(), hi.getTenure()),HttpStatus.OK);
		}
	
	@PostMapping("/getLoanDetailsPDF")
	public void exportToPDF(HttpServletResponse response,@Valid @RequestBody HomeLoan hi) throws DocumentException, IOException {
		response.setContentType("loan_Details.pdf");
		TotalInterest ti = interestCalculatorService.getTotalInterest(hi.getLoanAmount(), hi.getTenure());
		TotalInterestPDFExporter exporter = new TotalInterestPDFExporter(ti);
		exporter.export(response);
	}
}