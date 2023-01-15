package com.example.hotels.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hotels.entities.Chambre;
import com.example.hotels.entities.Hotel;
import com.example.hotels.repos.PersonneRepository;
import com.example.hotels.service.ChambreService;
import com.example.hotels.service.HotelService;

@Controller
public class HotelController {
	@Autowired
	//je demande a spring de nous injecter un objet qui implemente l'interface HotelService
		HotelService hotelService;
		//instancier un objet de type HotelService dans la variable hotelService(j'aurait toutes les methode de cette classe)
	
	@Autowired
	ChambreService chambreService;
	
	@Autowired
	PersonneRepository personneRepository;
	
	@RequestMapping(value = "/acceuil", method = RequestMethod.GET)
	 public String acceuil()
	 {
		return "acceuil";
	 }
	
	@RequestMapping("profil")
	public String profil(){
	return "profil";
	}
	
	@RequestMapping("apropos")
	public String apropos(){
	return "apropos";
	}
	
	@RequestMapping("/signupClient")
	public String logc(){
	return "signupClient";
	}
	
	@RequestMapping("/signup")
	public String log(){
	return "signup";
	}
	
	@RequestMapping("/signupResponsable")
	public String logr(){
	return "signupResponsable";
	}
	
	@RequestMapping("showCreate")
	public String showCreate(){
	return "createHotel";
	}
	
	@RequestMapping("/saveHotel")
	public String saveHotel(@ModelAttribute("hotel") Hotel hotel, 
	                         ModelMap modelMap) throws ParseException 
	{
		Hotel saveHotel = hotelService.saveHotel(hotel);
	String msg ="hotel enregistré avec Id "+saveHotel.getId();
	modelMap.addAttribute("msg", msg);
	return "createHotel";
	}
	
