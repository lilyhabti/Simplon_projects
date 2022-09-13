package com.shos.gestion.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shos.gestion.entities.Command;
import com.shos.gestion.exception.ResourceNotFoundException;
import com.shos.gestion.repositories.CommandRepository;
import com.shos.gestion.service.CommandService;
@Service
public class CommandServiceImpl implements CommandService {
	
	private CommandRepository commandRepository;

	public CommandServiceImpl(CommandRepository commandRepository) {
		super();
		this.commandRepository = commandRepository;
	}

	@Override
	public List<Command> listCommands() {
		
		return commandRepository.findAll();
	}

	@Override
	public Command save(Command command) {
		
		return commandRepository.save(command);
	}

	@Override
	public Command getById(long id) {
		
		return commandRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Command", "Id", id));
	}

	@Override
	public Command update(Command command, long id) {
		
		Command existingCommand = commandRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Command", "Id", id));
		
		existingCommand.setDateCommand(command.getDateCommand());
		existingCommand.setPrixTotal(command.getPrixTotal());
		existingCommand.setClient(command.getClient());
		existingCommand.setProduit(command.getProduit());
		
		return commandRepository.save(existingCommand);
	}

	@Override
	public void delete(long id) {
		
		commandRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Command", "Id", id));
		
		commandRepository.deleteById(id);
	}

}
