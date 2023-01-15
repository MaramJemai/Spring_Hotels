package com.example.hotels.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotels.entities.Client;
import com.example.hotels.entities.Personne;
import com.example.hotels.entities.Responsable;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
	
	Client findPerByEmail(String email);
	
	Responsable findResByEmail(String email);

}