	@RequestMapping("/ListeHotels")
	public String listeHotels(ModelMap modelMap,
	      @RequestParam (name="page",defaultValue = "0") int page,
	      @RequestParam (name="size", defaultValue = "6") int size)
	{
		Page<Hotel> hots = hotelService.getAllHotelsParPage(page, size);
		modelMap.addAttribute("hotels", hots);
		 modelMap.addAttribute("pages", new int[hots.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
	return "ListeHotels";
	}
	
	@RequestMapping("/ListeHotelsClient")
	public String listeHotelsListeHotelsClient(ModelMap modelMap,
	      @RequestParam (name="page",defaultValue = "0") int page,
	      @RequestParam (name="size", defaultValue = "10") int size)
	{
		Page<Hotel> hots = hotelService.getAllHotelsParPage(page, size);
		modelMap.addAttribute("hotels", hots);
		 modelMap.addAttribute("pages", new int[hots.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
	return "ListeHotelsClient";
	}
	
	
	@RequestMapping("/supprimerHotel")
	public String supprimerHotel(@RequestParam("id") Long id,
	                                ModelMap modelMap,
	                                @RequestParam (name="page",defaultValue = "0") int page,
	                                @RequestParam (name="size", defaultValue = "6") int size)
	{ 
		hotelService.deleteHotelById(id);
		Page<Hotel> hots = hotelService.getAllHotelsParPage(page,size);
		modelMap.addAttribute("hotels", hots);
		modelMap.addAttribute("pages", new int[hots.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
	return "listeHotels";
	}
	
	@RequestMapping("/modifierHotel")
	public String editerHotel(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Hotel h= hotelService.getHotel(id);
	modelMap.addAttribute("hotel", h);
	return "editerHotel";
	}
	
	@RequestMapping("/updateHotel")
	public String updateHotel(@ModelAttribute("hotel") Hotel hotel,
	                            ModelMap modelMap) throws ParseException
	{
		hotelService.updateHotel(hotel);
		List<Hotel> hots = hotelService.getAllHotels();
		modelMap.addAttribute("hotels", hots);
		return "listeHotels";
		}
	
	@RequestMapping("/ListeHotelsTN")
	public String listeHotelsTrier(ModelMap modelMap)
	{
		List<Hotel> hots = hotelService.trierHotelNom();
		modelMap.addAttribute("hotels", hots);
		
	return "listeHotelTriee";
	}
	
	@RequestMapping("/ListeHotelsTE")
	public String listeHotelsTrierE(ModelMap modelMap)
	{
		List<Hotel> hots = hotelService.trierHotelEtoile();
		modelMap.addAttribute("hotels", hots);
		
	return "listeHotelTriee";
	}

	@RequestMapping("/ListeHotelsTNn")
	public String listeHotelsTriern(@ModelAttribute("hotel") Hotel hotel,
            ModelMap modelMap) throws ParseException
{
		List<Hotel> hots = hotelService.trierHotelNom();

         modelMap.addAttribute("hotels", hots);
	return "listeHotels";
	}
	
	@RequestMapping(value="/ListeHotels/{id}",method = RequestMethod.GET)
	public List<Chambre> getHotelById(@PathVariable("id") Long id)
	{
	return chambreService.findByHotelId(id);
	}
	
	@RequestMapping("/chercherEtoile")
	public String chercherEtoile(@RequestParam("etoile") int etoile,
			ModelMap modelMap)
	{     
		  List <Hotel> f = hotelService.findByEtoileHotel(etoile);
		  
		  modelMap.addAttribute("hotels",f);

		  return "rechercherEtoile";
	} 
	
	@RequestMapping("/chercherNom")
	public String chercherEtoile(@RequestParam("nom") String nom,
			ModelMap modelMap)
	{     
		  List <Hotel> f = hotelService.findByNomHotel(nom);
		  
		  modelMap.addAttribute("hotels",f);

		  return "rechercherEtoile";
	}
	
	
	
	@RequestMapping("/chercherChambre")
	public String chercherGenre(@ModelAttribute("hotel")Hotel formData,ModelMap modelMap
	) {
		List<Hotel> m = hotelService.getAllHotels();
		modelMap.addAttribute("hotels", m);
		
		List<Chambre> f=chambreService.findByHotel(formData);
		modelMap.addAttribute("chambres",f);

		return "rechercherChambre";
	}
	
		/////////
	
	@RequestMapping("/showCreatee")
	public String showCreatee(){
	return "createChambre";
	}
	
	@RequestMapping("/saveChambre")
	public String saveChambre(@ModelAttribute("chambre") Chambre chambre, 
	                         ModelMap modelMap) throws ParseException 
	{
		Chambre saveChambre = chambreService.saveChambre(chambre);
	String msg ="chambre enregistré avec Id "+saveChambre.getId();
	modelMap.addAttribute("msg", msg);
	return "createChambre";
	}
	
	@RequestMapping("/ListeChambres")
	public String listeHotelss(ModelMap modelMap,
	      @RequestParam (name="page",defaultValue = "0") int page,
	      @RequestParam (name="size", defaultValue = "4") int size)
	{
		Page<Chambre> hots = chambreService.getAllChambresParPage(page, size);
		modelMap.addAttribute("chambres", hots);
		 modelMap.addAttribute("pages", new int[hots.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
	return "ListeChambres";
	}
	
	@RequestMapping("/supprimerChambre")
	public String supprimerChambre(@RequestParam("id") Long id,
	                                ModelMap modelMap,
	                                @RequestParam (name="page",defaultValue = "0") int page,
	                                @RequestParam (name="size", defaultValue = "6") int size)
	{ 
		chambreService.deleteChambreById(id);
		Page<Chambre> hots = chambreService.getAllChambresParPage(page,size);
		modelMap.addAttribute("chambres", hots);
		modelMap.addAttribute("pages", new int[hots.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
	return "listeChambres";
	}
	
	@RequestMapping("/modifierChambre")
	public String editerChambre(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Chambre h= chambreService.getChambre(id);
	modelMap.addAttribute("chambre", h);
	return "editerChambre";
	}
	
	
	@RequestMapping("/updateChambre")
	public String updateChambre(@ModelAttribute("chambre") Chambre chambre,
	                            ModelMap modelMap) throws ParseException
	{
		chambreService.updateChambre(chambre);
		List<Chambre> hots = chambreService.getAllChambres();
		modelMap.addAttribute("chambres", hots);
		return "listeChambres";
		}
	
	
	
	
	

}
