package com.shos.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shos.gestion.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {

	AppUser findByUsername(String username);
}
