package com.homeloan.interestcalculator.utils;

import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.homeloan.interestcalculator.dao.TotalInterest;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class TotalInterestPDFExporter {

		private TotalInterest ti;
	    
	    public TotalInterestPDFExporter (TotalInterest ti) {
	        this.ti = ti;
	    }
	 
	    private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.BLACK);
	         
	        cell.setPhrase(new Phrase("Total Interest", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Total Amount", font));
	        table.addCell(cell);
	         
	    }
	     
	    private void writeTableData(PdfPTable table) {
	            table.addCell(String.valueOf(ti.totalInterest));
	            table.addCell(String.valueOf(ti.totalAmount));
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("Loan Details", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(2);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	        document.add(table);
	        document.close();
	         
	    }
	}


