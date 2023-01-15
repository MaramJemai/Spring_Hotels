package com.example.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.hotels.entities.Hotel;
import com.example.hotels.repos.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public Hotel saveHotel(Hotel h) {
	return hotelRepository.save(h);
    }
	
	@Override
	public Hotel updateHotel(Hotel h) {
		return hotelRepository.save(h);
	}
	
	@Override
	public void deleteHotel(Hotel h) {
		hotelRepository.delete(h);
	}
	
	@Override
	public void deleteHotelById(Long id) {
		hotelRepository.deleteById(id);
	}
	
	@Override
	public Hotel getHotel(Long id) {
		return hotelRepository.findById(id).get();
	}
	
	@Override
	public List<Hotel> getAllHotels() {
		return  hotelRepository.findAll();
	}

	@Override
	public Page<Hotel> getAllHotelsParPage(int page, int size) {
		return hotelRepository.findAll(PageRequest.of(page, size));
	}
	
	
	@Override
	public List<Hotel> trierHotelNom() {
		return hotelRepository.trierHotelNom();
	}
	
	@Override
	public List<Hotel> trierHotelEtoile() {
		return hotelRepository.trierHotelEtoile();
	}
	
	@Override
	public List<Hotel> findByEtoileHotel(int etoile) {
		return hotelRepository.findByEtoileHotel(etoile);
	}
	
	@Override
	public List<Hotel> findByNomHotel(String nom) {
		return hotelRepository.findByNomHotel(nom);
	}

}