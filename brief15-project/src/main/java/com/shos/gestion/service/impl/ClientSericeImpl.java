package com.shos.gestion.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shos.gestion.entities.AppRole;
import com.shos.gestion.entities.AppUser;
import com.shos.gestion.entities.Client;
import com.shos.gestion.exception.ResourceNotFoundException;
import com.shos.gestion.repositories.AppRoleRepository;
import com.shos.gestion.repositories.AppUserRepository;
import com.shos.gestion.repositories.ClientRepository;
import com.shos.gestion.service.ClientService;
@Service
public class ClientSericeImpl implements ClientService {
	
	private ClientRepository clientRepository;
	private AppUserRepository appUserRepository;
	private AppRoleRepository appRoleRepository;

	public ClientSericeImpl(ClientRepository clientRepository, AppUserRepository appUserRepository,
			AppRoleRepository appRoleRepository) {
		super();
		this.clientRepository = clientRepository;
		this.appUserRepository = appUserRepository;
		this.appRoleRepository = appRoleRepository;
	}


	@Override
	public List<Client> listClients() {
		
		return clientRepository.findAll();
	}


	@Override
	public Client registerClient(Client client) {
		
		String username = client.getUsername();
		AppUser user= appUserRepository.findByUsername(username);
		if(user==null) {
			AppRole appRole = appRoleRepository.findByRoleName("CLIENT");
			client.getAppRoles().add(appRole);
			return clientRepository.save(client);
		}else {
            
			return clientRepository.findById(client.getId()).orElseThrow(() -> 
			new ResourceNotFoundException("Client", "Id", client.getId()));
		}
		
	}

}
