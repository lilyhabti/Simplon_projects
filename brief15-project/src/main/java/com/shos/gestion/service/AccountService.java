package com.shos.gestion.service;

import java.util.List;

import com.shos.gestion.entities.Admin;
import com.shos.gestion.entities.AppRole;
import com.shos.gestion.entities.AppUser;

public interface AccountService {
	
	AppRole addNewRole(AppRole appRole);
	Admin addNewUser(Admin admin);
	void addRoleToUser(String username,String roleName);
	AppUser loadUserByUsername(String username);
	List<AppUser> listUsers();

}
