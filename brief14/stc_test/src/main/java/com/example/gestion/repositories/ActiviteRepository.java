package com.example.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion.entities.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {

}
