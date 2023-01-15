package com.example.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.hotels.entities.Chambre;
import com.example.hotels.entities.Hotel;
import com.example.hotels.repos.ChambreRepository;

@Service
public class ChambreServiceImpl implements ChambreService {

	@Autowired
	ChambreRepository chambreRepository;
	
	@Override
	public Chambre saveChambre(Chambre c) {
		return chambreRepository.save(c);
	}

	@Override
	public Chambre updateChambre(Chambre c) {
		return chambreRepository.save(c);
	}

	@Override
	public void deleteChambre(Chambre c) {
		chambreRepository.delete(c);	
	}

	@Override
	public void deleteChambreById(Long id) {
		chambreRepository.deleteById(id);
	}

	@Override
	public Chambre getChambre(Long id) {
		return chambreRepository.findById(id).get();
	}

	@Override
	public List<Chambre> getAllChambres() {
		return  chambreRepository.findAll();
	}

	@Override
	public Page<Chambre> getAllChambresParPage(int page, int size) {
		return chambreRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Chambre> findByType(String type) {
		return chambreRepository.findByType(type);
	}
	
	@Override
	public List<Chambre> findByCapacite(int capacite) {
		return chambreRepository.findByCapacite(capacite);
	}
	
	@Override
	public List<Chambre> findByOccupe(int occupe) {
		return chambreRepository.findByOccupe(occupe);
	}

	@Override
	public List<Chambre> findByTypeContains(String nom) {
		return chambreRepository.findByTypeContains(nom);
	}

	@Override
	public List<Chambre> findByCO(int capacite, int occupe) {
		return chambreRepository.findByCO(capacite,occupe);
	}

	@Override
	public List<Chambre> findByHotel(Hotel hotel) {
		return chambreRepository.findByHotel(hotel);
	}

	@Override
	public List<Chambre> findByHotelId(Long id) {
		return chambreRepository.findByHotelId(id);
	}

	@Override
	public List<Chambre> findByOrderByTypeAsc() {
		return chambreRepository.findByOrderByTypeAsc();
	}

	@Override
	public List<Chambre> trierProduitsTypePrix() {
		return chambreRepository.trierProduitsTypePrix();
	}
	
	@Override
	public List<Chambre> findAll() {
	
		return chambreRepository.findAll();
		
	}

	@Override
	public List<Chambre> findByN(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
