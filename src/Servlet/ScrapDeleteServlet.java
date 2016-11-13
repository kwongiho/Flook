package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.RecipeManager;
import Manager.ScrapManager;

/**
 * Servlet implementation class ScrapDeleteServlet
 */
public class ScrapDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScrapManager scrapManager = new ScrapManager();
		response.getOutputStream().print(scrapManager.deleteScrap((String)request.getSession().getAttribute("userCode"), new RecipeManager().searchPostCodeByRecipeCode(request.getParameter("recipeCode"))));
		
	}

}
