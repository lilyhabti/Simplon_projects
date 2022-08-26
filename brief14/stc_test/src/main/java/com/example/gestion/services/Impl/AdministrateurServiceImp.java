package com.example.gestion.services.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.gestion.entities.Administrateur;
import com.example.gestion.exception.ResourceNotFoundException;
import com.example.gestion.repositories.AdministrateurRepository;
import com.example.gestion.services.AdministrateurService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdministrateurServiceImp implements AdministrateurService {

	private AdministrateurRepository administrateurRepository;

	@Override
	public List<Administrateur> getAllAdmins() {

		return administrateurRepository.findAll();
	}

	@Override
	public Administrateur saveAdmin(Administrateur admin) {

		return administrateurRepository.save(admin);
	}

	@Override
	public Administrateur getAdminById(long id) {
//		Optional<Administrateur> optional = administrateurRepository.findById(id);
//		Administrateur admin = null;
//		if (optional.isPresent()) {
//			admin = optional.get();
//		} else {
//			throw new RuntimeException(" Admin not found for id :: " + id);
//		}
//		return admin;
		return administrateurRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Administrateur", "Id", id));
	}

	@Override
	public void deleteAdminById(long id) {
		
		administrateurRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Admin", "Id", id));

		administrateurRepository.deleteById(id);
	}

	@Override
	public Administrateur updateAdministrateur(Administrateur administrateur, long id) {
		// we need to check whether admin with given id is exist in DB or not
		Administrateur existingAdministrateur = administrateurRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Administrateur", "Id", id));	
		
		
		
		existingAdministrateur.setNom(administrateur.getNom());
		existingAdministrateur.setPrenom(administrateur.getPrenom());
		existingAdministrateur.setEmail(administrateur.getEmail());
		existingAdministrateur.setLogin(administrateur.getLogin());
		existingAdministrateur.setPassword(administrateur.getPassword());
		existingAdministrateur.setTelephone(administrateur.getTelephone());
		existingAdministrateur.setEtat(administrateur.getEtat());
		// save existing employee to DB
		administrateurRepository.save(existingAdministrateur);
		return existingAdministrateur;
	}

}
