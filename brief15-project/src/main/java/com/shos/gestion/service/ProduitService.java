package com.shos.gestion.service;

import java.util.List;

import com.shos.gestion.entities.Produit;

public interface ProduitService {
	
	List<Produit> listProduits();
	Produit save(Produit produit);
	Produit getById(long id);
	Produit update(Produit produit,long id);
	void delete(long id);

}
