package Manager;

import java.util.LinkedList;

import DAO.CookingDAO;
import DAO.IngredientDAO;
import DAO.PostDAO;
import DAO.RecipeCategoryDAO;
import DAO.RecipeDAO;
import VO.CookingVO;
import VO.IngredientVO;
import VO.PostVO;
import VO.RecipeVO;
import ViewDAO.IngredientViewDAO;
import ViewDAO.RecipeCategoryViewDAO;
import ViewDAO.UserRecipeViewDAO;
import ViewVO.IngredientViewVO;
import ViewVO.RecipeCategoryViewVO;
import ViewVO.UserRecipeViewVO;

public class RecipeManager {
	private RecipeDAO recipeDAO;
	private PostDAO postDAO;
	private CookingDAO cookingDAO;
	private IngredientDAO ingredientDAO;
	private RecipeCategoryDAO recipeCategoryDAO;

	private UserRecipeViewDAO userRecipeViewDAO;
	private RecipeCategoryViewDAO recipeCategoryViewDAO;
	private IngredientViewDAO ingredientViewDAO;
	public RecipeManager()
	{
		this.recipeDAO=RecipeDAO.getInstance();
		this.postDAO=PostDAO.getInstance();
		this.cookingDAO=CookingDAO.getInstance();
		this.ingredientDAO=IngredientDAO.getInstance();
		
		this.recipeCategoryDAO=RecipeCategoryDAO.getInstance();

		this.userRecipeViewDAO=UserRecipeViewDAO.getInstance();
		this.recipeCategoryViewDAO=RecipeCategoryViewDAO.getInstance();
		this.ingredientViewDAO=IngredientViewDAO.getInstance();
		
	}
	public int writeRecipe(RecipeVO recipeVO,PostVO postVO,LinkedList<CookingVO> cookingList,LinkedList<IngredientVO> ingredientList,String[] recipeCategory)
	{
		String recipeCode=recipeDAO.insertRecipe(recipeVO);
		System.out.println("recipeCode Check : "+recipeCode+"\n");
		if(recipeCode==null)
		{
			return 0;
		}
		postVO.setRecipeCode(recipeCode);
		String postCode=postDAO.insertPost(postVO);
		System.out.println("postCode check : "+postCode+"\n");
		if(postCode==null)
		{
			return 0;
		}
		for(IngredientVO ingredientVO:ingredientList)
		{
			ingredientVO.setRecipeCode(recipeCode);
			System.out.println("ingredient Check : "+ingredientDAO.insertIngredient(ingredientVO));
		}
		System.out.println("listL : "+cookingList.size());
		for(CookingVO cookingVO:cookingList)
		{
			cookingVO.setRecipeCode(recipeCode);
			cookingDAO.insertCooking(cookingVO);
		}
		System.out.println("check");
		System.out.println("RCcheck : "+recipeCategoryDAO.insertCategory(recipeCode, recipeCategory));
		System.out.println("check2");
		return 1;
	}
	public byte deleteRecipe(String recipeCode)  // ������ ���� ����
	{
		byte res1=recipeCategoryDAO.deleteCategory(recipeCode);
		byte res3=cookingDAO.deleteCookingRecipe(recipeCode);
		byte res2=ingredientDAO.deleteIngredientRecipe(recipeCode);
		byte res4=postDAO.deletePost(recipeCode);
		byte res5=recipeDAO.deleteRecipe(recipeCode);
		System.out.println("recipe_category_table="+res1);
		System.out.println("cooking_tb="+res2);
		System.out.println("ingredient_tb="+res3);
		System.out.println("post_tb="+res4);
		System.out.println("recipe_tb="+res5);
		
		if(res1+res2+res3+res4+res5==5)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public int deleteRecipe(String targetRecipeCode,String postCode)
	{
		postDAO.deletePost(postCode);
		System.out.println("ingredient del : "+ingredientDAO.deleteIngredientRecipe(targetRecipeCode));
		System.out.println("cooking del : "+cookingDAO.deleteCookingRecipe(targetRecipeCode));
		System.out.println("recipe del : "+recipeDAO.deleteRecipe(targetRecipeCode));
		return 1;
	}
	public UserRecipeViewVO searchUserRecipeInfo(String recipeCode)
	{
		return userRecipeViewDAO.searchUserRecipe(recipeCode);
	}
	public LinkedList<CookingVO> searchUserRecipeCookingList(String recipeCode)
	{ 
		return cookingDAO.searchCookingList(recipeCode);
	}
	public LinkedList<IngredientViewVO> searchMainUserRecipeIngredientList(String recipeCode)
	{
		return ingredientViewDAO.searchIngredientList(recipeCode,"M");
	}
	public LinkedList<IngredientViewVO> searchSubUserRecipeIngredientList(String recipeCode)
	{
		return ingredientViewDAO.searchIngredientList(recipeCode,"M");
	}
	public RecipeCategoryViewVO searchRecipeCategory(String recipeCode)
	{
		return recipeCategoryViewDAO.searchCategoryList(recipeCode);
	}
	public String searchPostCodeByRecipeCode(String recipeCode) {/*�Ǳ�ȣ�߰�*/
		return postDAO.searchPostCodeByRecipeCode(recipeCode);
	}
	public int modifyRecipe(String recipeCode,RecipeVO recipeVO,PostVO postVO,LinkedList<CookingVO> cookingList,LinkedList<IngredientVO> ingredientList,String[] recipeCategory)
	{
		if(recipeDAO.modifyRecipe(recipeCode,recipeVO)==null)
		{
			System.out.println(recipeVO);
			System.out.println("modifyRecipeFail");
			return 0;
		}
		if(postDAO.modifyPost(recipeCode, postVO)==null)
		{
			System.out.println("modifyPostFail");
			return 0;
		}
		ingredientDAO.deleteIngredientRecipe(recipeCode);
		for(IngredientVO ingredientVO:ingredientList)
		{
			ingredientVO.setRecipeCode(recipeCode);
			System.out.println("modify ingredient Check : "+ingredientDAO.insertIngredient(ingredientVO));
		}
		recipeCategoryDAO.modifyCategory(recipeCode, recipeCategory);
		cookingDAO.deleteCookingRecipe(recipeCode);

		for(CookingVO cookingVO:cookingList)
		{ 
			System.out.println("ck"+cookingVO);
			cookingDAO.insertCooking(cookingVO);
		}
		return 1;
	}	
	public int addPostHits(String recipeCode)
	{
		return postDAO.addPostHits(recipeCode);
	}
	
}
