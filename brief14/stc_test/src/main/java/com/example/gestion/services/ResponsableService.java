package com.example.gestion.services;

import java.util.List;

import com.example.gestion.entities.Responsable;

public interface ResponsableService {

	List<Responsable> getAllResponsables();

	void saveResponsable(Responsable responsable);

	Responsable getResponsableById(long id);

	void deleteResponsableById(long id);
}
