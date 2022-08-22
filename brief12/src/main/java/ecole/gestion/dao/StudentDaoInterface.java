package ecole.gestion.dao;

import java.util.List;

import ecole.gestion.entities.Student;

public interface StudentDaoInterface {

	public List<Student> selectAllStudents();//List all students
	
	public void insertStudent(Student student);// add student

	public Student selectStudent(Integer studentId);// retrieve student

	public void updateStudent(Student student);// update student

	public boolean deleteStudent(int id);// delete student
}
