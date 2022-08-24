package com.example.gestion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion.entities.Responsable;
import com.example.gestion.services.ResponsableService;

@RestController
@RequestMapping("/api/responsables")
public class ResponsableController {

	private ResponsableService responsableService;

	public ResponsableController(ResponsableService responsableService) {
		super();
		this.responsableService = responsableService;
	}

	// build create a responsable REST API
	@PostMapping
	public ResponseEntity<Responsable> saveResponsable(@RequestBody Responsable responsable) {

		return new ResponseEntity<Responsable>(responsableService.saveResponsable(responsable), HttpStatus.CREATED);
	}
}
