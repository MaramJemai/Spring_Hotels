package com.example.hotels;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.hotels.entities.Chambre;
import com.example.hotels.entities.Client;
import com.example.hotels.entities.Hotel;
import com.example.hotels.entities.Personne;
import com.example.hotels.entities.Responsable;
import com.example.hotels.repos.ChambreRepository;
import com.example.hotels.repos.HotelRepository;
import com.example.hotels.repos.PersonneRepository;
import com.example.hotels.service.ChambreService;
import com.example.hotels.service.HotelService;

@SpringBootTest
class HotelsApplicationTests {

	@Autowired
	private ChambreRepository chambreRepository;
	@Autowired
	private ChambreService chambreService;
	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Test
	public void testCreateChambre() {
		Chambre hot = new Chambre();
		chambreRepository.save(hot);
	}
	
	 @Test
	 public void testFindChambre()
	 {
		 Chambre h = chambreRepository.findById(1L).get();
	     System.out.println(h);
	 }
	 
	 @Test
	 public void testUpdateChambre()
	 {
		 Chambre h = chambreRepository.findById(3L).get();
	     h.setCapacite(2);
	     chambreRepository.save(h);
	     
	     System.out.println(h);
	 }
	 
	 @Test
	 public void testDeleteChambre(){
		 chambreRepository.deleteById(5L);;
	 }
	  
	 @Test
	 public void testListerTousChambres()
	 {
	    List<Chambre> hots = chambreRepository.findAll();
	       for (Chambre h : hots){
	          System.out.println(h);
	       }
	 }
	 
	 @Test
		public void findByEtoileHotel() {
			List<Hotel> hots = hotelRepository.findByEtoileHotel(2);
		       for (Hotel h : hots){
		          System.out.println(h);
		       }
		}
	 
	 @Test
	 public void testFindByType()
	 {
		 List<Chambre> prods = chambreRepository.findByType("suite");
		 for (Chambre p : prods)
		 {
		 System.out.println(p);
		 }
	 }
	 
	 @Test
	 public void testFindByOccupe()
	 {
		 List<Chambre> prods = chambreRepository.findByOccupe(0);
		 for (Chambre p : prods)
		 {
		 System.out.println(p);
		 }
	 }
	 
	 @Test
	 public void testFindByTypeContains ()
	 {
	 List<Chambre> prods=chambreRepository.findByTypeContains("u");
	 for (Chambre p : prods)
	 {
	 System.out.println(p);
	 } }
	 
	 @Test
	 public void testfindByCO()
	 {
	 List<Chambre> prods = chambreRepository.findByCO(2,1);
	 for (Chambre p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testfindByN()
	 {
	 List<Chambre> prods = chambreRepository.findByType("suite");
	 for (Chambre p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testfindByHotel()
	 {
	 Hotel cat = new Hotel();
	 cat.setId(1L);
	 List<Chambre> prods = chambreRepository.findByHotel(cat);
	 for (Chambre p : prods)
	 {
	 System.out.println(p);
	 }
	 }

	 @Test
	 public void testfindByHotelId()
	 {
	 List<Chambre> prods = chambreRepository.findByHotelId(1L);
	 for (Chambre p : prods)
	 {
	 System.out.println(p);
	 }
	  }
	 
	 @Test
	 public void testfindByOrderByTypeAsc()
	 {
	 List<Chambre> prods = chambreRepository.findByOrderByTypeAsc();
	 for (Chambre p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 @Test
	 public void testTrierProduitsTypePrix()
	 {
	 List<Chambre> prods = chambreRepository.trierProduitsTypePrix();
	 for (Chambre p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 
	 
	 @Test
	 public void testfindByEmail()
	 {
	 Client prods = personneRepository.findPerByEmail("malak@gmail.com");
	 
	 System.out.println(prods);
	 
	  }
	 
	 @Test
	 public void testfindByEmailR()
	 {
	 Responsable prods = personneRepository.findResByEmail("malak@gmail.com");
	 
	 System.out.println(prods);
	 
	  }
	


	 


}
