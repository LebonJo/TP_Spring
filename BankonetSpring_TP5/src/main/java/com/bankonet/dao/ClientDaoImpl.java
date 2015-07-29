package com.bankonet.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bankonet.model.Client;

@Repository("clientDao")
public class ClientDaoImpl implements IClientDao {

	@Override
	public void addClient(Client c) {
		System.out.println("dans ClientDaoImpl.addClient --> client ajouté");
	}

	@Override
	public List<Client> listClients() {
		System.out.println("dans ClientDaoImpl.listClients --> liste clients retournée");
		return new ArrayList<Client>();
	}

	@Override
	public void deleteClient(int idClient) {
		System.out.println("dans ClientDaoImpl.deleteClient --> client supprimé");
	}

	@Override
	public Client editClient(int idClient) {
		System.out.println("dans ClientDaoImpl.editClient --> client retourné");
		return new Client();
	}

	@Override
	public void updateClient(Client c) {
		System.out.println("dans ClientDaoImpl.updateClient --> client mis à jour");
	}

	@Override
	public List<Client> chercherClients(String motCle) {
		System.out.println("dans ClientDaoImpl.chercherClients --> liste clients retournée");
		List<Client> clientTrouvés = new ArrayList<Client>(); 
		clientTrouvés.add(new Client());
		clientTrouvés.add(new Client());
		return clientTrouvés;
	}

}
