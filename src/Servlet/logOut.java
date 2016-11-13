package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.SessionManager;

/**
 * Servlet implementation class logOut
 */
public class logOut extends HttpServlet {
   private static final long serialVersionUID = 1L;
   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      HttpSession session=request.getSession();
      String userCode=(String)session.getAttribute("userCode");
      SessionManager manager=SessionManager.getInstance();
      manager.insert(userCode, null);
      session.invalidate();
      response.sendRedirect("login");
   }

}