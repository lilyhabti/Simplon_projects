package com.brief11.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brief11.gestion.model.Employee;

@Repository
public interface GestionRepo extends JpaRepository<Employee, Long> {

}
