package ecole.gestion.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ecole.gestion.daoImp.AdminDaoImp;
import ecole.gestion.daoImp.CourseDaoImp;
import ecole.gestion.daoImp.StudentDaoImp;
import ecole.gestion.entities.Admin;
import ecole.gestion.entities.Course;
import ecole.gestion.entities.Professor;
import ecole.gestion.entities.Student;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
//		Professor professor1= new Professor(1,"Prof.Elhabti","Informatique");
//		Professor professor2= new Professor(2,"Prof.Raghib","Informatique");
//		Professor professor3= new Professor(3,"Prof.Elouardy","Maths");
//		session.save(professor1);
//		session.save(professor2);
//		session.save(professor3);
		
//		Course course1 = new Course(1,"course1","First course","1 month",professor1);
//		Course course2 = new Course(2,"course2","second course","1 month",professor2);
//		Course course3 = new Course(3,"course3","third course","1 month",professor3);
//		session.save(course1);
//		session.save(course2);
//		session.save(course3);
		
//		List<Course> courseList = new ArrayList<Course>();
//		courseList.add(course1);
//		courseList.add(course2);
//		courseList.add(course3);
//		Student student= new Student("AhmedBoajaja","Troncommun",courseList);
//		session.save(student);
//		Admin admin1 = new Admin("Ryle","12345");
		Admin admin1 = new Admin("Leila","12345");
		session.save(admin1);
//		session.save(admin1);
//		CourseDaoImp course = new CourseDaoImp();
//		course.deleteCourse(3);
//		StudentDaoImp student = new StudentDaoImp();
//		student.deleteStudent(1);
//		AdminDaoImp admin = new AdminDaoImp();
//		admin.deleteAdmin(1);
//		admin.deleteAdmin(2);
		session.getTransaction().commit();
        
		HibernateUtil.getSessionFactory().close();
	}

}
