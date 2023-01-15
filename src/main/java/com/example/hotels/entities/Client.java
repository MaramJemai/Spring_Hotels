package com.example.hotels.entities;

import javax.persistence.Entity;

@Entity
public class Client extends Personne {

	public Client() {
		super();
	}

	public Client(Long id, String nom, String prenom, Long telephone, String email,String mdp) {
		super(id, nom, prenom, telephone, email,mdp);
	}
	
	

}
