package com.shos.gestion.service.impl;

import java.util.List;

import com.shos.gestion.entities.Categorie;
import com.shos.gestion.exception.ResourceNotFoundException;
import com.shos.gestion.repositories.CategorieRepository;
import com.shos.gestion.service.CategorieService;

public class CategorieServiceImpl implements CategorieService {
	
	private CategorieRepository categorieRepository;

	public CategorieServiceImpl(CategorieRepository categorieRepository) {
		super();
		this.categorieRepository = categorieRepository;
	}

	@Override
	public List<Categorie> listCategories() {
		
		return categorieRepository.findAll();
	}

	@Override
	public Categorie save(Categorie categorie) {
		
		return categorieRepository.save(categorie);
	}

	@Override
	public Categorie getById(long id) {
		
		return categorieRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Categorie", "Id", id));
	}

	@Override
	public Categorie update(Categorie categorie, long id) {
		
		Categorie existingCategorie = categorieRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Categorie", "Id", id));
		existingCategorie.setName(categorie.getName());
		existingCategorie.setDescriptif(categorie.getDescriptif());
		existingCategorie.setProduits(categorie.getProduits());
		
		return categorieRepository.save(existingCategorie);
	}

	@Override
	public void delete(long id) {
		
		categorieRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Categorie", "Id", id));
		
		categorieRepository.deleteById(id);
	}

}
