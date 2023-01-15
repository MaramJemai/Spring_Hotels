package com.example.hotels.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.hotels.entities.Chambre;
import com.example.hotels.entities.Hotel;

public interface HotelService {
	
	Hotel saveHotel(Hotel h);
	Hotel updateHotel(Hotel h);
	void deleteHotel(Hotel h);
	void deleteHotelById(Long id);
	Hotel getHotel(Long id);
	List<Hotel> getAllHotels();
	
	List<Hotel> trierHotelNom();
	List<Hotel> trierHotelEtoile();
	
	Page<Hotel> getAllHotelsParPage(int page, int size);
	
	List<Hotel> findByEtoileHotel(int etoile);
	List<Hotel> findByNomHotel(String nom);


}
