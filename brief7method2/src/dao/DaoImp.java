package dao;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

import dao.Candidats;
import applicationConnection.DBconnection;

public class DaoImp implements Dao {
	
	Connection conn = DBconnection.getconnect();
    Statement st;

	@Override
	public ObservableList<Candidats> CandidatsList() {
		ObservableList<Candidats> CList = FXCollections.observableArrayList();
        String query = "SELECT * FROM candidats";
        ResultSet rs;
        
        try{
			st = conn.createStatement();
            rs = st.executeQuery(query);
            Candidats C;
            while(rs.next()){
                C = new Candidats(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("address"),rs.getString("city"),rs.getString("country"));
                CList.add(C);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return CList;
	}

	@Override
	public void Create(String id, String firstName, String lastName, String mail, String adress, String city,String country) {
		String query = "INSERT INTO candidats VALUES (" +id + ",'" + firstName + "','" + lastName + "','" + mail + "','" + adress + "','" + city + "','" + country + "')";
	       
		try{
			st = conn.createStatement();
			st.executeUpdate(query);
			System.out.println("Creating is Done.");
		}catch(Exception ex){
            ex.printStackTrace();
			System.out.println("Creating Did not go will.");
        }
	}

	@Override
	public void Update(String id, String firstName, String lastName, String mail, String adress, String city,String country) {
        String query = "UPDATE  candidats SET id = '"+ id + "',firstname='"+ firstName + "', lastname = '" + lastName + "', email = '" + mail + "',  address = '" + adress + "' , city = '" + city + "' , country = '" + country + "' WHERE id =  "+ id ;
        
		try{
			st = conn.createStatement();
			st.executeUpdate(query);
			System.out.println("Updating is Done.");
		}catch(Exception e){
            e.printStackTrace();
			System.out.println("Updating Did not go will.");
        }
	}

	@Override
	public void Delete(String id) {
        String query = "DELETE FROM candidats WHERE id =" + id ;
        
		try{
			st = conn.createStatement();
			st.executeUpdate(query);
			  System.out.println("Deleting is Done.");
		}catch(Exception ex){
            ex.printStackTrace();
        }
		
	}

}
