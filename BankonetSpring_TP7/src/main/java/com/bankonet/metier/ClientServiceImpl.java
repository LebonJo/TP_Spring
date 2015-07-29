package com.bankonet.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bankonet.dao.IClientDao;
import com.bankonet.model.Client;
import javax.annotation.Resource;

@Service("clientService")
public class ClientServiceImpl implements IClientService {

	@Resource(name="clientDao")
	private IClientDao clientDao;
	
	public ClientServiceImpl(){
		super();
	}
	
	// Constructeur + injection du bean clientDao
	public ClientServiceImpl(IClientDao clientDao){
		super();
		this.setClientDao(clientDao);
	}
	

	// Getter/Setter
	public IClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}
	
	
	// Méthodes métiers fournies
	@Override
	public void addClient(Client c) {
		clientDao.addClient(c);
	}

	@Override
	public List<Client> listClients() {
		System.out.println(clientDao != null);
		return clientDao.listClients();
	}

	@Override
	public void deleteClient(int idClient) {
		clientDao.deleteClient(idClient);
	}

	@Override
	public Client editClient(int idClient) {
		return clientDao.editClient(idClient);
	}

	@Override
	public void updateClient(Client c) {
		clientDao.updateClient(c);
	}

	@Override
	public List<Client> chercherClients(String motCle) {
		return clientDao.chercherClients(motCle);
	}
	
	@Override
	public List<Client> SupprimerClientDontLeNomContient(String motCle){
		
		List<Client> clientsASupprimer = clientDao.chercherClients(motCle);
		for(Client client : clientsASupprimer){
			clientDao.deleteClient(client.getId());
		}
		return clientDao.listClients();
	}
	
	
}
