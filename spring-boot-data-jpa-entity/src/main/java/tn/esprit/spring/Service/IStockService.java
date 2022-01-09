package tn.esprit.spring.Service;

import java.util.List;
import tn.esprit.spring.entity.Stock;

public interface IStockService {
	List<Stock> retriveAllStocks();
	Stock addStock(Stock s);
	Stock updateStock(Stock u);
	Stock retriveStock(Long id);
	void deleteStock(Long idStock);
	String afficherStatusStock();

}
