package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ReportService;

public class Test_TP2 {
	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ReportService service1 = (ReportService) context.getBean("reportService");
		ReportService service2 = (ReportService) context.getBean("reportService");
		
		service1.setAuteur("Jean Blaguin");
		service2.setAuteur("Jean Micheng");
		
		service1.generate();
		service2.generate();
		
	}

}
