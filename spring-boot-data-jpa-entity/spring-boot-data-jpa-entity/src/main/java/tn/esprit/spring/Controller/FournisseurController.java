package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.IFournisseurService;
import tn.esprit.spring.entity.Fournisseur;

@RestController
public class FournisseurController {
	
	@Autowired
	IFournisseurService fournisseurService;

	public FournisseurController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add-fournisseur")
	@ResponseBody
	Fournisseur addFournisseur(@RequestBody Fournisseur f){
		return fournisseurService.addFournisseur(f);
	}
	
	@GetMapping("/retrieve-allFournisseurs")
	@ResponseBody
	List<Fournisseur> retrieveAllFournisseur(){
		
		return fournisseurService.retriveAllFournisseurs();
	}
	
	@PutMapping("/modify-fournisseur")
	@ResponseBody
	Fournisseur updateClient(@RequestBody Fournisseur f){
		
		return fournisseurService.updateFournisseur(f);
	}
	
	@DeleteMapping("/delete-fournisseur/{id}")
	void deleteClient(@PathVariable("id") Long idFournisseur){
		fournisseurService.deleteFournisseur(idFournisseur);
		
	}
	
	@PutMapping("/assign-fournisseur-to-produit/{produitId}/{fournisseurId}")
	@ResponseBody
	public void assignFournisseurToProduit(@PathVariable("fournisseurId") Long fournisseurId,@PathVariable("produitId") Long produitId){
		fournisseurService.assignFournisseurToProduit(fournisseurId, produitId);
	}

}
