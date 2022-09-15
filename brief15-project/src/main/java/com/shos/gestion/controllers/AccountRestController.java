package com.shos.gestion.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shos.gestion.entities.Admin;
import com.shos.gestion.entities.AppRole;
import com.shos.gestion.entities.AppUser;
import com.shos.gestion.entities.Client;
import com.shos.gestion.service.AccountService;
import com.shos.gestion.service.ClientService;

@RestController
public class AccountRestController {
	
	private AccountService accountService;
	private ClientService clientService;

	public AccountRestController(AccountService accountService, ClientService clientService) {
		super();
		this.accountService = accountService;
		this.clientService = clientService;
	}
	@GetMapping(path = "/users")
	@PostAuthorize("hasAuthority('ADMIN')")
	public List<AppUser> getAllUsers(){
		
		return accountService.listUsers();
	}
	@GetMapping(path = "/clients")
	@PostAuthorize("hasAuthority('ADMIN')")
	public List<Client> getAllClients(){
		
		return clientService.listClients();
	}
	@PostMapping(path = "/addAdmin")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public Admin saveUser(@RequestBody Admin admin) {
		
		return accountService.addNewAdmin(admin);
	}

	@PostMapping(path = "/register")
	public String saveClient(@RequestBody Client client) {
		
		clientService.registerClient(client);

		return "Registered Successufully!";
	}
	
	@PostMapping(path = "/roles")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public AppRole saveRole(@RequestBody AppRole appRole) {
		
		return accountService.addNewRole(appRole);
	}
}

//@Data
//class RoleUserForm {
//	private String username;
//	private String roleName;
//}
