package com.bankonet.report;

public class PdfReportGenerator extends ReportGenerator implements IReportGenerator{

	@Override
	public void generate() {
		System.out.println("Génération d'un rapport PDF ...");		
	}
	
	public void generate(String auteur){
		this.generate();
		System.out.println("-> Auteur : " + auteur);
	}

}
