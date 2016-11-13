package Servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.RecommendIngredientManager;
import Manager.RecommendKindManager;
import Manager.RecommendMethodManager;
import Manager.RecommendSituationManager;
import ViewVO.SimpleUserRecipeViewVO;

/**
 * Servlet implementation class RecommendSituationServlet
 */
public class RecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userCode = (String) session.getAttribute("userCode");
		String type = request.getParameter("type");
		LinkedList<SimpleUserRecipeViewVO> survList = new LinkedList<SimpleUserRecipeViewVO>();
		System.out.println("RecommendServlet type -> "+type);
		switch(type) {
			case "situation" :
				System.out.println("switch-situation");
				survList = situation(request.getParameter("data"),survList);
				break;
			case "ingredient" :
				System.out.println("switch-ingredient");
				survList = ingredient(request.getParameter("data"),survList);
				break ; 
			case "method" :
				System.out.println("switch-method");
				survList = method(request.getParameter("data"),survList);
				break ;
			case "kind" :
				System.out.println("switch-kind");
				System.out.println();
				survList = kind(request.getParameter("data"),survList);
				break ;
		}

		request.setAttribute("recommendsList", survList.toArray(new SimpleUserRecipeViewVO[survList.size()]));
		RequestDispatcher rd =  request.getRequestDispatcher("RecommendFactory.jsp");
		rd.forward(request,response);
		
	}
	public LinkedList<SimpleUserRecipeViewVO> situation(String situationName , LinkedList<SimpleUserRecipeViewVO> survList) {
		RecommendSituationManager manager = new RecommendSituationManager();
		return manager.searchSituation(situationName);
		
	}
	public LinkedList<SimpleUserRecipeViewVO> kind(String kindName , LinkedList<SimpleUserRecipeViewVO> survList) {
		RecommendKindManager manager = new RecommendKindManager();
		return manager.searchKind(kindName);
		
	}
	public LinkedList<SimpleUserRecipeViewVO> method(String methodName , LinkedList<SimpleUserRecipeViewVO> survList) {
		RecommendMethodManager manager = new RecommendMethodManager();
		return manager.searchMethod(methodName);
		
	}
	public LinkedList<SimpleUserRecipeViewVO> ingredient(String ingredientName , LinkedList<SimpleUserRecipeViewVO> survList) {
		RecommendIngredientManager manager = new RecommendIngredientManager();
		return manager.searchIngredient(ingredientName);
		
	}
}
/*HttpSession session = request.getSession();
String userCode = (String) session.getAttribute("userCode");

String situationName = request.getParameter("situation");
String firstIngredient = "������ǰ��";

String secondIngredient = "�ع���/�Ǿ��";

String firstMethod = "����";
String secondMethod = "����";


// LinkedList<String>recommendIngredient(firstIngredient,secondIngredient);
RecommendSituationManager manager = new RecommendSituationManager();
LinkedList<SimpleUserRecipeViewVO> situationList = manager.searchSituation(situationName);


RecommendationModel recommendationModel = new RecommendationModel();
LinkedList<SimpleUserRecipeViewVO> filtering = recommendationModel.filteringIngredient(situationList,
		firstIngredient, secondIngredient);


if (filtering.size() <= 6) {
	request.setAttribute("recommendsList",
			situationList.toArray(new SimpleUserRecipeViewVO[situationList.size()]));// �ϴ��̰ɷ�...
	RequestDispatcher rd = request.getRequestDispatcher("RecommendFactory.jsp");

	rd.forward(request, response);
	return;
}

filtering = recommendationModel.filteringMethod(filtering, firstMethod, secondMethod);

if (filtering.size() <= 6) {
	for (int i = 0; i < filtering.size(); i++) {
		request.setAttribute("recommendsList",
				situationList.toArray(new SimpleUserRecipeViewVO[situationList.size()]));
	}

	RequestDispatcher rd = request.getRequestDispatcher("RecommendFactory.jsp");

	rd.forward(request, response);
	return;
}*/