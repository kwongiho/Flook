package Servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.FlookRecipeManager;
import ViewVO.SimpleRecipeViewVO;
import ViewVO.SimpleUserRecipeViewVO;

/**
 * Servlet implementation class FlookRecipe
 */
public class FlookRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html); charset=utf-8");
		request.setCharacterEncoding("utf-8");
		FlookRecipeManager flookRecipeManager = new FlookRecipeManager();
		LinkedList<SimpleRecipeViewVO> frecipeList=flookRecipeManager.searchFlookRecipeList(request.getParameter("method"),request.getParameter("situation"),request.getParameter("nation"),request.getParameter("ingredient"),request.getParameter("kindOf"));
		System.out.println(request.getParameter("method")+"--"+request.getParameter("situation")+"--"+request.getParameter("nation")+"--"+request.getParameter("ingredient")+"--"+request.getParameter("kindOf"));
		
		request.setAttribute("recommendsList",frecipeList.toArray(new SimpleRecipeViewVO[frecipeList.size()]));
		request.getRequestDispatcher("RecommendFactory.jsp").forward(request, response);
		
	}
}
