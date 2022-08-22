package com.example.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion.entities.Administrateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

}
