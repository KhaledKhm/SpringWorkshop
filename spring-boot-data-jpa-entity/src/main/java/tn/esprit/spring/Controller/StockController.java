package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.IStockService;
import tn.esprit.spring.entity.Stock;

@RestController("Stock")
public class StockController {

	@Autowired
	IStockService stockService;
	
	@PostMapping("/add-stock")
	@ResponseBody
	Stock addClient(@RequestBody Stock s){
		return stockService.addStock(s);
	}
	
	@GetMapping("/retrieve-allStock")
	@ResponseBody
	List<Stock> retrieveAllStock(){
		
		return stockService.retriveAllStocks();
	}
	
	@Scheduled(cron="*/60 * * * * *")
	@GetMapping("/afficher-status-stock")
	@ResponseBody
	void afficherStatusStock(){
		
		System.out.println("1 minute: " +stockService.afficherStatusStock());
		
	}
	
	@PutMapping("modify-stock")
	@ResponseBody
	Stock updateStock(@RequestBody Stock s){
		
		return stockService.updateStock(s);
	}
	
	@DeleteMapping("delete-stock/{id}")
	void deleteStock(@PathVariable("id") Long idStock){
		stockService.deleteStock(idStock);
		
	}
	

}
