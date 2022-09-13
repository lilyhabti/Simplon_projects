package com.shos.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shos.gestion.entities.Command;

public interface CommandRepository extends JpaRepository<Command,Long> {

}
