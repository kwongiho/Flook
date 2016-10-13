package Manager;

import java.util.LinkedList;

import DAO.UserDAO;
import VO.UserVO;
import ViewDAO.FlookRecipeViewDAO;
import ViewDAO.SimpleRecipeViewDAO;
import ViewDAO.SimpleUserRecipeViewDAO;
import ViewDAO.UserRecipeViewDAO;
import ViewVO.FlookRecipeViewVO;
import ViewVO.SimpleRecipeViewVO;
import ViewVO.SimpleUserRecipeViewVO;
import ViewVO.UserRecipeViewVO;

public class SearchManager {
	private SimpleRecipeViewDAO simpleRecipeViewDAO;
	private SimpleUserRecipeViewDAO simpleUserRecipeViewDAO;
	private UserRecipeViewDAO userRecipeViewDAO;
	private FlookRecipeViewDAO flookRecipeViewDAO;
	private UserDAO userDAO;
	public SearchManager() {
		simpleRecipeViewDAO = SimpleRecipeViewDAO.getInstance();
		simpleUserRecipeViewDAO = SimpleUserRecipeViewDAO.getInstance();
		userRecipeViewDAO = UserRecipeViewDAO.getInstance();
		flookRecipeViewDAO = FlookRecipeViewDAO.getInstance();
		userDAO = UserDAO.getInstance();
	}
	public LinkedList<SimpleRecipeViewVO> searchFlookRecipeListByRecipeName(String keyword) {
		return simpleRecipeViewDAO.searchFlookRecipeListByRecipeName(keyword);
	}
	public LinkedList<FlookRecipeViewVO> searchFlookRecipeListByHashTag(String keyword) {
		return flookRecipeViewDAO.searchFlookRecipeListByHashTag(keyword);
	}
	public LinkedList<SimpleUserRecipeViewVO> searchUserRecipeListByRecipeName(String keyword) {
		return simpleUserRecipeViewDAO.searchUserRecipeListByRecipeName(keyword);
	}
	public LinkedList<UserRecipeViewVO> searchUserRecipeListByHashTag(String keyword) {
		return userRecipeViewDAO.searchUserRecipeListByHashTag(keyword);/*검색하는 테이블 UserRecipeView로 변경되야됨. 멤변에 UserRecipeViewDAO 추가.*/
	}
	public LinkedList<UserVO> searchUserListByUserName(String keyword) {
		return userDAO.searchUserListByUserName(keyword);
	}
	public static void main(String []args) {
		System.out.println(new SearchManager().searchFlookRecipeListByRecipeName("김치").get(0));
	}
}

