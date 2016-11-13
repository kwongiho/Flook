package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.RecipeManager;

/**
 * Servlet implementation class DeleteMyRecipe
 */
public class DeleteMyRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		System.out.println("¿À³Ä");
		String recipeCode=request.getParameter("recipeCode");
		RecipeManager recipeManager=new RecipeManager();
		byte result=recipeManager.deleteRecipe(recipeCode);
		System.out.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("myWriteRecipe.jsp");
		rd.forward(request, response);
	}

}
