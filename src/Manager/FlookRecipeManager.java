package Manager;

import java.util.LinkedList;

import ViewDAO.SimpleFlookRecipeViewDAO;
import ViewVO.SimpleRecipeViewVO;

public class FlookRecipeManager {
	
	private SimpleFlookRecipeViewDAO simpleFlookRecipeViewDAO;
	
	public FlookRecipeManager()
	{
		this.simpleFlookRecipeViewDAO=SimpleFlookRecipeViewDAO.getInstance();
	}
	public LinkedList<SimpleRecipeViewVO> requestSimpleRecipeList()
	{
		return this.simpleFlookRecipeViewDAO.selectSimpleRecipe();
	}
	public LinkedList<SimpleRecipeViewVO> searchFlookRecipeList(String method,String situation,String nation,String ingredient,String kindOf) {
		return simpleFlookRecipeViewDAO.searchFlookRecipeList(method,situation,nation,ingredient,kindOf);
	}
}
