package com.shos.gestion.service;

import java.util.List;

import com.shos.gestion.entities.Categorie;

public interface CategorieService {
	
	List<Categorie> listCategories();
	Categorie save(Categorie categorie);
	Categorie getById(long id);
	Categorie update(Categorie categorie,long id);
	void delete(long id);
}
