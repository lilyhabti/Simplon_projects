package ecole.gestion.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import ecole.gestion.daoImp.CourseDaoImp;
import ecole.gestion.entities.Course;

public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CourseDaoImp course = new CourseDaoImp();
    
    public CourseServlet() {
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
				deleteCourse(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/insert":
				insertCourse(request, response);
				break;
			case "/update":
				updateCourse(request, response);
				break;
			default:
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/space.jsp");
//				dispatcher.forward(request, response);
				response.sendRedirect("course");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/add_edit_course.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int courseid = Integer.parseInt(request.getParameter("id"));
		course.deleteCourse(courseid);
		response.sendRedirect("course");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Integer courseid = Integer.parseInt(request.getParameter("id"));
		
		Course existingCourse = course.selectCourse(courseid);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/add_edit_course.jsp");
		request.setAttribute("existingCourse", existingCourse);
		dispatcher.forward(request, response);
	}
	
	private void insertCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String coursename = request.getParameter("coursename");
		String description = request.getParameter("description");
		String duration = request.getParameter("duration");

		Course addCourse = new Course(coursename,description,duration);
		course.insertCourse(addCourse);
		response.sendRedirect("course");
	}
	private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String coursename = request.getParameter("coursename");
		String description = request.getParameter("description");
		String duration = request.getParameter("duration");

		Course updateCourse = new Course(id,coursename,description,duration);
		course.updateCourse(updateCourse);
		response.sendRedirect("professor");
	}
}
