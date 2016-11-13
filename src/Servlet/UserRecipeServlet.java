package Servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.UserRecipeManager;
import ViewVO.SimpleUserRecipeViewVO;

/**
 * Servlet implementation class UserRecipeServlet
 */
public class UserRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		UserRecipeManager userRecipeManager = new UserRecipeManager();
	
		
		/*System.out.println(request.getParameter("method")+"-"+request.getParameter("situation")+"-"+request.getParameter("nation")+"-"+request.getParameter("ingredient")+"-"+request.getParameter("kindOf"));*/
		LinkedList<SimpleUserRecipeViewVO> userRecipeList = userRecipeManager.searchUserRecipeList(request.getParameter("method"),request.getParameter("situation"),request.getParameter("nation"),request.getParameter("ingredient"),request.getParameter("kindOf"));
		request.setAttribute("recommendsList",userRecipeList.toArray(new SimpleUserRecipeViewVO[userRecipeList.size()]));
		System.out.println(request.getParameter("method")+"/"+request.getParameter("situation")+"/"+request.getParameter("nation")+"/"+request.getParameter("ingredient")+"/"+request.getParameter("kindOf"));
		request.getRequestDispatcher("RecommendFactory.jsp").forward(request, response);
		
		
		

		
		
	}

}