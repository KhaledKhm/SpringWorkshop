package tn.esprit.spring.Service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.Service.IStockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImpTest {

	@Autowired
	IStockService stockService;
	
	@Test
	public void testAddClient(){
		
	}

}
