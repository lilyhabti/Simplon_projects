package ecole.gestion.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ecole.gestion.dao.CourseDaoInterface;
import ecole.gestion.entities.Course;
import util.HibernateUtil;

public class CourseDaoImp implements CourseDaoInterface {

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> selectAllCourses() {
		Transaction transaction = null;
		List<Course> courses = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();

			courses = session.createQuery("from Course").getResultList();

			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public void insertCourse(Course course) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.save(course);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Course selectCourse(Integer courseId) {
		Transaction transaction = null;
		Course course = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			course = session.get(Course.class, courseId);
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public void updateCourse(Course course) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(course);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteCourse(int id) {
		Transaction transaction = null;
		boolean value = false;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();

			Course course = session.get(Course.class, id);
			
			if (course != null) {
				session.delete(course);
				
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
