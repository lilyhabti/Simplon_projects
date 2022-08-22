package ecole.gestion.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ecole.gestion.dao.ProfessorDaoInterface;
import ecole.gestion.entities.Professor;
import util.HibernateUtil;

public class ProfessorDaoImp implements ProfessorDaoInterface{

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> selectAllProfessors() {
		Transaction transaction = null;
		List<Professor> professors = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			
			transaction = session.beginTransaction();

			professors = session.createQuery("from Professor").getResultList();

			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return professors;
	}

	@Override
	public void insertProfessor(Professor professor) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			
			transaction = session.beginTransaction();
			
			session.save(professor);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Professor selectProfessor(Integer profId) {
		Transaction transaction = null;
		Professor professor = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			
			transaction = session.beginTransaction();
			
			professor = session.get(Professor.class, profId);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return professor;
	}

	@Override
	public void updateProfessor(Professor professor) {
		
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(professor);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteProfessor(int id) {
		Transaction transaction = null;
		boolean value = false;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			
			transaction = session.beginTransaction();

			Professor professor = session.get(Professor.class, id);
			if (professor != null) {
				session.delete(professor);
				System.out.println("employee is deleted");
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
