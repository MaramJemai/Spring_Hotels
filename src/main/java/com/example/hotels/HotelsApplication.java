package com.example.hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hotels.service.ChambreService;
import com.example.hotels.service.HotelService;

@SpringBootApplication
public class HotelsApplication 
//implements CommandLineRunner
{

	@Autowired
		HotelService hotelService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HotelsApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		hotelService.saveHotel(new Hotel("hotela", "sousse",2,99889988));
		hotelService.saveHotel(new Hotel("hotelb", "nabeul",3,66556655));
		hotelService.saveHotel(new Hotel("hotelc", "monastir",4,33223322));
		
	}*/

}
