package com.shos.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shos.gestion.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
