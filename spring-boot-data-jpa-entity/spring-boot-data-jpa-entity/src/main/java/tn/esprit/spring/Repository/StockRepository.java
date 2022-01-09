package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;



import tn.esprit.spring.entity.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {
	List<Stock> findStocksByQteStock(int qteStock);

}
