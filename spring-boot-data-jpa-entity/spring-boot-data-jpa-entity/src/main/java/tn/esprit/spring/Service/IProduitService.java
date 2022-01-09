package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;


import tn.esprit.spring.entity.Produit;

public interface IProduitService {
	List<Produit> retriveAllProduits();
	Produit addPrduit(Produit p, Long idRayon, Long idStock);
	void deleteProduit(Long idFacture);
	Produit updateProduit(Produit p);
	Produit retrieveProduit(Long id);
	void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
	float getChiffreAffaireMagazin();

}
