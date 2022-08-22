package com.example.gestion.service;

import java.util.List;

import com.example.gestion.model.Employee;

public interface GestionService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
}
