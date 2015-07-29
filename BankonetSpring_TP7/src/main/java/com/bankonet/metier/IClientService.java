package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Client;

public interface IClientService {

	void addClient(Client c);
	List<Client> listClients();
	void deleteClient(int idClient);
	Client editClient(int idClient);
	void updateClient(Client c);
	List<Client> chercherClients(String motCle);
	List<Client> SupprimerClientDontLeNomContient(String string);
	
}
