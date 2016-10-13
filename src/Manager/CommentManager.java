package Manager;

import java.util.LinkedList;

import DAO.CommentDAO;
import VO.CommentVO;
import ViewVO.CommentViewVO;

public class CommentManager {
	private CommentDAO commentDAO;
	public CommentManager(){
		commentDAO = CommentDAO.getInstance();
	}
	public CommentVO writeComment(String userCode,String commentString, String postCode) {
		return commentDAO.writeComment(userCode, commentString, postCode);
	}
	public int deleteComment(String commentCode) {
		return commentDAO.deleteComment(commentCode);
	}
	/*
	 * 나중에 이 코드 없애야됨..시간이없어서 이렇게 만듬.
	 */
	public LinkedList<CommentViewVO> searchComment(String recipeCode) {
		return commentDAO.searchComment(recipeCode);
	}
}
