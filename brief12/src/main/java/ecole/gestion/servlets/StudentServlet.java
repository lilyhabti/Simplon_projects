package ecole.gestion.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import ecole.gestion.daoImp.StudentDaoImp;
import ecole.gestion.entities.Student;


public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	StudentDaoImp student = new StudentDaoImp();
    
    public StudentServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/add":
				showAddForm(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/insert":
				insertStudent(request, response);
				break;
			case "/update":
				updateStudent(request, response);
				break;
			default:
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/space.jsp");
//				dispatcher.forward(request, response);
				response.sendRedirect("student");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/add_edit_student.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int studentid = Integer.parseInt(request.getParameter("id"));
		student.deleteStudent(studentid);
		response.sendRedirect("student");
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int studentid = Integer.parseInt(request.getParameter("id"));
		
		Student existingStudent = student.selectStudent(studentid);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/add_edit_student.jsp");
		request.setAttribute("existingStudent", existingStudent);
		dispatcher.forward(request, response);
	}
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String fullname = request.getParameter("fullname");
		String level = request.getParameter("level");
		
		Student addStudent = new Student(fullname,level);
		student.insertStudent(addStudent);
		
		response.sendRedirect("student");
	}
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String fullname = request.getParameter("fullname");
		String level = request.getParameter("level");

		Student updateStudent = new Student(fullname,level);
		student.updateStudent(updateStudent);
		
		response.sendRedirect("student");
	}
}
