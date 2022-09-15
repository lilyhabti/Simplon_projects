package com.shos.gestion.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shos.gestion.entities.Admin;
import com.shos.gestion.entities.AppRole;
import com.shos.gestion.entities.AppUser;
import com.shos.gestion.repositories.AdminRepository;
import com.shos.gestion.repositories.AppRoleRepository;
import com.shos.gestion.repositories.AppUserRepository;
import com.shos.gestion.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private AppRoleRepository appRoleRepository;
	private AppUserRepository appUserRepository;
	private AdminRepository adminRepository;
	private PasswordEncoder  passwordEncoder;

	public AccountServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository,
			AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
		super();
		this.appRoleRepository = appRoleRepository;
		this.appUserRepository = appUserRepository;
		this.adminRepository = adminRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public AppRole addNewRole(AppRole appRole) {
		
		return appRoleRepository.save(appRole);
	}

	@Override
	public Admin addNewAdmin(Admin admin) {
		
		String pw = admin.getPassword();
		admin.setPassword(passwordEncoder.encode(pw));
		AppRole appRole = appRoleRepository.findByRoleName("ADMIN");
		admin.getAppRoles().add(appRole);
		return adminRepository.save(admin);
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
