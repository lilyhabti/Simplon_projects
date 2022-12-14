package com.example.gestion.services.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.gestion.entities.Exercice;
import com.example.gestion.exception.ResourceNotFoundException;
import com.example.gestion.repositories.ExerciceRepository;
import com.example.gestion.services.ExerciceService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ExerciceServiceImp implements ExerciceService {
	
	private ExerciceRepository exerciceRepository;

	@Override
	public List<Exercice> getAllExercices() {
		
		return exerciceRepository.findAll();
	}

	@Override
	public Exercice saveExercice(Exercice exercice) {
		
		return exerciceRepository.save(exercice);
	}

	@Override
	public Exercice getExerciceById(long id) {
//		Optional<Exercice> optional = exerciceRepository.findById(id);
//		Exercice exercice = null;
//		if (optional.isPresent()) {
//			exercice = optional.get();
//		} else {
//			throw new RuntimeException(" Exercice not found for id :: " + id);
//		}
//		return exercice;
		
		return exerciceRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Exercice", "Id", id));
	}

	@Override
	public void deleteExerciceById(long id) {
		
		exerciceRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Exercice", "Id", id));
		
		exerciceRepository.deleteById(id);
	}

	@Override
	public Exercice updateExercice(Exercice exercice, long id) {

		Exercice existingExercice = exerciceRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Exercice", "Id", id));
        
        
        existingExercice.setAnnee(exercice.getAnnee());
        existingExercice.setDate_debut(exercice.getDate_debut());
        existingExercice.setDate_fin(exercice.getDate_fin());
        existingExercice.setStatut(exercice.getStatut());
        
        exerciceRepository.save(existingExercice);
		return existingExercice;
	}

}
