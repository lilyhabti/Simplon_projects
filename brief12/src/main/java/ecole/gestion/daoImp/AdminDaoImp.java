package ecole.gestion.daoImp;


import org.hibernate.Session;
import org.hibernate.Transaction;

import ecole.gestion.dao.AdminDaoInterface;
import ecole.gestion.entities.Admin;
import ecole.gestion.entities.Student;
import util.HibernateUtil;

public class AdminDaoImp implements AdminDaoInterface {

	@Override
	public boolean validate(String username, String password) {
		Transaction transaction = null;
		Admin admin = null;
		boolean valid=false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			admin = (Admin) session.createQuery("FROM Admin A WHERE A.username = :username")
					.setParameter("username", username).uniqueResult();
			if (admin != null && admin.getPassword().equals(password)) {
				valid= true;
			}
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return valid;
	}

	@Override
	public boolean deleteAdmin(int id) {
		Transaction transaction = null;
		boolean value = false;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();

			Admin admin = session.get(Admin.class, id);
			
			if (admin != null) {
				
				session.delete(admin);
				
				value = true;
			}

			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return value;
	}

}
