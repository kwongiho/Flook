package Manager;

import java.util.ArrayList;

import ViewDAO.SimpleVideoRecipeViewDAO;
import ViewVO.SimpleVideoRecipeViewVO;

public class VideoRecipeManager {
	private SimpleVideoRecipeViewDAO simpleVideoRecipeViewDAO;
	
	public VideoRecipeManager()
	{
		simpleVideoRecipeViewDAO = SimpleVideoRecipeViewDAO.getInstance();
	}
	
	public ArrayList<SimpleVideoRecipeViewVO> searchVideoRecipeList(int index)
	{
		ArrayList<SimpleVideoRecipeViewVO> array = simpleVideoRecipeViewDAO.searchVideoRecipeList(index);
		return array;
	}
}
