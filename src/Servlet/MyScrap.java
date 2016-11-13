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
import ViewVO.ScrapViewVO;

/**
 * Servlet implementation class MyScrap
 */
public class MyScrap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("여기와라!");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		HttpSession session = request.getSession();
		String userCode = (String) session.getAttribute("userCode");
		if(userCode==null)
		{ 
			response.sendRedirect("login");
		}
		MyScrapManager myScrapManager = new MyScrapManager();
		LinkedList<ScrapViewVO> myScrapList = myScrapManager
				.requestMyScrapList(userCode);
		ScrapViewVO res;
		Iterator<ScrapViewVO> iterator = myScrapList.iterator();
		while (iterator.hasNext()) {
			res = (ScrapViewVO) iterator.next();
			res.toString();
		}
		request.setAttribute("myScrapList",myScrapList);

		RequestDispatcher rd = request.getRequestDispatcher("myScrap.jsp");
		rd.forward(request, response);
	}
}
