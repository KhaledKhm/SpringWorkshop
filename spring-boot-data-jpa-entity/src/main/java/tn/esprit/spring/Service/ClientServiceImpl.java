package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.ClientRepository;
import tn.esprit.spring.entity.Client;

@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	ClientRepository clientRepository;

	public ClientServiceImpl() {
		
	}

	@Override
	public List<Client> retrieveAllClients() {
		List<Client> clientList = (List<Client>) clientRepository.findAll();
		return clientList;
			
	}

	@Override
	public Client addClient(Client c) {
		clientRepository.save(c);
		return c;
	}

	@Override
	public void deleteClient(Long idClient) {
		clientRepository.deleteById(idClient);
		
	}

	@Override
	public Client updateClient(Client c) {
		clientRepository.save(c);
		return c;
	}

	@Override
	public Client retrieveCLient(Long idClient) {
		return clientRepository.findById(idClient).orElse(null);
	}

	

	@Query("SELECT c FROM Client c WHERE c.dateNaissance= BETWEEN :date1 AND :date2")
	@Override
	public List<Client> retrieveClientsSQL(@Param("date1") Date date1,@Param("date2") Date date2) {
		List<Client> clientList = (List<Client>) clientRepository.findAll();
		return clientList;
	}

	@Override
	public List<Client> retrieveClientsJPQL(Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}

}
