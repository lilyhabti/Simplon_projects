package brief5;

import java.sql.*;

public class DaoImp implements DAO {
	Connection connection = DBconnection.get_connection();

	@Override
	public Candidats save(Candidats item) {
		try {
			String query = "INSERT INTO candidats(nom,prenom,mail,adresse,ville,pays) VALUES (?,?, ?, ?, ?,?)";
			PreparedStatement ps = connection.prepareStatement(query);

			connection.setAutoCommit(false);
			ps.setString(1, item.getNom());
			ps.setString(2, item.getPrenom());
			ps.setString(3, item.getMail());
			ps.setString(4, item.getAdresse());
			ps.setString(5, item.getVille());
			ps.setString(6, item.getPays());
			ps.execute();

			connection.commit();
			ps.close();
			connection.close();

			return item;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Candidats getById(int id) {
		Candidats item = null;
		try {
			String query = "SELECT nom, prenom,mail, adresse, ville, pays FROM candidats WHERE id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {
				item = new Candidats(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				
				item.setId(id);
			}

			ps.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public void update(int id, Candidats item) {
		String query = "update candidats set nom= ?, prenom =?,mail = ?, adresse=?, ville=?, pays=? WHERE id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, item.getNom());
			ps.setString(2, item.getPrenom());
			ps.setString(3, item.getMail());
			ps.setString(4, item.getAdresse());
			ps.setString(5, item.getVille());
			ps.setString(6, item.getPays());
			ps.setInt(7, id);

			int result = ps.executeUpdate();
			if (result == 1) {
				System.out.println("Database updated successfully ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM candidats WHERE id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			// rows affected
			System.out.println("Number of deleted rows :" + row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
