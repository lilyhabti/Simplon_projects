package ecole.gestion.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import ecole.gestion.daoImp.CourseDaoImp;
import ecole.gestion.daoImp.ProfessorDaoImp;
import ecole.gestion.daoImp.StudentDaoImp;
import ecole.gestion.entities.Course;
import ecole.gestion.entities.Professor;
import ecole.gestion.entities.Student;


public class SpaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StudentDaoImp studentdao = new StudentDaoImp();
	ProfessorDaoImp professordao = new ProfessorDaoImp();
	CourseDaoImp coursedao = new CourseDaoImp();
	
    public SpaceServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/student":
				showStudentTable(request, response);
				break;
			case "/course":
				showCourseTable(request, response);
				break;
			case "/professor":
				showProfessorTable(request, response);
				break;
			case "/login":
				showLoginForm(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/space.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private void showStudentTable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Student> listStudents = studentdao.selectAllStudents();
		request.setAttribute("listStudents", listStudents);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/student.jsp");
		dispatcher.forward(request, response);
	}
	private void showCourseTable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Course> listCourses = coursedao.selectAllCourses();
		request.setAttribute("listCourses", listCourses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/course.jsp");
		dispatcher.forward(request, response);
	}
	private void showProfessorTable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Professor> listProfessors = professordao.selectAllProfessors();
		request.setAttribute("listProfessors", listProfessors);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/professor.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/login.jsp");
		dispatcher.forward(request, response);
	}
}
