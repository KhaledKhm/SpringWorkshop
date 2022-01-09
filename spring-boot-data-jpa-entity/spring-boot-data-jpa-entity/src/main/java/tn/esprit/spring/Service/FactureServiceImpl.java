package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.Repository.FactureRepository;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;

@Slf4j
@Service
public class FactureServiceImpl implements IFactureService {
	
	@Autowired
	FactureRepository factureRepository;
	@Autowired
	ClientRepository clientRepository;

	public FactureServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Facture> retriveAllFactures() {
		List<Facture> factureList = (List<Facture>) factureRepository.findAll();
		return factureList;
	}

	@Override
	public void CancelFacture(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Facture retrieveFacture(Long idFacture) {
		return factureRepository.findById(idFacture).orElse(null);
	}

	@Override
	public Facture addFacture(Facture f) {
		factureRepository.save(f);
		return f;
		
	}

	@Override
	public void deleteFacture(Long idFacture) {
		factureRepository.deleteById(idFacture);
		
	}

	@Override
	public Facture updateFacture(Facture f) {
		factureRepository.save(f);
		return f;
	}

	@Override
	public List<Facture> getFacturesByClient(Long idClient) {
		Client client = clientRepository.findById(idClient).orElse(null);
		return factureRepository.findByClientAndActive(client,true);
		
		
		//List<Facture> factureList = (List<Facture>) factureRepository;
	
		//return factureList;
	}

	@Override
	public float getChiffreAffaireMagazin() {
		// TODO Auto-generated method stub
		return 0;
	}
 
	@Override
	@Scheduled(cron ="0 0 0 1 1 *")
	public void sommeFacture() {
		Number x=factureRepository.getMontantBrut();
		log.info("La somme des factures de magazin est "+x);
		
	}

}
