package com.shos.gestion.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shos.gestion.entities.Client;
import com.shos.gestion.repositories.ClientRepository;
import com.shos.gestion.service.ClientService;
@Service
public class ClientSericeImpl implements ClientService {
	
	private ClientRepository clientRepository;

	public ClientSericeImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}


	@Override
	public List<Client> listClients() {
		
		return clientRepository.findAll();
	}

}
