package Servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.MyScrapManager;
import Manager.UserManager;
import VO.UserWithFollowOrNotVO;
import ViewVO.ScrapViewVO;

/**
 * Servlet implementation class TargetMyScrap
 */
public class TargetMyScrap extends HttpServlet {
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
		
		MyScrapManager myScrapManager = new MyScrapManager();
		LinkedList<ScrapViewVO> myScrapList = myScrapManager
				.requestMyScrapList(userCode);
		ScrapViewVO res;
		Iterator<ScrapViewVO> iterator = myScrapList.iterator();
		while (iterator.hasNext()) {
			res = (ScrapViewVO) iterator.next();
			res.toString();
		}
		
		UserManager manager= new UserManager();
		UserWithFollowOrNotVO vo = manager.searchEmailAndFollowOrNot(userEmail, userCode);
		request.setAttribute("user", vo);
		
		
		request.setAttribute("myScrapList",myScrapList);

		RequestDispatcher rd = request.getRequestDispatcher("targetMyScrap.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
