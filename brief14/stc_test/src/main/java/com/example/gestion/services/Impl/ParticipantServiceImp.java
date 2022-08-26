package com.example.gestion.services.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.gestion.entities.Participant;
import com.example.gestion.exception.ResourceNotFoundException;
import com.example.gestion.repositories.ParticipantRepository;
import com.example.gestion.services.ParticipantService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ParticipantServiceImp implements ParticipantService {
	
	private ParticipantRepository participantRepository;

	@Override
	public List<Participant> getAllParticipants() {
		
		return participantRepository.findAll();
	}

	@Override
	public Participant saveParticipant(Participant participant) {
		
		return participantRepository.save(participant);
	}

	@Override
	public Participant getParticipantById(long id) {
		
//		Optional<Participant> optional = participantRepository.findById(id);
//		Participant participant = null;
//		if (optional.isPresent()) {
//			participant = optional.get();
//		} else {
//			throw new RuntimeException(" Participant not found for id :: " + id);
//		}
//		return participant;
		
		return participantRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Participant", "Id", id));
	}

	@Override
	public void deleteParticipantById(long id) {
		
		participantRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Participant", "Id", id));
		
		participantRepository.deleteById(id);
	}

	@Override
	public Participant updateParticipant(Participant participant, long id) {
		
		Participant existingParticipant = participantRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Participant", "Id", id));
		
		
		existingParticipant.setNom(participant.getNom());
		existingParticipant.setPrenom(participant.getPrenom());
		existingParticipant.setEmail(participant.getEmail());
		existingParticipant.setLogin(participant.getLogin());
		existingParticipant.setPassword(participant.getPassword());
		existingParticipant.setTelephone(participant.getTelephone());
		existingParticipant.setStructure(participant.getStructure());
		existingParticipant.setDomaine(participant.getDomaine());
		
		participantRepository.save(existingParticipant);
		return existingParticipant;
	}

}
