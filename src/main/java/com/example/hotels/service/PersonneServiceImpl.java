package com.example.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotels.entities.Client;
import com.example.hotels.entities.Personne;
import com.example.hotels.entities.Responsable;
import com.example.hotels.repos.PersonneRepository;

@Service
public class PersonneServiceImpl implements PersonneService{

	@Autowired
	PersonneRepository personneRepository;
	
	@Override
	public Personne savePersonne(Personne h) {
		return personneRepository.save(h);
	}

	@Override
	public Personne updatePersonne(Personne h) {
		return personneRepository.save(h);
	}

	@Override
	public void deletePersonne(Personne h) {
		personneRepository.delete(h);
		
	}

	@Override
	public void deletePersonneById(Long id) {
		personneRepository.deleteById(id);
		
	}

	@Override
	public Personne getPersonne(Long id) {
		return personneRepository.findById(id).get();
	}

	@Override
	public List<Personne> getAllPersonnes() {
		return  personneRepository.findAll();
	}
	
	
	@Override
	public Client findPerByEmail(String email) {
		return  personneRepository.findPerByEmail(email);
	}
	
	@Override
	public Responsable findResByEmail(String email) {
		return  personneRepository.findResByEmail(email);
	}

}
