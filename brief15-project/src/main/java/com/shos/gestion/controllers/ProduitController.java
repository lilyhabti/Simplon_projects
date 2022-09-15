package com.shos.gestion.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shos.gestion.entities.Produit;
import com.shos.gestion.service.ProduitService;

@RestController
public class ProduitController {
	
	private ProduitService produitService;

	public ProduitController(ProduitService produitService) {
		super();
		this.produitService = produitService;
	}
	
	@PostMapping(path = "/produits")
	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Produit> saveProduit(@RequestBody Produit produit){
		return new ResponseEntity<Produit>(produitService.save(produit), HttpStatus.CREATED);
	}

	@GetMapping(path="/produits")
	@PostAuthorize("hasAuthority('ADMIN','CLIENT')")
	public List<Produit> getAllProduits(){
		
		return produitService.listProduits();
	}

	@GetMapping(path="/produits/{id}")
	@PostAuthorize("hasAuthority('ADMIN','CLIENT')")
	public ResponseEntity<Produit> getProduitById(@PathVariable("id") long id){
		return new ResponseEntity<Produit>(produitService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping(path="/produits/{id}")
	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Produit> updateProduit(@PathVariable("id") long id ,@RequestBody Produit produit){
		return new ResponseEntity<Produit>(produitService.update(produit, id), HttpStatus.OK);
	}
	@DeleteMapping(path="/produits/{id}")
	@PostAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<String> deleteProduit(@PathVariable("id") long id){
		
		produitService.delete(id);
		return new ResponseEntity<String>("Produit deleted successfully!.", HttpStatus.OK);
	}
}
