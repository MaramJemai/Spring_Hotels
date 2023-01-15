package com.example.hotels.entities;

import javax.persistence.Entity;

@Entity
public class Responsable extends Personne {
	
	private Long idHotel;

	public Responsable() {
		super();
	}

	public Responsable(Long id, String nom, String prenom, Long telephone, String email,String mdp,Long idHotel) {
		super(id, nom, prenom, telephone, email,mdp);
		this.idHotel = idHotel;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	
}
