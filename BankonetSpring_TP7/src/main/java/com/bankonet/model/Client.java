package com.bankonet.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

//import org.springframework.beans.factory.annotation.Autowired;

@Entity
@DiscriminatorValue("C")
public class Client extends Personne{
	
	@Size(min = 2, max = 16)
	@Column(name = "login", nullable = false)
	private String login;
	@Size(min = 6, max = 50)
	@Column(name = "mdp", nullable = false)
	private String mdp;
	//@Autowired //dépendance automatique avec annotation autowired et ajout des configs dans le debut du beans.xml
	@Embedded
	private Adresse adresse;
	
	public Client(){
		super();
	}
	
	public Client(String nom, String prenom, Adresse adresse, String login, String mdp){
		super(nom, prenom);
		this.adresse = adresse;
		this.setLogin(login);
		this.setMdp(mdp);
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
