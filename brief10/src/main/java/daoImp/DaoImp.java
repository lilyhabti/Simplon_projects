package daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Dao;
import entities.Admin;
import entities.Employee;
import util.HibernateUtil;

public class DaoImp implements Dao {

	@Override
	public void insertEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the employee object
			session.save(employee);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Employee selectEmployee(Integer emplId) {
		Transaction transaction = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an employee object
			employee = session.get(Employee.class, emplId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Admin selectAdmin(String username,String password) {
		Transaction transaction = null;
		Admin admin = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an admin object

			admin = (Admin) session.get(username,password);

			// commit transaction
			transaction.commit();
			if (admin != null) {
				System.out.println("admin found");
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return admin;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> selectAllEmployees() {
		Transaction transaction = null;
		List<Employee> employees = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get employees list

			employees = session.createQuery("from Employee").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Transaction transaction = null;
		boolean value = false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete an employee object
			Employee employee = session.get(Employee.class, id);
			if (employee != null) {
				session.delete(employee);
				System.out.println("employee is deleted");
				value = true;
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public void updateEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the employee object
			session.saveOrUpdate(employee);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the admin object
			session.saveOrUpdate(admin);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public boolean validate(String username, String password) {
		System.out.println("hihihih");
		Transaction transaction = null;
		Admin admin = null;
		boolean valid=false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			admin = (Admin) session.createQuery("FROM Admin A WHERE A.username = :username")
					.setParameter("username", username).uniqueResult();
			if (admin != null && admin.getPassword().equals(password)) {
				System.out.println("hihihih");
				valid= true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return valid;
	}
}