package com.brief11.gestion.service;

import java.util.List;

import com.brief11.gestion.model.Employee;

public interface GestionService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
}
