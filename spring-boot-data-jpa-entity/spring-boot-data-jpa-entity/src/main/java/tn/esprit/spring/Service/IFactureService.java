package tn.esprit.spring.Service;

import java.util.List;


import tn.esprit.spring.entity.Facture;

public interface IFactureService {
	List<Facture> retriveAllFactures();
	Facture addFacture(Facture f);
	void deleteFacture(Long idFacture);
	Facture updateFacture(Facture f);
	void CancelFacture(Long id);
	Facture retrieveFacture(Long id);
	List<Facture> getFacturesByClient(Long idClient);
	float getChiffreAffaireMagazin();
	void sommeFacture();

}
