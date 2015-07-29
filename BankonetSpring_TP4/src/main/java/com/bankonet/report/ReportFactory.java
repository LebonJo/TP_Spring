package com.bankonet.report;

public class ReportFactory {

	public static ReportGenerator createReport(String reportType){
		
		if(reportType.equals("html")){
			return new HtmlReportGenerator();
		} else if(reportType.equals("pdf")){
			return new PdfReportGenerator();
		}
		throw new IllegalArgumentException("Format inconnu");
		
	}
	
}
