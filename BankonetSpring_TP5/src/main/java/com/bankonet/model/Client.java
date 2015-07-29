package com.bankonet.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Client extends Personne{
	
	private String login;
	private String mdp;
	@Autowired //dépendance automatique avec annotation autowired et ajout des configs dans le debut du beans.xml
	private Adresse adresse;
	
	public Client(){
		super();
	}
	
	public Client(int id, String nom, String prenom, Adresse adresse, String login, String mdp){
		super(id, nom, prenom);
		this.adresse = adresse;
		this.login = login;
		this.mdp = mdp;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public String toString(){
		return "ID : " + this.getId() + ", " + this.getNom() + " " + this.getPrenom() + ", " + adresse.toString();
	}

}
