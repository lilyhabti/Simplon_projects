package com.brief11.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brief11.gestion.model.Employee;
import com.brief11.gestion.repository.GestionRepo;


@Service
public class GestionServiceImp implements GestionService{

	@Autowired
	private GestionRepo gestionEmployee;
	
	@Override
	public List<Employee> getAllEmployees() {
		return gestionEmployee.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.gestionEmployee.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = gestionEmployee.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.gestionEmployee.deleteById(id);
	}
 
}
