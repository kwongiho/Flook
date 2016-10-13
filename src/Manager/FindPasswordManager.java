package Manager;

import DAO.UserDAO;
import VO.UserVO;

public class FindPasswordManager {
	private UserDAO userDAO;
	public FindPasswordManager(){
		userDAO = UserDAO.getInstance();
	}
	public int changePassword(String email,String newPassword) {
		return userDAO.modifyPassword(email, newPassword);
	}
	public UserVO findEmail(String email) {
		return userDAO.findEmail(email);
	}
}
