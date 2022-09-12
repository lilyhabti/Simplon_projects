package com.shos.gestion.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.shos.gestion.entities.AppRole;
import com.shos.gestion.entities.AppUser;
import com.shos.gestion.repositories.AppRoleRepository;
import com.shos.gestion.repositories.AppUserRepository;
import com.shos.gestion.service.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private AppRoleRepository appRoleRepository;
	private AppUserRepository appUserRepository;
	private PasswordEncoder  passwordEncoder;

	public AccountServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.appRoleRepository = appRoleRepository;
		this.appUserRepository = appUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public AppRole addNewRole(AppRole appRole) {
		
		return appRoleRepository.save(appRole);
	}

	@Override
	public AppUser addNewUser(AppUser appUser) {
		
		String pw=appUser.getPassword();
		appUser.setPassword(passwordEncoder.encode(pw));

		return appUserRepository.save(appUser);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
	
		AppUser appUser = appUserRepository.findByUsername(username);
		AppRole appRole = appRoleRepository.findByRoleName(roleName);
		appUser.getAppRoles().add(appRole);
		appUserRepository.save(appUser);
		
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		
		return appUserRepository.findByUsername(username);
	}

	@Override
	public List<AppUser> listUsers() {
		
		return appUserRepository.findAll();
	}

}
