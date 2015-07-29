package com.bankonet.metier;

import com.bankonet.report.IReportGenerator;

public class ReportService {

	private IReportGenerator reportGenerator;
	private String auteur;
	
	public ReportService(){
		
	}
	
	//constructeur paramétré pour l'injection par constructeur
	public ReportService(IReportGenerator reportGenerator){
		this.reportGenerator = reportGenerator;
	}
	
	//getter
	public IReportGenerator getReportGenerator(){
		return this.reportGenerator;
	}
	public String getAuteur(){
		return this.auteur;
	}
	
	//setter
	public void setReportGenerator(IReportGenerator reportGenerator){
		this.reportGenerator = reportGenerator;
	}
	public void setAuteur(String auteur){
		this.auteur = auteur;
	}
	
	//appel à la couche technique sous-jacente
	public void generate(){
		reportGenerator.generate(auteur);
	}
	
}
