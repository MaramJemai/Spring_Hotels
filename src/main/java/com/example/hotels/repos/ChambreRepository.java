package com.example.hotels.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hotels.entities.Chambre;
import com.example.hotels.entities.Hotel;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long>{
	//List<Chambre> findByType(String type);
	List<Chambre> findByTypeContains(String nom);

	@Query("select p from Chambre p where p.capacite like %?1 and p.occupe like %?2")
	List<Chambre> findByCO (int capacite, int occupe);
	
	@Query("select p from Chambre p where p.capacite like %?1")
	List<Chambre> findByCapacite (int capacite);
	
	@Query("select p from Chambre p where p.occupe like %?1")
	List<Chambre> findByOccupe (int occupe);
	
	@Query("select p from Chambre p where p.type like %?1")
	List<Chambre> findByType(String type);
	
	/*@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	List<Produit> findByN (@Param("nom") String nom,@Param("prix") Double prix);*/
	
	@Query("select p from Chambre p where p.hotel= ?1")
	List<Chambre> findByHotel (Hotel hotel);
	
	List<Chambre> findByHotelId(Long id);
	
	List<Chambre> findByOrderByTypeAsc();
	
	@Query("select p from Chambre p order by p.type ASC, p.prix DESC")
	List<Chambre> trierProduitsTypePrix ();
	
	
	



}
