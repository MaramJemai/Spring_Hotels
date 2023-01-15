package com.example.hotels.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.hotels.entities.Chambre;
import com.example.hotels.entities.Hotel;

public interface ChambreService {
	
	List <Chambre> findAll();
	Chambre saveChambre(Chambre c);
	Chambre updateChambre(Chambre c);
	void deleteChambre(Chambre c);
	void deleteChambreById(Long id);
	Chambre getChambre(Long id);
	List<Chambre> getAllChambres();
	
	Page<Chambre> getAllChambresParPage(int page, int size);
	
	List<Chambre> findByType(String type);
	List<Chambre> findByCapacite(int capacite);
	List<Chambre> findByOccupe(int occupe);
	List<Chambre> findByTypeContains(String nom);
	List<Chambre> findByCO (int capacite, int occupe);
	List<Chambre> findByN (Long numero);
	List<Chambre> findByHotel (Hotel hotel);
	List<Chambre> findByHotelId(Long id);
	List<Chambre> findByOrderByTypeAsc();
	List<Chambre> trierProduitsTypePrix();
	

}
