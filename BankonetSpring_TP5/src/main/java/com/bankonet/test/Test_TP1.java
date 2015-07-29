package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.ReportService;

public class Test_TP1 {
	
	public static void main(String[] args){
		
		System.out.println();
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ReportService service = (ReportService) context.getBean("reportService");
		service.generate();
		
	}

}
