package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IClientService;

public class Test_TP5 {
	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		IClientService service = (IClientService) context.getBean("clientService");
		//service.listClients();
		service.SupprimerClientDontLeNomContient("test"); 
		
	}

}
