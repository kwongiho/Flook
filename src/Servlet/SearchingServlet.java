package Servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.SearchManager;
import VO.UserVO;
import ViewVO.FlookRecipeViewVO;
import ViewVO.SimpleRecipeViewVO;
import ViewVO.SimpleUserRecipeViewVO;
import ViewVO.UserRecipeViewVO;

/**
 * Servlet implementation class SearchingServlet
 */
public class SearchingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("search_input_keyword");/*이 이름은 추후에 변경됨.*/
		/*System.out.println(keyword);*/
		SearchManager searchManager = new SearchManager();
		
		LinkedList<SimpleRecipeViewVO> simpleRecipeViewVOByName = searchManager.searchFlookRecipeListByRecipeName(keyword);
		/*System.out.println(searchManager.searchFlookRecipeListByRecipeName(keyword).get(0));*/
		LinkedList<FlookRecipeViewVO> flookRecipeViewVOByHashTag = searchManager.searchFlookRecipeListByHashTag(keyword);
		LinkedList<SimpleUserRecipeViewVO> simpleUserRecipeViewVOByName = searchManager.searchUserRecipeListByRecipeName(keyword);
		LinkedList<UserRecipeViewVO> userRecipeViewVOByHashTag = searchManager.searchUserRecipeListByHashTag(keyword);
		LinkedList<UserVO> userVOList = searchManager.searchUserListByUserName(keyword);
		System.out.println(simpleRecipeViewVOByName+"/simpleRecipeViewVOByName");
		System.out.println(flookRecipeViewVOByHashTag+"/flookRecipeViewVOByHashTag");
		System.out.println(simpleUserRecipeViewVOByName+"/simpleUserRecipeViewVOByName");
		System.out.println(userRecipeViewVOByHashTag+"/userRecipeViewVOByHashTag");
		System.out.println(userVOList+"/userVOList");
		/*치햄이 배열로 넘겨서 넘긴다고 함.*/
		request.setAttribute("simpleRecipeByName", simpleRecipeViewVOByName.toArray(new SimpleRecipeViewVO[simpleRecipeViewVOByName.size()]));
		request.setAttribute("simpleRecipeByHashTag",flookRecipeViewVOByHashTag.toArray(new FlookRecipeViewVO[flookRecipeViewVOByHashTag.size()]));
		request.setAttribute("simpleUserRecipeByName", simpleUserRecipeViewVOByName.toArray(new SimpleUserRecipeViewVO[simpleUserRecipeViewVOByName.size()]));
		request.setAttribute("simpleUserRecipeByHashTag",userRecipeViewVOByHashTag.toArray(new UserRecipeViewVO[userRecipeViewVOByHashTag.size()]));
		request.setAttribute("UserList",userVOList.toArray(new UserVO[userVOList.size()]));
		
		/*String[] searchResult = new String[]{"전체보기","레시피명","사용자명","해시태그"};
		request.setAttribute("searchResultMenu",searchResult);*/
		
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}

}
