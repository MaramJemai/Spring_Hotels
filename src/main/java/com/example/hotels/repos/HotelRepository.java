package com.example.hotels.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hotels.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	//List<Hotel> findByNomHotel(String nom);
	
	@Query("select f from Hotel f where f.etoile = ?1")
	 List<Hotel> findByEtoileHotel (int id);
	
	@Query("select f from Hotel f where f.nom = ?1")
	 List<Hotel> findByNomHotel (String nom);
	
	@Query("select p from Hotel p order by p.nom ASC")
	List<Hotel> trierHotelNom ();
	
	@Query("select p from Hotel p order by p.etoile ASC")
	List<Hotel> trierHotelEtoile ();
}

