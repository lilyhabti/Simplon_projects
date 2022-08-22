package com.example.gestion.servicesImp;

import java.util.List;
import java.util.Optional;

import com.example.gestion.entities.Activite;
import com.example.gestion.repositories.ActiviteRepository;
import com.example.gestion.services.ActiviteService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ActiviteServiceImp implements ActiviteService{
	
	private ActiviteRepository activiteRepository;

	@Override
	public List<Activite> getAllActivites() {
		
		return activiteRepository.findAll();
	}

	@Override
	public void saveActivite(Activite activite) {
		
		this.activiteRepository.save(activite);
	}

	@Override
	public Activite getActiviteById(long id) {
		Optional<Activite> optional = activiteRepository.findById(id);
		Activite activite = null;
		if (optional.isPresent()) {
			activite = optional.get();
		} else {
			throw new RuntimeException(" Activite not found for id :: " + id);
		}
		return activite;
	}

	@Override
	public void deleteActiviteById(long id) {
		
		this.activiteRepository.deleteById(id);
	}

}
