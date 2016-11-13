package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.jrockit.jfr.RequestDelegate;

import Manager.NicenessPostManager;

/**
 * Servlet implementation class ProfileNicenessPostServlet
 */
public class ProfileNicenessPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session=request.getSession();
		String userCode=(String)session.getAttribute("userCode");
		if(userCode==null)
		{ 
			response.sendRedirect("login");
		}
		NicenessPostManager manager=new NicenessPostManager();
		System.out.println("check");
		int likeCount=manager.searchProfileNicenessCount(userCode);
		int postCount=manager.searchRecipeCount(userCode);
		//request.setAttribute("likeCount", likeCount);
		//request.setAttribute("postCount", postCount);
		
		session.setAttribute("likeCount", likeCount);
		session.setAttribute("postCount", postCount);
		RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
		rd.forward(request, response);
		
	}

}
