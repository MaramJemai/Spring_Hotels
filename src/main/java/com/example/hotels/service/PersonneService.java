package com.example.hotels.service;

import java.util.List;

import com.example.hotels.entities.Client;
import com.example.hotels.entities.Personne;
import com.example.hotels.entities.Responsable;

public interface PersonneService {
	
	Personne savePersonne(Personne h);
	Personne updatePersonne(Personne h);
	void deletePersonne(Personne h);
	void deletePersonneById(Long id);
	Personne getPersonne(Long id);
	List<Personne> getAllPersonnes();
	
	Client findPerByEmail(String email);
	Responsable findResByEmail(String email);

}
