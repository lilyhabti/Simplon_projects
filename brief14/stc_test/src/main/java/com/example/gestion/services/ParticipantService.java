package com.example.gestion.services;

import java.util.List;


import com.example.gestion.entities.Participant;

public interface ParticipantService {

	List<Participant> getAllParticipants();

	void saveParticipant(Participant participant);

	Participant getParticipantById(long id);

	void deleteParticipantById(long id);
}
