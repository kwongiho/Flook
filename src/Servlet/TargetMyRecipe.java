package Servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.print.attribute.standard.PrinterLocation;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.MyRecipeManager;
import Manager.UserManager;
import VO.UserWithFollowOrNotVO;
import ViewVO.SimpleUserRecipeViewVO;

/**
 * Servlet implementation class TargetMyRecipe
 */
public class TargetMyRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String userCode = request.getParameter("userCode");
		String userEmail = request.getParameter("userEmail");
		
		MyRecipeManager myRecipeManager = new MyRecipeManager();
		LinkedList<SimpleUserRecipeViewVO> simpleMyRecipeViewList = myRecipeManager.searchMyRecipeList(userCode);
		//SimpleUserRecipeViewVO[] simpleUserRecipeList = simpleUserRecipeViewList.toArray(new SimpleUserRecipeViewVO[simpleUserRecipeViewList.size()]);
		SimpleUserRecipeViewVO res;
		Iterator<SimpleUserRecipeViewVO> iterator = simpleMyRecipeViewList.iterator();
		while (iterator.hasNext()) {
			res = iterator.next();
			System.out.println(res.toString());
		}
		
		UserManager manager= new UserManager();
		UserWithFollowOrNotVO vo = manager.searchEmailAndFollowOrNot(userEmail, userCode);
		request.setAttribute("user", vo);
		
		request.setAttribute("simpleMyRecipeViewList", simpleMyRecipeViewList);


		System.out.println("servlet check : "+userEmail);
		RequestDispatcher rd = request.getRequestDispatcher("targetMyWriteRecipe.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
