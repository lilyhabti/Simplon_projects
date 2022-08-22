package com.example.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.model.Admin;
import com.example.gestion.repository.AdminRepo;



@Service
public class AdminService {
	
	@Autowired
	private AdminRepo adminRepo;

	public Admin login(String username, String password) {
		Admin admin = adminRepo.findByUsernameAndPassword(username, password);
		return admin;
	}

}