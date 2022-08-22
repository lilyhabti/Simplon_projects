package com.example.gestion.servicesImp;

import java.util.List;
import java.util.Optional;

import com.example.gestion.entities.Responsable;
import com.example.gestion.repositories.ResponsableRepository;
import com.example.gestion.services.ResponsableService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ResponsableServiceImp implements ResponsableService {

	private ResponsableRepository responsableRepository;
	
	@Override
	public List<Responsable> getAllResponsables() {
		
		return responsableRepository.findAll();
	}

	@Override
	public void saveResponsable(Responsable responsable) {
		
		this.responsableRepository.save(responsable);
	}

	@Override
	public Responsable getResponsableById(long id) {
		Optional<Responsable> optional = responsableRepository.findById(id);
		Responsable responsable = null;
		if (optional.isPresent()) {
			responsable = optional.get();
		} else {
			throw new RuntimeException(" Responsable not found for id :: " + id);
		}
		return responsable;
	}

	@Override
	public void deleteResponsableById(long id) {
		
		this.responsableRepository.deleteById(id);
	}

}
