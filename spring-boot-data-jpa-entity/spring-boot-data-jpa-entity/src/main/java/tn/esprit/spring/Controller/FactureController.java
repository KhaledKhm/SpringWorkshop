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

import tn.esprit.spring.Service.IFactureService;
import tn.esprit.spring.entity.Facture;
//import tn.esprit.spring.entity.Produit;

@RestController("Facture")
public class FactureController {

	@Autowired
	IFactureService factureService;
	
	@PostMapping("/add-facture")
	@ResponseBody
	Facture addFacture(@RequestBody Facture f){
		return factureService.addFacture(f);
	}
	
	
	
	@GetMapping("/get-factureClient/{idClient}")
	@ResponseBody
	List<Facture> getFacturesByClient(@PathVariable("idClient") Long idClient){
		return factureService.getFacturesByClient(idClient);
		
	}
	
	@GetMapping("/retrieve-allFacture")
	@ResponseBody
	List<Facture> retrieveAllFacture(){
		
		return factureService.retriveAllFactures();
	}
	
	@GetMapping("/get-somme-Facture")
	@ResponseBody
	void sommeFacture(){
		factureService.sommeFacture();
	}
	
	@PutMapping("modify-facture")
	@ResponseBody
	Facture updateFacture(@RequestBody Facture f){
		
		return factureService.updateFacture(f);
	}
	
	@DeleteMapping("delete-facture/{id}")
	void deleteFacture(@PathVariable("id") Long idFacture){
		factureService.deleteFacture(idFacture);
		
	}

}
