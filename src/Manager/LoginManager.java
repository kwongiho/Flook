package Manager;

import DAO.UserDAO;
import VO.UserVO;

public class LoginManager {
	private UserDAO userDAO;
	public LoginManager() {
		userDAO = UserDAO.getInstance();
	}
	public UserVO login(String userEmail,String userPassword) {
		return userDAO.login(userEmail, userPassword);
	}
	public UserVO registerCheck(String userEmail) {
		return userDAO.registerCheck(userEmail);
	}
}
