package com.example.gestion.servicesImp;

import java.util.List;
import java.util.Optional;

import com.example.gestion.entities.Exercice;
import com.example.gestion.repositories.ExerciceRepository;
import com.example.gestion.services.ExerciceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExerciceServiceImp implements ExerciceService {
	
	private ExerciceRepository exerciceRepository;

	@Override
	public List<Exercice> getAllExercices() {
		
		return exerciceRepository.findAll();
	}

	@Override
	public void saveExercice(Exercice exercice) {
		
		this.exerciceRepository.save(exercice);
	}

	@Override
	public Exercice getExerciceById(long id) {
		Optional<Exercice> optional = exerciceRepository.findById(id);
		Exercice exercice = null;
		if (optional.isPresent()) {
			exercice = optional.get();
		} else {
			throw new RuntimeException(" Exercice not found for id :: " + id);
		}
		return exercice;
	}

	@Override
	public void deleteExerciceById(long id) {
		
		this.exerciceRepository.deleteById(id);
	}

}
