package dao;

import java.util.List;

import entities.Admin;
import entities.Employee;

public interface Dao {
	
	public void insertEmployee(Employee employee);//add an employee
	
	public Employee selectEmployee(Integer emplId);//retrieve an employee
	
	public Admin selectAdmin(String username,String password);//retrieve an admin
	
	public List<Employee> selectAllEmployees();//List all employees
	
	public boolean deleteEmployee(int id);//delete an employee
	
	public void updateEmployee(Employee employee);//update an employee
	
	public void updateAdmin(Admin admin);//update an admin
	
	public boolean validate(String username, String password);
}