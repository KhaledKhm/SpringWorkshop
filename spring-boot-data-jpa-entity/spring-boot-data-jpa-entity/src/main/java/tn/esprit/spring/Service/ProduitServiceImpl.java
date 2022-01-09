package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.FactureRepository;
import tn.esprit.spring.Repository.FournisseurRepository;
import tn.esprit.spring.Repository.ProduitRepository;
import tn.esprit.spring.Repository.RayonRepository;
import tn.esprit.spring.Repository.StockRepository;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;

@Service
public class ProduitServiceImpl implements IProduitService {
	
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	RayonRepository rayonRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	FactureRepository factureReository;

	public ProduitServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Produit> retriveAllProduits() {
		List<Produit> produitList = (List<Produit>) produitRepository.findAll();
		return produitList;
	}

	@Override
	public Produit addPrduit(Produit p, Long idRayon, Long idStock) {
		/*RayonRepository rayonRepository = null;
		StockRepository stockRepository = null;
		
		//Set<Rayon> r=rayonRepository.findById(idRayon);
		Optional<Rayon> r =  rayonRepository.findById(idRayon);
		Rayon rayon = r.get();
		p.setRayon(rayon);
		
		Optional<Stock> s =  stockRepository.findById(idStock);
		Stock stock = s.get();
		p.setStock(stock);*/
		
		Rayon r = rayonRepository.findById(idRayon).orElse(null);
		Stock s = stockRepository.findById(idStock).orElse(null);
		
		p.setRayon(r);
		p.setStock(s);
		
		
				
		produitRepository.save(p);
		return p;
		
	}

	@Override
	public Produit retrieveProduit(Long idProduit) {
		return produitRepository.findById(idProduit).orElse(null);
	}

	@Override
	public void deleteProduit(Long idFacture) {
		produitRepository.deleteById(idFacture);
		
	}

	@Override
	public Produit updateProduit(Produit p) {
		produitRepository.save(p);
		return p;
		
	}

	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Fournisseur f = fournisseurRepository.findById(fournisseurId).orElse(null);
		Produit p = produitRepository.findById(produitId).orElse(null);
		
		Set<Fournisseur> f2 = (Set<Fournisseur>) f;
		p.setFournisseurs(f2);
		
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		Produit p=produitRepository.findById(idProduit).orElse(null);

		return 0;
	}

	@Override
	public float getChiffreAffaireMagazin() {
		List<Produit> listProduit = (List<Produit>) produitRepository.findAll();
		return 0;
	}

}
