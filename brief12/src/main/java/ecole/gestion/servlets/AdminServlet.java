package ecole.gestion.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import ecole.gestion.daoImp.AdminDaoImp;


public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	AdminDaoImp login = new AdminDaoImp();
    
    public AdminServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsps/add_edit_student.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("loginUser");
		String password = request.getParameter("loginPass");
		
		
		boolean loginResult = login.validate(username, password);
		
		if(loginResult) {
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsps/space.jsp").forward(request, response);
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("Information incorrect!!");
		}
	}

}
