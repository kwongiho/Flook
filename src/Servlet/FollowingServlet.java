package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.FollowManager;
import Manager.UserManager;
import VO.UserWithFollowOrNotVO;
import ViewVO.FollowingViewVO;

/**
 * Servlet implementation class FollowingServlet
 */
public class FollowingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String userCode = (String)session.getAttribute("userCode");
		if(userCode==null)
		{ 
			response.sendRedirect("login");
		}
		//System.out.println("로그인 세션 확인 in servlet:"+userCode);
		
		String followUserCode = request.getParameter("userCode");
		String userEmail = request.getParameter("userEmail");
		
		//System.out.println("("+followUserCode+")");
		
		if(followUserCode == null)//profile.jsp에서 호출
		{
			//System.out.println("profile.jsp에서 호출");
			FollowManager manager = new FollowManager();
			ArrayList<FollowingViewVO> followingArray = manager.requestFollowingList(userCode);
			request.setAttribute("followingArray", followingArray);
			RequestDispatcher view = request.getRequestDispatcher("following.jsp");
			view.forward(request, response);
		}
		else
		{
			UserManager umanager= new UserManager();
			UserWithFollowOrNotVO vo = umanager.searchEmailAndFollowOrNot(userEmail, userCode);
			request.setAttribute("user", vo);
			
			FollowManager manager = new FollowManager();
			ArrayList<FollowingViewVO> followingArray = manager.requestFollowingList(followUserCode);
			request.setAttribute("followingArray", followingArray);
			RequestDispatcher view = request.getRequestDispatcher("targetFollowing.jsp");
			view.forward(request, response);
		}	
	}
}
