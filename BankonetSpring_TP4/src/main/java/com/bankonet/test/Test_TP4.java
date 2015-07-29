package com.bankonet.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.model.Adresse;
import com.bankonet.model.Client;

public class Test_TP4 {
	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Client client1 = (Client) context.getBean("client");
		Client client2 = (Client) context.getBean("client");
		
		client2.setId(1);
		client2.setNom("Lebon");
		client2.setPrenom("Jonathan");
		Adresse newAdresse = client2.getAdresse();
		newAdresse.setNumero(70);
		newAdresse.setRue("Boulevard Marcel Paul");
		newAdresse.setVille("Saint-Herblain");
		client2.setAdresse(newAdresse);
		
		System.out.println(client1);
		System.out.println(client2);
		
	}

}
