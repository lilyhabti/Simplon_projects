package brief5;

//import java.sql.Connection;

//import java.util.List;

public interface DAO {
	
//	DBconnection sqlConnect=new DBconnection();
   	//public Connection sqlConnect = DBconnection.get_connection();
	
	//CREATE
		public Candidats save(Candidats item);
		
		
		
		
		//READ
		Candidats getById(int id);
	   
	    
	    
	    
	    //update
	    public void update(int id, Candidats item);
	    
	    
	    
	    //delete
	    public void delete(int id);
	
	
}
