package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entity.Fournisseur;

public interface IFournisseurService {
	List<Fournisseur> retriveAllFournisseurs();
	Fournisseur addFournisseur(Fournisseur f);
	void deleteFournisseur(Long idFournisseur);
	Fournisseur updateFournisseur(Fournisseur f);
	Fournisseur retrieveFournisseur(Long id);
	void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
}
