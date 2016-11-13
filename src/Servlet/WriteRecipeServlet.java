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
import VO.CookingVO;
import VO.IngredientVO;
import VO.PostVO;
import VO.RecipeVO;

/**
 * Servlet implementation class WriteRecipeServlet
 */
@MultipartConfig
public class WriteRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userCode = (String) session.getAttribute("userCode");
		if (userCode == null) {
			response.sendRedirect("login");
		}

		String completeImage = null;
		LinkedList<CookingVO> cookingList = new LinkedList<CookingVO>();
		String[] cookingCaption = request.getParameterValues("cookingCaption");
		/* userCode="USER_001"; */
		System.out.println("userCode : " + userCode);
		PrintWriter writer = response.getWriter();

		RecipeManager manager = new RecipeManager();
		String recipeName = request.getParameter("recipeName");
		String recipeDescription = request.getParameter("recipeDescription");
		String[] category = request.getParameterValues("category");
		int personNumber = 0;
		try {
			personNumber = Integer.parseInt(request
					.getParameter("personNumber"));
		} catch (NumberFormatException ne) {

		}
		String cookingTime = request.getParameter("cookingTime");
		String cookingLevel = request.getParameter("cookingLevel");
		String postHashtag = request.getParameter("hashTags");
		String[] mainIngredient = request.getParameterValues("mainIngredient");
		String[] mainIngredientAmount = request
				.getParameterValues("mainIngredientAmount");
		String[] mainIngredientUnit = request
				.getParameterValues("mainIngredientUnit");
		String[] subIngredient = request.getParameterValues("subIngredient");
		String[] subIngredientAmount = request
				.getParameterValues("subIngredientAmount");
		String[] subIngredientUnit = request
				.getParameterValues("subIngredientUnit");

		String[] cookingDescription = request
				.getParameterValues("cookingDescription");
		System.out.println(mainIngredient[0]);
		System.out.println(mainIngredientAmount[0]);
		System.out.println(mainIngredientUnit[0]);
		System.out.println(subIngredient[0]);
		System.out.println(subIngredientAmount[0]);
		System.out.println(subIngredientUnit[0]);

		System.out.println(personNumber + cookingTime + cookingLevel);
		System.out.println(postHashtag);

		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String postDate = sd.format(gc.getTime());

		/*
		 * for(int i=0;i<cookingCaption.length;i++) { CookingVO cookingVO=new
		 * CookingVO(null, null, i+1, cookingImage, cookingCaption[i]); }
		 */
		LinkedList<IngredientVO> ingredientList = new LinkedList<IngredientVO>();
		for (int i = 0; i < mainIngredient.length; i++) {
			int amount = 0;
			try {
				amount = Integer.parseInt(mainIngredientAmount[i]);
			} catch (NumberFormatException ne) {

			}
			IngredientVO ingredientVO = new IngredientVO(null, null,
					mainIngredient[i], amount, "M", mainIngredientUnit[i]);
			ingredientList.add(ingredientVO);
		}
		for (int i = 0; i < subIngredient.length; i++) {
			int amount = 0;
			try {
				amount = Integer.parseInt(subIngredientAmount[i]);
			} catch (NumberFormatException ne) {

			}
			IngredientVO ingredientVO = new IngredientVO(null, null,
					subIngredient[i], amount, "S", subIngredientUnit[i]);
			ingredientList.add(ingredientVO);
		}

		PostVO postVO = new PostVO(null, null, userCode, 0, 0, postHashtag,
				postDate);

		// RecipeVO recipeVO= new RecipeVO(null, completeImage, recipeName,
		// recipeDescription, personNumber, cookingTime, cookingLevel)
		/*
		 * ServletContext context = this.getServletContext(); String realPath =
		 * context.getRealPath("/"); String dirName = realPath + File.separator
		 * + "uploadFiles"; File dir = new File(dirName); if (!dir.exists()) {
		 * dir.mkdir(); } System.out.println("dirName: " + dirName);
		 */

		Collection<Part> parts = request.getParts();
		System.out.println("parts : " + parts);
		int i = 0;
		
		for (Part part : parts) {
			
			if (part.getContentType() != null) {
				String fileName = getFilename(part);
				System.out.println("fileName : " + fileName);
				if (fileName != null && !fileName.isEmpty()) {
					/*
					 * part.write(getServletContext().getRealPath("/WEB-INF") +
					 * "/"+userCode+"/" + fileName);
					 */
					String dir = getServletContext().getRealPath("")
							+ File.separator + "userImage" + File.separator
							+ fileName;
					part.write(dir);
					writer.print("<br/>" + dir);
					writer.print("<br>업로드한 파일 이름: " + fileName);
					writer.print("<br/>크기: " + part.getSize());
					if (i == 0) {
						completeImage = File.separator + "Flook"
								+ File.separator + "userImage" + File.separator
								+ fileName;
						i++;
					} else {
						CookingVO cookingVO = new CookingVO(null, null, i,
								File.separator + "Flook" + File.separator
										+ "userImage" + File.separator
										+ fileName, cookingCaption[i - 1]);
						System.out.println(cookingVO);
						cookingList.add(cookingVO);
						i++;
					}
				}

			} else {
				String partName = part.getName();
				String fieldValue = new String(request.getParameter(partName)
						.getBytes("iso-8859-1"), "utf-8");
			}
		}
		System.out.println("com : " + completeImage + "\n");
		RecipeVO recipeVO = new RecipeVO(null, completeImage, recipeName,
				recipeDescription, personNumber, cookingTime, cookingLevel);
		manager.writeRecipe(recipeVO, postVO, cookingList, ingredientList,
				category);

		response.sendRedirect("myRecipe.jsp");
	}
	private String getFilename(Part part) 
	{
		String contentDispositionHeader = part.getHeader("content-disposition");
		String name = null;
		String[] elements = contentDispositionHeader.split(";");
		for (String element : elements) {
			System.out.println("element : " + element);
			if (element.trim().startsWith("name")) {
				name = element.substring(element.indexOf('=') + 1).trim()
						.replace("\"", "");
			} else if (element.trim().startsWith("filename")) {
				/*
				 * return name+"/"+element.substring(element.indexOf('=') +
				 * 1).trim() .replace("\"", "");
				 */
				return element.substring(element.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
