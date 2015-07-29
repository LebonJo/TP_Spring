package com.bankonet.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public class Personne {
	
	@Id
	@GeneratedValue
	private int id;
	@Size(min = 3, max = 60)
	@Column(name="NOM", nullable = false)
	private String nom;
	@Size(min = 3, max = 60)
	@Column(name="PRENOM", nullable = false)
	private String prenom;
	
	public Personne(){
		super();
	}
	
	public Personne(String nom, String prenom){
		super();
		this.nom = nom;
		this.prenom = prenom;
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
	
	

}
