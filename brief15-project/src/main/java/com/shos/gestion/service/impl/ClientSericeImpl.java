package com.shos.gestion.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shos.gestion.entities.AppRole;
import com.shos.gestion.entities.AppUser;
import com.shos.gestion.entities.Client;
import com.shos.gestion.repositories.AppRoleRepository;
import com.shos.gestion.repositories.AppUserRepository;
import com.shos.gestion.repositories.ClientRepository;
import com.shos.gestion.service.ClientService;
@Service
public class ClientSericeImpl implements ClientService {
	
	private ClientRepository clientRepository;
	private AppUserRepository appUserRepository;
	private AppRoleRepository appRoleRepository;
	private PasswordEncoder  passwordEncoder;

	public ClientSericeImpl(ClientRepository clientRepository, AppUserRepository appUserRepository,
			AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
		super();
		this.clientRepository = clientRepository;
		this.appUserRepository = appUserRepository;
		this.appRoleRepository = appRoleRepository;
		this.passwordEncoder = passwordEncoder;
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
			String pw = client.getPassword();
			client.setPassword(passwordEncoder.encode(pw));
			AppRole appRole = appRoleRepository.findByRoleName("CLIENT");
			client.getAppRoles().add(appRole);
			return clientRepository.save(client);
		}else {
            
			throw new RuntimeException("Username invalid");
		}
		
	}

}
