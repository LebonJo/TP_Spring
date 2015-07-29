package com.bankonet.metier;

import com.bankonet.report.IReportGenerator;

public class ReportService {

	private IReportGenerator reportGenerator;
	
	public ReportService(){
		
	}
	
	//constructeur param�tr� pour l'injection par constructeur
	public ReportService(IReportGenerator reportGenerator){
		this.reportGenerator = reportGenerator;
	}
	
	//getter
	public IReportGenerator getReportGenerator(){
		return this.reportGenerator;
	}
	
	//setter
	public void setReportGenerator(IReportGenerator reportGenerator){
		this.reportGenerator = reportGenerator;
	}
	
	//appel � la couche technique sous-jacente
	public void generate(){
		reportGenerator.generate();
	}
	
}
