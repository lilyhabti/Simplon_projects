package com.shos.gestion.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shos.gestion.entities.Produit;
import com.shos.gestion.exception.ResourceNotFoundException;
import com.shos.gestion.repositories.ProduitRepository;
import com.shos.gestion.service.ProduitService;
@Service
public class ProduitServiceImpl implements ProduitService {
	
	private ProduitRepository produitRepository;

	public ProduitServiceImpl(ProduitRepository produitRepository) {
		super();
		this.produitRepository = produitRepository;
	}

	@Override
	public List<Produit> listProduits() {

		return produitRepository.findAll();
	}

	@Override
	public Produit save(Produit produit) {
		
		return produitRepository.save(produit);
	}

	@Override
	public Produit getById(long id) {
	
		return produitRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Produit", "Id", id));
	}

	@Override
	public Produit update(Produit produit, long id) {
		
		Produit existingProduit = produitRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Produit", "Id", id));
		existingProduit.setName(produit.getName());
		existingProduit.setDescriptif(produit.getDescriptif());
		existingProduit.setCountry(produit.getCountry());
		existingProduit.setPrix(produit.getPrix());
		existingProduit.setOrders(produit.getOrders());
		existingProduit.setCategorie(produit.getCategorie());
		
		return produitRepository.save(existingProduit);
	}

	@Override
	public void delete(long id) {
		
		produitRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Produit", "Id", id));
		
		produitRepository.deleteById(id);
	}

}
