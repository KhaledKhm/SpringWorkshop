package tn.esprit.spring.Service;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {

		@Autowired
		IStockService stockService;
		
		@Test
		public void testAddStock(){
			List<Stock> stocks = stockService.retriveAllStocks();
			int expected=stocks.size();
			Stock s = new Stock();
			s.setLibelleStock("Stock test add");
			s.setQteStock(10);
			s.setQteMin(100);
			Stock savedStock = stockService.addStock(s);
			assertEquals(expected+1, stockService.retriveAllStocks().size());
	 
				}
		
		@Test
		public void testDeleteStock(){
			Stock s = new Stock();
			s.setLibelleStock("Stock test delete");
			s.setQteStock(10);
			s.setQteMin(100);
			Stock savedStock = stockService.addStock(s);
			stockService.deleteStock(s.getIdStock());
			
		}
		
		
	

}
