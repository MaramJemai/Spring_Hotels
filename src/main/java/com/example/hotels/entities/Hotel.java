package com.example.hotels.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	private int etoile;
	private int contact;
	
	@JsonIgnore
	@OneToMany(mappedBy = "hotel")
	private List<Chambre> chambres;
	
	public Hotel() {
	}
	
	public Hotel(Long id, String nom, String adresse, int etoile, int contact) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.etoile = etoile;
		this.contact = contact;
	}
	public Hotel(String nom, String adresse, int etoile, int contact) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.etoile = etoile;
		this.contact = contact;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getEtoile() {
		return etoile;
	}
	public void setEtoile(int etoile) {
		this.etoile = etoile;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	
	

}
