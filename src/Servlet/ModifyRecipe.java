package Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Manager.RecipeManager;
import UIBean.CookingUIBean;
import UIBean.IngredientUIBean;
import UIBean.UserRecipeUIBean;
import VO.CookingVO;
import VO.IngredientVO;
import VO.PostVO;
import VO.RecipeVO;
import ViewVO.IngredientViewVO;
import ViewVO.RecipeCategoryViewVO;
import ViewVO.UserRecipeViewVO;

/**
 * Servlet implementation class ModifyRecipe
 */
@MultipartConfig
public class ModifyRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		response.containsHeader("text/html; charset=UTF-8");
		String recipeCode=request.getParameter("recipeCode");
		System.out.println("recipeCode : "+recipeCode); 
		HttpSession session=request.getSession();
		String userCode=(String)session.getAttribute("userCode");
		if(userCode==null)
		{ 
			System.out.println("check");
			response.sendRedirect("login");
		}
		else if(recipeCode==null) 
		{ 
			System.out.println("check2");
			response.sendRedirect("main");
		}
		else{
			
			RecipeManager manager=new RecipeManager(); 
			UserRecipeViewVO userRecipeViewVO=manager.searchUserRecipeInfo(recipeCode);
			
			if(userRecipeViewVO==null||! userCode.equals(userRecipeViewVO.getUserCode()))
			{ 
				response.sendRedirect("main"); 
			}
			else{
				LinkedList<IngredientViewVO> mainIngreList=manager.searchMainUserRecipeIngredientList(recipeCode);
			
				LinkedList<IngredientViewVO> subIngreList=manager.searchSubUserRecipeIngredientList(recipeCode);
				LinkedList<CookingVO> cookList=manager.searchUserRecipeCookingList(recipeCode);
				LinkedList<CookingUIBean> cookingList=new LinkedList<CookingUIBean>();
				LinkedList<IngredientUIBean> mainIngredientList=new LinkedList<IngredientUIBean>();
				LinkedList<IngredientUIBean> subIngredientList=new LinkedList<IngredientUIBean>();
				if(cookList!=null)
				{
					for(CookingVO cook:cookList)
					{
						CookingUIBean bean=new CookingUIBean(cook.getCookingCode(), cook.getCookingImage(), cook.getCookingCaption());
						cookingList.add(bean);
						System.out.println(bean);
					}
				}
				else
				{
					CookingUIBean bean=new CookingUIBean(null, "img/write_img/pic_none3.gif", null);
					cookingList.add(bean);
					
				}
				for(IngredientViewVO mainIngredient:mainIngreList)
				{
					IngredientUIBean bean=new IngredientUIBean(mainIngredient.getIngredientName(), mainIngredient.getIngredientAmount(), mainIngredient.getIngredientUnitName());
					mainIngredientList.add(bean);
					System.out.println(bean);
				}

				for(IngredientViewVO subIngredient:subIngreList)
				{
					IngredientUIBean bean=new IngredientUIBean(subIngredient.getIngredientName(), subIngredient.getIngredientAmount(), subIngredient.getIngredientUnitName());
					subIngredientList.add(bean);
					System.out.println(bean);
				}
				RecipeCategoryViewVO recipeCategoryViewVO=manager.searchRecipeCategory(recipeCode);
				
				System.out.println(recipeCategoryViewVO);
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
				request.setAttribute("userUIBean", uiBean); 
				request.setAttribute("recipeCode",recipeCode);
				System.out.println(uiBean);
			RequestDispatcher rd=request.getRequestDispatcher("modifyRecipe.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String userCode=(String)session.getAttribute("userCode"); 
		System.out.println("checkcheck");
		
		String[] photos=request.getParameterValues("photo");
		
		for(String photo : photos)
		{
			System.out.println("photo check : '"+photo+"'"); 
		}
		System.out.println("photo count : "+photos.length);
		
		String recipeCode=request.getParameter("recipeCode2");
		
		String completeImage=null;
		LinkedList<CookingVO> cookingList=new LinkedList<CookingVO>();
		String[] cookingCaption = request.getParameterValues("cookingCaption");
		System.out.println("userCode : "+userCode);
		PrintWriter writer=response.getWriter(); 
		
		RecipeManager manager=new RecipeManager();
		String recipeName=request.getParameter("recipeName");
		String recipeDescription=request.getParameter("recipeDescription");
		String[] category=request.getParameterValues("category");
		int personNumber=0;
		try{ 
			personNumber=Integer.parseInt(request.getParameter("personNumber"));
		}
		catch(NumberFormatException ne)
		{
			
		}
		String cookingTime=request.getParameter("cookingTime");
		String cookingLevel=request.getParameter("cookingLevel");
		String postHashtag=request.getParameter("hashTags");
		String[] mainIngredient=request.getParameterValues("mainIngredient");
		String[] mainIngredientAmount=request.getParameterValues("mainIngredientAmount");
		String[] mainIngredientUnit=request.getParameterValues("mainIngredientUnit");
		String[] subIngredient=request.getParameterValues("subIngredient");
		String[] subIngredientAmount=request.getParameterValues("subIngredientAmount");
		String[] subIngredientUnit=request.getParameterValues("subIngredientUnit");
		 
		System.out.println("cookingTime : "+cookingTime);
		
		System.out.println("inCheck : "+mainIngredient);
		System.out.println(personNumber+cookingTime+cookingLevel);
		System.out.println(postHashtag);
		
		
		GregorianCalendar gc=new GregorianCalendar(); 
		SimpleDateFormat sd=new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String postDate=sd.format(gc.getTime());
		
		/*for(int i=0;i<cookingCaption.length;i++)
		{
			CookingVO cookingVO=new CookingVO(null, null, i+1, cookingImage, cookingCaption[i]);
		}*/
		LinkedList<IngredientVO> ingredientList = new LinkedList<IngredientVO>();
		System.out.println("inLCheck : "+ingredientList);
		for(int i=0;i<mainIngredient.length;i++)
		{
			int amount=0;
			try
			{
				amount=Integer.parseInt(mainIngredientAmount[i]);
			}
			catch(NumberFormatException ne)
			{
				
			}
			IngredientVO ingredientVO=new IngredientVO(null, null, mainIngredient[i], amount,  "M",mainIngredientUnit[i]);
			ingredientList.add(ingredientVO);		
		}
		for(int i=0;i<subIngredient.length;i++)
		{
			int amount=0;
			try
			{
				amount=Integer.parseInt(subIngredientAmount[i]);
			}
			catch(NumberFormatException ne)
			{
				
			}
			IngredientVO ingredientVO=new IngredientVO(null, null, subIngredient[i],amount ,  "S",subIngredientUnit[i]);
			ingredientList.add(ingredientVO);
		}
		 	
		PostVO postVO=new PostVO(null, null, userCode, 0, 0, postHashtag, postDate);
		 
		
		Collection<Part> parts = request.getParts();
		System.out.println("parts : "+parts);
		int i=0;
		for (Part part : parts) {
			if (part.getContentType() != null) {
				System.out.println("part : "+i);
				
				String fileName = getFilename(part);
				System.out.println("fileName : "+fileName);
				String dbDir=null;
				System.out.println('('+fileName+')');
				if(fileName.equals(""))
				{
					dbDir=photos[i];
					System.out.println("servlet : "+dbDir);
					if(dbDir.equals(""))
					{
						dbDir="img/write_img/pic_none3.gif";
					}
				}
				 
				if (fileName != null && !fileName.isEmpty()) {
					/*part.write(getServletContext().getRealPath("/WEB-INF")
							+ "/"+userCode+"/" + fileName);*/
/*					String dir=getServletContext().getRealPath("/WEB-INF")
							+ "/userImage/"+ fileName;*/
					String dir=getServletContext().getRealPath("")+File.separator+ "userImage"+File.separator+ fileName;
					System.out.println("데이터 저장 경로 : "+dir);
					part.write(dir);
					writer.print("<br/>"+dir);
					writer.print("<br>업로드한 파일 이름: " + fileName);
					writer.print("<br/>크기: " + part.getSize());
					dbDir=File.separator+"Flook"+File.separator+"userImage"+File.separator+ fileName; 
					
				}
				if(i==0)
				{
					completeImage=dbDir;
				}
				else
				{
					CookingVO cookingVO=new CookingVO(null, recipeCode, i, dbDir, cookingCaption[i-1]);
					System.out.println(cookingVO);
					cookingList.add(cookingVO); 
				}
				i++;

			} else {
				String partName = part.getName();
				String fieldValue = new String(request.getParameter(partName)
						.getBytes("iso-8859-1"), "utf-8"); 
			}
		}
		writer.println("recipeCode : "+recipeCode);
		System.out.println("com : "+completeImage+"\n");
		RecipeVO recipeVO=new RecipeVO(recipeCode, completeImage, recipeName, recipeDescription, personNumber, cookingTime, cookingLevel);
		System.out.println("mC");
		//writer.print("<br>"+recipeVO);
		manager.modifyRecipe(recipeCode, recipeVO, postVO, cookingList, ingredientList, category);
		//manager.writeRecipe(recipeVO, postVO, cookingList, ingredientList,category);
		response.sendRedirect("myRecipe");
		
	}
	private String getFilename(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition"); 
		String[] elements = contentDispositionHeader.split(";"); 
		for (String element : elements) {
			System.out.println("element : "+element);
			if (element.trim().startsWith("filename")) { 
				return element.substring(element.indexOf('=') + 1).trim()
						.replace("\"", "");

			}
		}
		return null;
	}

}
