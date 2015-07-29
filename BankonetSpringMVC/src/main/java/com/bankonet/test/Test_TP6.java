package com.bankonet.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankonet.metier.IClientService;
import com.bankonet.model.Adresse;
import com.bankonet.model.Client;

public class Test_TP6 {
	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		IClientService service = (IClientService) context.getBean("clientService");
		
		List<Client> clients = service.listClients();
		for(Client client : clients){
			System.out.println(client.toString());
		}
		
		Adresse adresse = new Adresse(1, "Rue Louis Guilloux", "Quimperlé");
		try {
			service.addClient(new Client("Jean", "Michel", adresse, "Crapaud", "River"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		clients = service.chercherClients("ohn");
//		for(Client client : clients){
//			System.out.println(client.toString());
//		}
	}

}
