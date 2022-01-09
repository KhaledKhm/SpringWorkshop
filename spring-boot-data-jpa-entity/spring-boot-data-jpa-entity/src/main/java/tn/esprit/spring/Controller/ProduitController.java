package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.IProduitService;
//import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Produit;

@RestController("Produit")
public class ProduitController {

	
	@Autowired
	IProduitService produitService;
	
	@PostMapping("/add-produit/{idRayon}/{idStock}")
	@ResponseBody
	Produit addProduit(@RequestBody Produit p, @PathVariable("idRayon") Long idRayon,@PathVariable("idStock") Long idStock){
		return produitService.addPrduit(p, idRayon,idStock);
	}
	
	/*@PostMapping("/add-produit")
	@ResponseBody
	Produit addProduit(@RequestBody Produit p){
		return produitService.addPrduit(p, p.getRayon().getIdRayon(), p.getStock().getIdStock());
	}*/
	
	@PutMapping("/assign-produit/{idFournisseur}/{idProduit}")
	@ResponseBody
	void assignFournisseurToProduit(@PathVariable("idFournisseur") Long idFournissuer,@PathVariable("idProduit") Long idProduit){
		produitService.assignFournisseurToProduit(idFournissuer, idProduit);
	}
	
	@GetMapping("/retrieve-allProduit")
	@ResponseBody
	List<Produit> retrieveAllProduit(){
		
		return produitService.retriveAllProduits();
	}
	
	@PutMapping("/modify-produit")
	@ResponseBody
	Produit updateProduit(@RequestBody Produit p){
		
		return produitService.updateProduit(p);
	}
	
	@DeleteMapping("/delete-produit/{id}")
	void deleteFacture(@PathVariable("id") Long idProduit){
		produitService.deleteProduit(idProduit);
		
	}
	
	@Scheduled(cron="* * * 1 * *")
	@GetMapping("/chiffre-affaire-agazin")
	@ResponseBody
	void getChiffreAffaireMagazin(){
			System.out.println();
		
			
	}
	
}
