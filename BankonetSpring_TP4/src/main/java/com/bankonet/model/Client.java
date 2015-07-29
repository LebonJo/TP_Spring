package com.bankonet.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Client {
	
	private int id;
	private String nom;
	private String prenom;
	@Autowired //dépendance automatique avec annotation autowired et ajout des configs dans le debut du beans.xml
	private Adresse adresse;
	
	public Client(){
		super();
	}
	
	public Client(int id, String nom, String prenom, Adresse adresse){
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public String toString(){
		return "ID : " + id + ", " + nom + " " + prenom + ", " + adresse.toString();
	}

}
