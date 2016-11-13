package Manager;

import java.util.LinkedList;

import ViewDAO.SimpleUserRecipeViewDAO;
import ViewVO.SimpleUserRecipeViewVO;

public class RecommendKindManager {
	private SimpleUserRecipeViewDAO simpleUserRecipeViewDAO= SimpleUserRecipeViewDAO.getInstance();
	private static RecommendKindManager instance;
	public static RecommendKindManager getInstance(){
		if(instance == null)
			instance = new RecommendKindManager();
		return instance;
	}
	public LinkedList<SimpleUserRecipeViewVO> searchKind(String kindName){
		return simpleUserRecipeViewDAO.searchKind(kindName);
	}
	
}
