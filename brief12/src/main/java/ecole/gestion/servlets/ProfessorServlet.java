package ecole.gestion.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import ecole.gestion.daoImp.ProfessorDaoImp;
import ecole.gestion.entities.Professor;


public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProfessorDaoImp professordao = new ProfessorDaoImp();
	ProfessorDaoImp professor = new ProfessorDaoImp();
	
    public ProfessorServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/add":
				showAddForm(request, response);
				break;
			case "/delete":
				deleteProfessor(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/insert":
				insertProfessor(request, response);
				break;
			case "/update":
				updateProfessor(request, response);
				break;
			default:
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/space.jsp");
//				dispatcher.forward(request, response);
				response.sendRedirect("professor");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/add_edit_professor.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int profid = Integer.parseInt(request.getParameter("id"));
		professor.deleteProfessor(profid);
		response.sendRedirect("professor");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int profid = Integer.parseInt(request.getParameter("id"));
		
		Professor existingProfessor = professor.selectProfessor(profid);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/add_edit_professor.jsp");
		request.setAttribute("existingProfessor", existingProfessor);
		dispatcher.forward(request, response);
	}
	
	private void insertProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String fullname = request.getParameter("fullname");
		String departement = request.getParameter("departement");

		Professor addprofessor = new Professor(fullname,departement);
		professor.insertProfessor(addprofessor);
		
		response.sendRedirect("professor");
	}
	private void updateProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String fullname = request.getParameter("fullname");
		String departement = request.getParameter("departement");

		Professor updateProfessor = new Professor(id,fullname,departement);
		professor.updateProfessor(updateProfessor);
		
		response.sendRedirect("professor");
	}

}
