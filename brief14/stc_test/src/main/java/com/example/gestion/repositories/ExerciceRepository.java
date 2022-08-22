package com.example.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion.entities.Exercice;

public interface ExerciceRepository extends JpaRepository<Exercice, Long> {

}
