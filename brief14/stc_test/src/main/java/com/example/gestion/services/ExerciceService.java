package com.example.gestion.services;

import java.util.List;

import com.example.gestion.entities.Exercice;



public interface ExerciceService {

	List<Exercice> getAllExercices();

	void saveExercice(Exercice exercice);

	Exercice getExerciceById(long id);

	void deleteExerciceById(long id);
}
