package com.example.hotels.entities;

import javax.persistence.Entity;

@Entity
public class Admin extends Personne {

	public Admin() {
		super();
	}

	public Admin(Long id, String nom, String prenom, Long telephone, String email,String mdp) {
		super(id, nom, prenom, telephone, email, mdp);
	}
	
	

}
