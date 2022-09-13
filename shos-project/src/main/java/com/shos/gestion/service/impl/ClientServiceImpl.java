package com.shos.gestion.service.impl;

import java.util.List;

import com.shos.gestion.entities.Client;
import com.shos.gestion.repositories.ClientRepository;
import com.shos.gestion.service.ClientService;

public class ClientServiceImpl implements ClientService {
	
	private ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}


	@Override
	public List<Client> listClients() {
		
		return clientRepository.findAll();
	}

}
