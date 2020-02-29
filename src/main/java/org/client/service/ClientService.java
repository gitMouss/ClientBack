package org.client.service;

import java.util.List;
import java.util.Optional;

import org.client.dao.ClientDao;
import org.client.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ClientService {

	@Autowired
	private ClientDao dao;
	
	//Récupérer la liste des clients
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public List<Client> getClients(){
		
		return dao.findAll();
	}
	
	//Récupérer un seul client
	@RequestMapping(value = "/client/{code}", method = RequestMethod.GET)
	public Optional<Client> getClient(@PathVariable Long code) {
		return dao.findById(code);
	}
	
	//Supprimer un client
	@RequestMapping(value = "/clients/{code}", method = RequestMethod.DELETE)
	public boolean deleteClient(@PathVariable Long code) {
		dao.deleteById(code);
		return true;
	}
	
	//Sauvegarder un client
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Client saveClient(@RequestBody Client c) {
		return dao.save(c);
	}
	
	
	
	
}
