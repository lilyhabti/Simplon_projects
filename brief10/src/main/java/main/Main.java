package main;

import org.hibernate.Session;

import daoImp.DaoImp;
import entities.Admin;
import entities.Employee;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

        //DaoImp dao = new DaoImp();
//        Employee employee = new Employee(1,"Fatiha","fatiha@gmail.com","Maths");
//        dao.updateEmployee(employee);
       // Admin admin = new Admin(2,"Anas","OS1","12345");
       // dao.updateAdmin(admin);
        
//        System.out.println(dao.deleteEmployee(2));
        
		HibernateUtil.getSessionFactory().close();
	}
}
