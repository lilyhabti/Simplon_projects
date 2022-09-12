package com.shos.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shos.gestion.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
