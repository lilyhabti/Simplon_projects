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

import com.shos.gestion.entities.Command;
import com.shos.gestion.service.CommandService;

@RestController
public class CommandController {
	
	private CommandService commandService;

	public CommandController(CommandService commandService) {
		super();
		this.commandService = commandService;
	}
	
	@PostMapping(path = "/commands")
	@PostAuthorize("hasAuthority('CLIENT')")
	public ResponseEntity<Command> saveCommand(@RequestBody Command command){
		return new ResponseEntity<Command>(commandService.save(command), HttpStatus.CREATED);
	}

	@GetMapping(path="/commands")
	@PostAuthorize("hasAuthority('CLIENT','ADMIN')")
	public List<Command> getAllCommands(){
		
		return commandService.listCommands();
	}
	
	@GetMapping(path="/commands/{id}")
	@PostAuthorize("hasAuthority('CLIENT','ADMIN')")
	public ResponseEntity<Command> getCommandById(@PathVariable("id") long id){
		return new ResponseEntity<Command>(commandService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping(path="/commands/{id}")
	@PostAuthorize("hasAuthority('CLIENT')")
	public ResponseEntity<Command> updateCommand(@PathVariable("id") long id ,@RequestBody Command command){
		return new ResponseEntity<Command>(commandService.update(command, id), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/commands/{id}")
	@PostAuthorize("hasAuthority('CLIENT')")
	public ResponseEntity<String> deleteCommand(@PathVariable("id") long id){
		
		commandService.delete(id);
		return new ResponseEntity<String>("Command deleted successfully!.", HttpStatus.OK);
	}
}
