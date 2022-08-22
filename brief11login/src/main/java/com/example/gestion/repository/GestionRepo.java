package com.example.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion.model.Employee;

@Repository
public interface GestionRepo extends JpaRepository<Employee, Long> {

}
