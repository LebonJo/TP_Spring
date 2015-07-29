package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;

@Transactional(propagation=Propagation.MANDATORY)
public class ClientDaoImpl implements IClientDao {
	
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void addClient(Client c) throws Exception {
		System.out.println("dans ClientDaoImpl.addClient --> client ajouté");
		this.getEntityManager().persist(c);
		throw new Exception("Erreur checked!");
	}

	@Override
	@Transactional(readOnly=true)
	public List<Client> listClients() {
		System.out.println("dans ClientDaoImpl.listClients --> liste clients retournée");
		String textQuery = "select c from Client as c";
		TypedQuery<Client> query = this.getEntityManager().createQuery(textQuery, Client.class);
		return query.getResultList();
	}

	@Override
	public void deleteClient(int idClient) {
		System.out.println("dans ClientDaoImpl.deleteClient --> client supprimé");
		Client clientASupprime = this.getEntityManager().find(Client.class, idClient);
		this.getEntityManager().remove(clientASupprime);
	}

	@Override
	@Transactional(readOnly=true)
	public Client editClient(int idClient) {
		System.out.println("dans ClientDaoImpl.editClient --> client retourné");
		return this.getEntityManager().find(Client.class, idClient);
	}

	@Override
	public void updateClient(Client c) {
		System.out.println("dans ClientDaoImpl.updateClient --> client mis à jour");
		this.getEntityManager().merge(c);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Client> chercherClients(String motCle) {
		System.out.println("dans ClientDaoImpl.chercherClients --> liste clients retournée");
		String textQuery = "select c from Client as c where c.nom LIKE '%" + motCle + "%' OR c.prenom LIKE '%" + motCle + "%'";
		TypedQuery<Client> query = this.getEntityManager().createQuery(textQuery, Client.class);
		return query.getResultList();
	}

}
