package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.FlookRecipeManager;
import Manager.UserRecipeManager;
import ViewVO.SimpleRecipeViewVO;
import ViewVO.SimpleUserRecipeViewVO;

/**
 * Servlet implementation class TempServlet
 */
public class TempServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      response.setContentType("UTF-8");
      if(request.getParameter("temp").equals("flook")) {
         LinkedList<SimpleRecipeViewVO> simpleRecipeView = new FlookRecipeManager().requestSimpleRecipeList();
         request.setAttribute("recommendsList", simpleRecipeView.toArray(new SimpleRecipeViewVO[simpleRecipeView.size()]));
         request.getRequestDispatcher("RecommendFactory.jsp").forward(request, response);; // new FlookRecipeManager().requestSimpleRecipeList();
         return;
         
      } else if (request.getParameter("temp").equals("myRecipe")) {
         UserRecipeManager userRecipeManager = new UserRecipeManager();
         ArrayList<SimpleUserRecipeViewVO> userRecipeList = userRecipeManager.searchUserRecipeList();
         for(int i=0;i<userRecipeList.size();i++){
            System.out.println(userRecipeList.get(i));
         }
         request.setAttribute("recommendsList",userRecipeList.toArray(new SimpleUserRecipeViewVO[userRecipeList.size()]));
         request.getRequestDispatcher("RecommendFactory.jsp").forward(request, response);
         return ;
      }
   }

}