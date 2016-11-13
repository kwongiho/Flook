package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.FindPasswordManager;

/**
 * Servlet implementation class FindPasswordChange
 */
public class FindPasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String email = request.getParameter("Login_email_email");
		String newPassword = request.getParameter("Login_input_code");
		FindPasswordManager findPasswordManager = new FindPasswordManager();
		findPasswordManager.changePassword(email, newPassword);
		
		response.sendRedirect("Login.jsp");
		
	}

}
