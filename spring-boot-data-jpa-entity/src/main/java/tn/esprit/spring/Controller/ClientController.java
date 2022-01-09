package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.IClientService;
import tn.esprit.spring.entity.Client;

@RestController
public class ClientController {

	@Autowired
	IClientService clientService;
	
	@PostMapping("/add-client")
	@ResponseBody
	Client addClient(@RequestBody Client c){
		return clientService.addClient(c);
	}
	
	@GetMapping("/retrieve-allClient")
	@ResponseBody
	List<Client> retrieveAllClient(){
		
		return clientService.retrieveAllClients();
	}
	
	@PutMapping("modify-client")
	@ResponseBody
	Client updateClient(@RequestBody Client c){
		
		return clientService.updateClient(c);
	}
	
	@DeleteMapping("delete-client/{id}")
	void deleteClient(@PathVariable("id") Long idClient){
		clientService.deleteClient(idClient);
		
	}
	
	
}
