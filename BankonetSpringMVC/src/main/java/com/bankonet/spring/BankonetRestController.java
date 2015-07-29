package com.bankonet.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bankonet.metier.IClientService;
import com.bankonet.model.Client;

@Controller
@RequestMapping(value="rest")
public class BankonetRestController {
	
	@Autowired
	private IClientService clientService;
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Client> findClients(){
		List<Client> clients = clientService.listClients();
		return clients;
	}
	
	@RequestMapping(value = "/clients/{keyword}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Client> findClientsByKeyword(@PathVariable("keyword") String keyword){
		List<Client> clients = clientService.chercherClients(keyword);
		return clients;
	}
	
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void postClient(@RequestBody Client client){
		System.out.println(client.toString());
		try {
			clientService.addClient(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/deleteClient/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void deleteClient(@PathVariable("id") int id){
		Client client = clientService.editClient(id);
		if(client != null){
			clientService.deleteClient(id);
		}
	}

}
