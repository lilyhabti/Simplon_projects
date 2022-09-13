package com.shos.gestion.service;

import java.util.List;

import com.shos.gestion.entities.Command;

public interface CommandService {
	
	List<Command> listCommands();
	Command save(Command command);
	Command getById(long id);
	Command update(Command command,long id);
	void delete(long id);

}
