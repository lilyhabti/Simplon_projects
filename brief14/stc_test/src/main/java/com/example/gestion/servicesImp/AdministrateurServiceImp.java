package com.example.gestion.servicesImp;

import java.util.List;
import java.util.Optional;

import com.example.gestion.entities.Administrateur;
import com.example.gestion.repositories.AdministrateurRepository;
import com.example.gestion.services.AdministrateurService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdministrateurServiceImp implements AdministrateurService {

	
	private AdministrateurRepository administrateurRepository;
	
	@Override
	public List<Administrateur> getAllAdmins() {
		
		return administrateurRepository.findAll();
	}

	@Override
	public void saveAdmin(Administrateur admin) {
		
		this.administrateurRepository.save(admin);
	}

	@Override
	public Administrateur getAdminById(long id) {
		Optional<Administrateur> optional = administrateurRepository.findById(id);
		Administrateur admin = null;
		if (optional.isPresent()) {
			admin = optional.get();
		} else {
			throw new RuntimeException(" Admin not found for id :: " + id);
		}
		return admin;
	}

	@Override
	public void deleteAdminById(long id) {
		
		this.administrateurRepository.deleteById(id);
	}

}
