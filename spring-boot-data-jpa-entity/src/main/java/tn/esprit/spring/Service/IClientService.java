package tn.esprit.spring.Service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Client;

public interface IClientService {
	
	List<Client> retrieveAllClients();
	Client addClient(Client c);
	void deleteClient(Long idClient);
	Client updateClient(Client c);
	Client retrieveCLient(Long idClient);
	List<Client> retrieveClientsSQL(Date date1, Date date2);
	List<Client> retrieveClientsJPQL(Date date1, Date date2);

}
