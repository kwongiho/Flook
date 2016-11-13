package Manager;

import java.util.LinkedList;

import ViewDAO.SimpleUserRecipeViewDAO;
import ViewVO.SimpleUserRecipeViewVO;

public class RecommendMethodManager {
	private SimpleUserRecipeViewDAO simpleUserRecipeViewDAO= SimpleUserRecipeViewDAO.getInstance();
	private static RecommendMethodManager instance;
	public RecommendMethodManager getInstance(){
		if(instance == null)
			instance = new RecommendMethodManager();
		return instance;
	}
	
	public LinkedList<SimpleUserRecipeViewVO> searchMethod(String methodName) {
		return simpleUserRecipeViewDAO.searchMethod(methodName);
	}
}
