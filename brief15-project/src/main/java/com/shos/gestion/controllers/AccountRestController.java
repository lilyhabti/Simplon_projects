package com.shos.gestion.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shos.gestion.entities.Admin;
import com.shos.gestion.entities.AppRole;
import com.shos.gestion.entities.AppUser;
import com.shos.gestion.service.AccountService;

@RestController
public class AccountRestController {
	
	private AccountService accountService;

	public AccountRestController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@GetMapping(path = "/users")
	public List<AppUser> getAllUsers(){
		
		return accountService.listUsers();
	}
	@PostMapping(path = "/addAdmin")
	public Admin saveUser(@RequestBody Admin admin) {
		
		return accountService.addNewAdmin(admin);
	}

	@PostMapping(path = "/roles")
	public AppRole saveRole(@RequestBody AppRole appRole) {
		
		return accountService.addNewRole(appRole);
	}
}

//@Data
//class RoleUserForm {
//	private String username;
//	private String roleName;
//}
