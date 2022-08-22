package com.example.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestion.entities.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
