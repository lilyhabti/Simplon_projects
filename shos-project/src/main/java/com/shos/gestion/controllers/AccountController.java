package com.shos.gestion.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shos.gestion.entities.AppUser;
import com.shos.gestion.service.AccountService;

@RestController
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@GetMapping(path = "/users")
	@PostAuthorize("hasAuthority('ADMIN')")
	public List<AppUser> getAllUsers(){
		
		return accountService.listUsers();
	}
	

}
