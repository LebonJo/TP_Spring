package com.bankonet.dao;

import java.util.List;

import com.bankonet.model.Client;

public interface IClientDao {
	
	void addClient(Client c) throws Exception;
	List<Client> listClients();
	void deleteClient(int idClient);
	Client editClient(int idClient);
	void updateClient(Client c);
	List<Client> chercherClients(String motCle);

}
