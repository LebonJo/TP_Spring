package com.bankonet.metier;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(rollbackFor=Exception.class) //si une exception est levée, spring fera un rollback de la base
	public void addClient(Client c) throws Exception{
		clientDao.addClient(c);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Client> listClients() {
		System.out.println(clientDao != null);
		return clientDao.listClients();
	}

	@Override
	@Transactional
	public void deleteClient(int idClient) {
		clientDao.deleteClient(idClient);
	}

	@Override
	@Transactional(readOnly=true)
	public Client editClient(int idClient) {
		return clientDao.editClient(idClient);
	}

	@Override
	@Transactional
	public void updateClient(Client c) {
		clientDao.updateClient(c);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Client> chercherClients(String motCle) {
		return clientDao.chercherClients(motCle);
	}
	
	@Override
	@Transactional
	public List<Client> SupprimerClientDontLeNomContient(String motCle){
		List<Client> clientsASupprimer = clientDao.chercherClients(motCle);
		for(Client client : clientsASupprimer){
			clientDao.deleteClient(client.getId());
		}
		return clientDao.listClients();
	}
	
	
}
