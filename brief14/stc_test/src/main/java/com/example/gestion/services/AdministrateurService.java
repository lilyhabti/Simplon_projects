package com.example.gestion.services;

import java.util.List;

import com.example.gestion.entities.Administrateur;

public interface AdministrateurService {

	List<Administrateur> getAllAdmins();

	void saveAdmin(Administrateur admin);

	Administrateur getAdminById(long id);

	void deleteAdminById(long id);
}
