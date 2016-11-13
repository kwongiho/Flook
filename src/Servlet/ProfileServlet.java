package Servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Calculate.CalculatePercent;
import Manager.ProfileAnalyzingManager;
import Model.MessageGenerator;
import UIBean.ProfileAnalyzingUIBean;
import ViewVO.MyCountryPreferenceViewVO;
import ViewVO.MyIngredientPreferenceViewVO;
import ViewVO.MyKindPreferenceViewVO;
import ViewVO.MyMethodPreferenceViewVO;
import ViewVO.MySituationPreferenceViewVO;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*HttpSession session = request.getSession();
		String userCode=(String)session.getAttribute("userCode");
		*/
		ProfileAnalyzingManager profileAnalyzing = new ProfileAnalyzingManager();
		/*MyIngredientPreferenceViewDAO ingredientList=MyIngredientPreferenceViewDAO.getInstance();
		MyKindPreferenceViewDAO kindList=MyKindPreferenceViewDAO.getInstance();
		MyCountryPreferenceViewDAO countryList = MyCountryPreferenceViewDAO.getInstance();
		MyMethodPreferenceViewDAO methodList= MyMethodPreferenceViewDAO.getInstance();
		MySituationPreferenceViewDAO situList= MySituationPreferenceViewDAO.getInstance();*/
		
		HttpSession session=request.getSession();
		String userCode=(String)session.getAttribute("userCode");
		//String userCode="UT001";
		///System.out.println("userCode´Â=="+userCode);
		if(userCode==null)
		{ 
			response.sendRedirect("login");
		}
		
		LinkedList<MyCountryPreferenceViewVO> countryResult = profileAnalyzing.analyzingMyCountryPreference(userCode);
		LinkedList<MyIngredientPreferenceViewVO> ingredientResult = profileAnalyzing.analyzingMyIngredientPreference(userCode);
		//LinkedList<MyKindPreferenceViewVO> kindResult=profileAnalyzing.analyzingMyKindPreference(userCode);
		LinkedList<MyMethodPreferenceViewVO> methodResult=profileAnalyzing.analyzingMyMethodPreference(userCode);
		//LinkedList<MySituationPreferenceViewVO> situResult=profileAnalyzing.analyzingMySituationPreference(userCode);
		
		CalculatePercent calculatePercent = new CalculatePercent(countryResult,ingredientResult,methodResult);
		
		LinkedList<String> countryPercents=calculatePercent.calculateCountryPercent(countryResult);
		LinkedList<String> ingredientPercents=calculatePercent.calculateIngredientPercent(ingredientResult);
		LinkedList<String> methodPercents=calculatePercent.calculateMethodPercent(methodResult);
		
		MessageGenerator messageGenerator=new MessageGenerator();
		
		
		LinkedList<ProfileAnalyzingUIBean> countryUIBeanList=new LinkedList<ProfileAnalyzingUIBean>();
		for(int i=0;i<countryResult.size();i++){
			countryUIBeanList.add(new ProfileAnalyzingUIBean(countryResult.get(i).getCountryCategoryName(),countryPercents.get(i)));
		}
		
		LinkedList<ProfileAnalyzingUIBean> ingredientUIBeanList=new LinkedList<ProfileAnalyzingUIBean>();
		for(int i=0;i<ingredientResult.size();i++){
			ingredientUIBeanList.add(new ProfileAnalyzingUIBean(ingredientResult.get(i).getIngredientCategoryName(),ingredientPercents.get(i)));
		}
		
		LinkedList<ProfileAnalyzingUIBean> methodUIBeanList=new LinkedList<ProfileAnalyzingUIBean>();
		for(int i=0;i<methodResult.size();i++){
			methodUIBeanList.add(new ProfileAnalyzingUIBean(methodResult.get(i).getMethodCategoryName(),methodPercents.get(i)));
		}
		
		for(int i=0;i<countryUIBeanList.size();i++){
			System.out.println("countryUIBean: "+countryUIBeanList.get(i));
		}
		for(int i=0;i<ingredientUIBeanList.size();i++){
			System.out.println("ingredientUIBean: "+ingredientUIBeanList.get(i));
		}
		for(int i=0;i<methodUIBeanList.size();i++){
			System.out.println("methodUIBean: "+methodUIBeanList.get(i));
		}
		
		String countryMessage=messageGenerator.countryMessage(countryResult.toArray(new MyCountryPreferenceViewVO[countryResult.size()]));
		String ingredientMessage=messageGenerator.ingredientMessage(ingredientResult.toArray(new MyIngredientPreferenceViewVO[countryResult.size()]));
		String methodMessage=messageGenerator.methodMessage(methodResult.toArray(new MyMethodPreferenceViewVO[methodResult.size()]));
		request.setAttribute("countryList", countryUIBeanList);
		request.setAttribute("countryMessage", countryMessage);

		request.setAttribute("ingredientList", ingredientUIBeanList);
		request.setAttribute("ingredientMessage", ingredientMessage);
		
		request.setAttribute("methodList",methodUIBeanList);
		request.setAttribute("methodMessage", methodMessage);
		
		RequestDispatcher rd = request.getRequestDispatcher("graph.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
