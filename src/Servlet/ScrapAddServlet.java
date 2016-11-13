package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.RecipeManager;
import Manager.ScrapManager;

/**
 * 
 * @author GHKwon
 *
 */
public class ScrapAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Scrap �� Scrap�� �Խù��� add���ִ� ����.
     * ���� Scrap.do -> ScrapAddServelt���� �б����ֵ��� �����丵.
     * ���� �Ǿ� �� ���� ���� servlet.
     * ������ �켱�� ����.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ScrapManager scrapManager = new ScrapManager();
		System.out.println(request.getParameter("recipeCode"));
		System.out.println("postCode-"+new RecipeManager().searchPostCodeByRecipeCode(request.getParameter("recipeCode")));
		response.getOutputStream().print(scrapManager.insertScrap((String)request.getSession().getAttribute("userCode"), new RecipeManager().searchPostCodeByRecipeCode(request.getParameter("recipeCode"))));
		
	}

}
