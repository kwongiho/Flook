package Servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.CommentManager;
import Manager.RecipeManager;
import UIBean.CookingUIBean;
import UIBean.IngredientUIBean;
import UIBean.IngredientUIVOBean;
import UIBean.UserRecipeUIBean;
import VO.CookingVO;
import ViewVO.IngredientViewVO;
import ViewVO.RecipeCategoryViewVO;
import ViewVO.UserRecipeViewVO;

/**
 * Servlet implementation class DetailUserRecipeServlet
 */
public class DetailUserRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		RecipeManager manager=new RecipeManager();
		
		String recipeCode=request.getParameter("choiceRecipe");
//		System.out.println(recipeCode);
		UserRecipeViewVO userRecipeViewVO=manager.searchUserRecipeInfo(recipeCode);
		if(userRecipeViewVO!=null)
		{
			manager.addPostHits(recipeCode);
		}
//		System.out.println(recipeCode);
		
		LinkedList<IngredientViewVO> mainIngreList=manager.searchMainUserRecipeIngredientList(recipeCode);
		LinkedList<IngredientViewVO> subIngreList=manager.searchSubUserRecipeIngredientList(recipeCode);
		LinkedList<CookingVO> cookList=manager.searchUserRecipeCookingList(recipeCode);
		LinkedList<CookingUIBean> cookingList=new LinkedList<CookingUIBean>();
		LinkedList<IngredientUIVOBean> mainIngredientList=new LinkedList<IngredientUIVOBean>();
		LinkedList<IngredientUIVOBean> subIngredientList=new LinkedList<IngredientUIVOBean>();
		for(CookingVO cook:cookList)
		{
			CookingUIBean bean=new CookingUIBean(cook.getCookingCode(), cook.getCookingImage(), cook.getCookingCaption());
			cookingList.add(bean);
//			System.out.println(bean);
		}
//		System.out.println(mainIngreList+"/////////////////////////이게 널이면 안되는뎅");
		for(IngredientViewVO mainIngredient:mainIngreList)
		{
			IngredientUIVOBean bean=new IngredientUIVOBean(mainIngredient.getIngredientName(), mainIngredient.getIngredientAmount(), mainIngredient.getIngredientUnitName(),mainIngredient.getIngredientCode());
			mainIngredientList.add(bean);
//			System.out.println(bean);
		}
//		System.out.println();
//		System.out.println();
//		System.out.println();
		
		for(IngredientViewVO subIngredient:subIngreList)
		{
			IngredientUIVOBean bean=new IngredientUIVOBean(subIngredient.getIngredientName(), subIngredient.getIngredientAmount(), subIngredient.getIngredientUnitName(),subIngredient.getIngredientCode());
			subIngredientList.add(bean);
//			System.out.println(bean);
		}
		RecipeCategoryViewVO recipeCategoryViewVO=manager.searchRecipeCategory(recipeCode);
		
//		System.out.println(recipeCategoryViewVO);
		String recipeName=userRecipeViewVO.getRecipeName();
		String completeImage=userRecipeViewVO.getCompleteImage();
		String recipeDescription=userRecipeViewVO.getRecipeDescription();
		String countryCategory=recipeCategoryViewVO.getCountryCategory();
		String ingredientCategory=recipeCategoryViewVO.getIngredientCategory();
		String kindCategory=recipeCategoryViewVO.getKindCategory();
		String situationCategory=recipeCategoryViewVO.getSituationCategory();
		String methodCategory=recipeCategoryViewVO.getMethodCategory();
		int personNumber=userRecipeViewVO.getPersonNumber();
		String cookingTime=userRecipeViewVO.getCookingTime();
		String cookingLevel=userRecipeViewVO.getCookingLevel(); 
		String hashTag=userRecipeViewVO.getPostHashTag();
		String userName=userRecipeViewVO.getUserName();
		String userImage=userRecipeViewVO.getUserImage();
		
		
		UserRecipeUIBean uiBean=new UserRecipeUIBean(recipeName, completeImage, recipeDescription, countryCategory, ingredientCategory, kindCategory, situationCategory, methodCategory, personNumber, cookingTime, cookingLevel, hashTag, cookingList.toArray(new CookingUIBean[ cookingList.size()] ), mainIngredientList.toArray(new IngredientUIBean[mainIngredientList.size()]), subIngredientList.toArray(new IngredientUIBean[subIngredientList.size()]), userName, userImage);
//		System.out.println(uiBean.getCompleteImage());
//		System.out.println("여기도 제발오거라!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		request.setAttribute("userUIBean", uiBean);
		
		request.setAttribute("postCode",manager.searchPostCodeByRecipeCode(recipeCode));
		
		CommentManager commentManager = new CommentManager();
		request.setAttribute("commentList", commentManager.searchComment(recipeCode));
		System.out.println("commentList : "+commentManager.searchComment(recipeCode));
		System.out.println("post-->"+request.getAttribute("postCode"));
		//response.getOutputStream().print("<jsp:include page='detailUserRecipe.jsp'/>");
		//response.getOutputStream().print(new String(recipeName.getBytes("utf-8"),"ISO-8859-1"));
		RequestDispatcher rd=request.getRequestDispatcher("detailUserRecipe.jsp");
		rd.forward(request, response);
	}
}
