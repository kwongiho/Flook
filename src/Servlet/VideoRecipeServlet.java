package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ViewVO.SimpleVideoRecipeViewVO;
import Manager.VideoRecipeManager;

/**
 * Servlet implementation class VideoRecipeServlet
 */
public class VideoRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//int index = Integer.parseInt(request.getParameter("index"));
		int index=0;
		
		VideoRecipeManager videoManager = new VideoRecipeManager();
		ArrayList<SimpleVideoRecipeViewVO> array = videoManager.searchVideoRecipeList(index);
		request.setAttribute("videoArray", array);
		RequestDispatcher view = request.getRequestDispatcher("videoList.jsp");
		view.forward(request, response);
	}
}
