package com.shos.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shos.gestion.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
