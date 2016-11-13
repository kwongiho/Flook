package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.NicenessManager;
import Manager.RecipeManager;

/**
 * Servlet implementation class NicenessServlet
 */
public class NicenessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println("hi");
		String recipeCode = request.getParameter("recipeCode");
		HttpSession session=request.getSession();
		String userCode=(String)session.getAttribute("userCode");
		if(userCode==null)
		{ 
			response.sendRedirect("login");
		}
		String postCode = new RecipeManager().searchPostCodeByRecipeCode(recipeCode);
		NicenessManager nicenessManager=new NicenessManager();
		if(request.getParameter("like").equals("Y")) {
			System.out.println("추가");
			response.getOutputStream().print(nicenessManager.deleteNiceness(userCode, postCode));
			
		} else {
			System.out.println("삭제");
			response.getOutputStream().print(nicenessManager.insertNiceness(userCode, postCode));
		}
	}

}
