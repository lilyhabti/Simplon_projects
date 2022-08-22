package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import daoImp.DaoImp;
import entities.Admin;
import entities.CurrentAdmin;
import entities.Employee;

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DaoImp dao = new DaoImp();

	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		this.getServletContext().getRequestDispatcher("/WEB-INF/jsps/login.jsp").forward(request, response);

		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/list":
				listEmployees(request, response);
				break;
			case "/add":
				showAddForm(request, response);
				break;
			case "/profile":
				showProfilForm(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/insert":
				insertEmployee(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			case "/change":
				changePassword(request, response);
				break;
			case "/login":
				showLoginForm(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/space.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Employee> listEmployees = dao.selectAllEmployees();
		request.setAttribute("listEmployees", listEmployees);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/space.jsp");
		dispatcher.forward(request, response);
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/actions.jsp");
		dispatcher.forward(request, response);
	}

	private void showProfilForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/profile.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/login.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteEmployee(id);
		response.sendRedirect("list");

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CurrentAdmin.setId(id);
		Employee existingEmployee = dao.selectEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsps/actions.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String departement = request.getParameter("departement");

		Employee employee = new Employee(fullname, email, departement);
		dao.insertEmployee(employee);
		response.sendRedirect("list");
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String departement = request.getParameter("departement");

		Employee employee = new Employee(CurrentAdmin.getId(), fullname, email, departement);
		dao.updateEmployee(employee);
		response.sendRedirect("list");
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");

		Admin admin = new Admin(CurrentAdmin.getCurrentAdminId(),fullname,username,confirmpassword);
		if (oldpassword.equals(CurrentAdmin.getCurrentpassword()) && newpassword.equals(confirmpassword)) {

			dao.updateAdmin(admin);

		} else if (oldpassword.equals(CurrentAdmin.getCurrentpassword())) {

			PrintWriter out = response.getWriter();
			out.println("Old password is Incorrect!!");

		} else if (newpassword.equals(confirmpassword)) {

			PrintWriter out = response.getWriter();
			out.println("Your new password isn't confirmed!!");
		}
		response.sendRedirect("login");
	}

}
