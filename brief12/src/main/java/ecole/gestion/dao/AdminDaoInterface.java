package ecole.gestion.dao;

public interface AdminDaoInterface {
	
	public boolean validate(String username, String password);
	
	public boolean deleteAdmin(int id);// delete admin
}
