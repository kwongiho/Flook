package Manager;

import java.util.LinkedList;

import DAO.NicenessDAO;
import ViewDAO.SimpleUserRecipeViewDAO;
import ViewVO.SimpleUserRecipeViewVO;

public class RecommendTodayManager {
	private SimpleUserRecipeViewDAO simpleUserRecipeViewDAO;
	private NicenessDAO nicenessDAO;
	
	public RecommendTodayManager() {
		
		simpleUserRecipeViewDAO = SimpleUserRecipeViewDAO.getInstance();
		nicenessDAO=NicenessDAO.getInstance();
		// TODO Auto-generated constructor stub
	}
	public LinkedList<String> searchUserRecipeList(String today) {
		return nicenessDAO.searchTodayPostCode(today);
	}
	public SimpleUserRecipeViewVO searchPostCodeRecipeList(String postCode) {
		return simpleUserRecipeViewDAO.searchPostCodeRecipeList(postCode);
	} 

}
