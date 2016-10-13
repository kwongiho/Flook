package Manager;

import java.util.LinkedList;

import ViewDAO.SimpleUserRecipeViewDAO;
import ViewVO.SimpleUserRecipeViewVO;

public class MyRecipeManager {
	
	private SimpleUserRecipeViewDAO simpleUserRecipeViewDAO;
	
	public MyRecipeManager()
	{
		this.simpleUserRecipeViewDAO=SimpleUserRecipeViewDAO.getInstance();
	}
	public LinkedList<SimpleUserRecipeViewVO> searchMyRecipeList(String userCode) {
		return simpleUserRecipeViewDAO.searchRecipeListByUserCode(userCode);
	}
}
