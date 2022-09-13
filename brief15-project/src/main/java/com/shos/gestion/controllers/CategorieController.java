package com.shos.gestion.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shos.gestion.entities.Categorie;
import com.shos.gestion.service.CategorieService;

@RestController
public class CategorieController {
	
	private CategorieService categorieService;

	public CategorieController(CategorieService categorieService) {
		super();
		this.categorieService = categorieService;
	}
	
	@PostMapping(path = "/categories")
	public ResponseEntity<Categorie> saveCategorie(@RequestBody Categorie categorie){
		return new ResponseEntity<Categorie>(categorieService.save(categorie), HttpStatus.CREATED);
	}

	@GetMapping(path="/categories")
	public List<Categorie> getAllCategories(){
		
		return categorieService.listCategories();
	}
	
	@GetMapping(path="/categories/{id}")
	public ResponseEntity<Categorie> getCategorieById(@PathVariable("id") long id){
		return new ResponseEntity<Categorie>(categorieService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping(path="/categories/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable("id") long id ,@RequestBody Categorie categorie){
		return new ResponseEntity<Categorie>(categorieService.update(categorie, id), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/categories/{id}")
	public ResponseEntity<String> deleteCategorie(@PathVariable("id") long id){
		categorieService.delete(id);
			
		return new ResponseEntity<String>("Categorie deleted successfully!.", HttpStatus.OK);
	}
}
