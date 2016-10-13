package Manager;

import java.util.LinkedList;

import ViewDAO.SimpleUserRecipeViewDAO;
import ViewVO.SimpleUserRecipeViewVO;

public class RecommendSituationManager {
	//원래는 유저가 아니라 flook레시피로했었어야해 했다.
	
	private SimpleUserRecipeViewDAO simpleUserRecipeViewDAO= SimpleUserRecipeViewDAO.getInstance();
	
	public RecommendSituationManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RecommendSituationManager(
			SimpleUserRecipeViewDAO simpleUserRecipeViewDAO) {
		this.simpleUserRecipeViewDAO = simpleUserRecipeViewDAO;
	}


	public LinkedList<SimpleUserRecipeViewVO> searchSituation(String situationName){
		return simpleUserRecipeViewDAO.searchSituation(situationName);
	}
	
	

}
