package ecole.gestion.dao;

import java.util.List;

import ecole.gestion.entities.Professor;

public interface ProfessorDaoInterface  {

	public List<Professor> selectAllProfessors();//List all professors
	
	public void insertProfessor(Professor professor);//add  professor
	
	public Professor selectProfessor(Integer profId);//retrieve  professor
	
	public void updateProfessor(Professor professor);//update  professor
	
	public boolean deleteProfessor(int id);//delete  professor
}
