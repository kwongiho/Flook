package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.LoginManager;
import Model.SessionManager;
import VO.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub 

		request.setCharacterEncoding("UTF-8");
		response.setContentType("utf-8");
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
		
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("utf-8");
		LoginManager loginManager = new LoginManager();
		UserVO userVO = loginManager.login(request.getParameter("Login_email_name"), request.getParameter("Login_input_password"));

		SessionManager manager=SessionManager.getInstance();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("userCode", userVO.getUserCode());
			session.setAttribute("userEmail",userVO.getUserEmail());
			session.setAttribute("userName",userVO.getUserName());
			String userImage=userVO.getUserImage();
			if(userImage==null)
			{
				userImage="http://www.blackmores.com.au/~/media/bklau/author/profiledefault.png";
			}
			session.setAttribute("userImage", userImage);
			
			
			request.setAttribute("loginOk", "success");

			HttpSession oldSession=manager.insert(userVO.getUserCode(), session);
	         if(oldSession!=null&&oldSession!=session)
	         {
	            oldSession.invalidate();
	         }
			response.sendRedirect("main");
		} catch(Exception ex) {
			request.setAttribute("loginError", "fail");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}
}
