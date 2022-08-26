package com.example.gestion.services.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.gestion.entities.Activite;
import com.example.gestion.exception.ResourceNotFoundException;
import com.example.gestion.repositories.ActiviteRepository;
import com.example.gestion.services.ActiviteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ActiviteServiceImp implements ActiviteService{
	
	private ActiviteRepository activiteRepository;

	@Override
	public List<Activite> getAllActivites() {
		
		return activiteRepository.findAll();
	}

	@Override
	public Activite saveActivite(Activite activite) {
		
		return activiteRepository.save(activite);
	}

	@Override
	public Activite getActiviteById(long id) {
//		Optional<Activite> optional = activiteRepository.findById(id);
//		Activite activite = null;
//		if (optional.isPresent()) {
//			activite = optional.get();
//		} else {
//			throw new RuntimeException(" Activite not found for id :: " + id);
//		}
//		return activite;
		return activiteRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Activite", "Id", id));
	}

	@Override
	public void deleteActiviteById(long id) {
		
		activiteRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Activite", "Id", id));
		
		activiteRepository.deleteById(id);
	}

	@Override
	public Activite updateActivite(Activite activite, long id) {
		
		Activite existingActivite = activiteRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Activite", "Id", id));	
		
		existingActivite.setTitre(activite.getTitre());
		existingActivite.setDescriptif(activite.getDescriptif());
		existingActivite.setType(activite.getType());
		existingActivite.setDate_debut(activite.getDate_debut());
		existingActivite.setDate_fin(activite.getDate_fin());
		existingActivite.setEtat(activite.getEtat());
		//existingActivite.setParticipants(activite.getParticipants());
		
		activiteRepository.save(existingActivite);
		return existingActivite;
	}

}
