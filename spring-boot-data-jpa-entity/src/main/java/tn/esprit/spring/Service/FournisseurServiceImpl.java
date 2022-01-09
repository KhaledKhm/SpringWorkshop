package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.FournisseurRepository;
import tn.esprit.spring.Repository.ProduitRepository;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;

@Service
public class FournisseurServiceImpl implements IFournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	ProduitRepository produitRepository;
	
	@Override
	public List<Fournisseur> retriveAllFournisseurs() {
		List<Fournisseur> fournisseurtList = (List<Fournisseur>) fournisseurRepository.findAll();
		return fournisseurtList;
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		fournisseurRepository.save(f);
		return f;
	}

	@Override
	public void deleteFournisseur(Long idFournisseur) {
		fournisseurRepository.deleteById(idFournisseur);
		
	}
	

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		fournisseurRepository.save(f);
		return f;
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		return fournisseurRepository.findById(id).orElse(null);
	}

	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		if(produitRepository.findById(produitId).isPresent()){
			Produit p = produitRepository.findById(produitId).get();
			Fournisseur f = new Fournisseur();
			if(fournisseurRepository.findById(fournisseurId).isPresent()){
				f.setIdFournisseur(fournisseurId);
				p.getFournisseurs().add(f);
				produitRepository.save(p);
			}
		}
		
	}

	

	

}
