package com.shos.gestion.service;

import java.util.List;

import com.shos.gestion.entities.AppRole;
import com.shos.gestion.entities.AppUser;

public interface AccountService {

	AppRole addNewRole(AppRole appRole);
	AppUser addNewUser(AppUser appUser);
	void addRoleToUser(String username,String roleName);
	AppUser loadUserByUsername(String username);
	List<AppUser> listUsers();
}
