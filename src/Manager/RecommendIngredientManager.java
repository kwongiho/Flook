package Manager;

import java.util.LinkedList;

import ViewDAO.SimpleUserRecipeViewDAO;
import ViewVO.SimpleUserRecipeViewVO;

public class RecommendIngredientManager {
	private SimpleUserRecipeViewDAO simpleUserRecipeViewDAO= SimpleUserRecipeViewDAO.getInstance();
	private static RecommendIngredientManager instance;
	public static RecommendIngredientManager getInstance(){
		if(instance == null)
			instance = new RecommendIngredientManager();
		return instance;
	}
	public LinkedList<SimpleUserRecipeViewVO> searchIngredient(String ingredientName) {
		return simpleUserRecipeViewDAO.searchIngredient(ingredientName);
	}
}
