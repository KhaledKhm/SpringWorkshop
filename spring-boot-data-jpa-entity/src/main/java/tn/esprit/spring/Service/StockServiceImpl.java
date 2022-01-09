package tn.esprit.spring.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.StockRepository;
import tn.esprit.spring.entity.Stock;


@Service
@Slf4j
public class StockServiceImpl implements IStockService{

	@Autowired
	StockRepository stockRepository;
	
	
	@Override
	public List<Stock> retriveAllStocks() {
		List<Stock> stockList = (List<Stock>) stockRepository.findAll();
		for (Stock stock : stockList){
			log.info(" stock: " +stock);
		}
		return stockList;
	}

	@Override
	public Stock addStock(Stock s) {
		stockRepository.save(s);
		return s;
	}

	@Override
	public Stock updateStock(Stock u) {
		stockRepository.save(u);
		return u;
	}

	@Override
	public Stock retriveStock(Long idStock) {
		return stockRepository.findById(idStock).orElse(null);
	}

	@Override
	public void deleteStock(Long idStock) {
		stockRepository.deleteById(idStock);
		
	}

	@Override
	public String afficherStatusStock() {
		List<Stock>s =stockRepository.findAll();
		String listStock = "List de stock en rupture:\n";
		for (int i = 0; i<s.size();i++){
			if((s.get(i).getQteStock()<s.get(i).getQteMin())){
				listStock="########################"+listStock+"\n En rupture - ID: "
						+s.get(i).getIdStock()+"\nLibelle: "
						+s.get(i).getLibelleStock()+"\n Quantity: "
						+s.get(i).getQteStock()+"\n Minimum allowed quantity: "
						+s.get(i).getQteMin()
						+"\n ########################";
			}
		}
		
		return listStock;
		
	}

	
	
	
	
	

}
