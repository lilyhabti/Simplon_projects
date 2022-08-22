package dao;

import javafx.collections.ObservableList;

public interface Dao {
	
	public ObservableList<Candidats> CandidatsList();
	
	public void Create(String id,String firstName,String lastName,String mail,String adress,String city,String country);
	
	public void Update(String id,String firstName,String lastName,String mail,String adress,String city,String country);
	
	public void Delete(String id);
}
