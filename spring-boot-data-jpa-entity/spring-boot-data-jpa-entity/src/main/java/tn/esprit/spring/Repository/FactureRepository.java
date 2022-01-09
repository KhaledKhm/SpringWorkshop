package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long> {
	
	@Query("SELECT SUM(c.montantFacture) from Facture c where c.active = TRUE")
	Number getMontantBrut();
	
	List<Facture> findByClientAndActive(Client client, Boolean active);

}
