package ecole.gestion.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ecole.gestion.dao.StudentDaoInterface;
import ecole.gestion.entities.Student;
import util.HibernateUtil;

public class StudentDaoImp implements StudentDaoInterface {

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> selectAllStudents() {
		Transaction transaction = null;
		List<Student> students = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();

			students = session.createQuery("from Student").getResultList();

			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public void insertStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.save(student);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Student selectStudent(Integer studentId) {
		Transaction transaction = null;
		Student student = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			student = session.get(Student.class, studentId);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(student);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteStudent(int id) {
		Transaction transaction = null;
		boolean value = false;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();

			Student student = session.get(Student.class, id);
			
			if (student != null) {
				
				session.delete(student);
				
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
