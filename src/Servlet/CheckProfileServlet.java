package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.UserManager;
import VO.UserWithFollowOrNotVO;

/**
 * Servlet implementation class CheckProfileServlet
 */
public class CheckProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userEmail=request.getParameter("userEmail");
		HttpSession session = request.getSession();
		String userCode = (String)session.getAttribute("userCode");
		
		//System.out.println(userEmail);
		UserManager manager= new UserManager();
		UserWithFollowOrNotVO vo = manager.searchEmailAndFollowOrNot(userEmail, userCode);
		request.setAttribute("user", vo);
		//System.out.println("이름:"+vo.getUserName()+",사진:"+vo.getUserImage());
		/*UserVO user=manager.seachEmail(userEmail);
		request.setAttribute("user", user);*/
		RequestDispatcher rd = request.getRequestDispatcher("targetProfile.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
