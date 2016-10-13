package Manager;

import DAO.UserDAO;
import VO.UserVO;

public class JoinManager {
	private UserDAO userDAO;
	public JoinManager(){
		this.userDAO = UserDAO.getInstance();
	}
	public byte joinMember(UserVO userVO) {
		this.userDAO = UserDAO.getInstance();/*시퀀스따라서*/
		return (byte)userDAO.insertUser(userVO);
		
	}
	public byte joinMember(String userName,String userImage,String userEmail,String userPassword,String userGender,String userBirthday){
		/*위랑 틀린점이 위는 시퀀스가 반영됨.*/
		return (byte)userDAO.insertUser(userName, userImage, userEmail, userPassword, userGender, userBirthday);
		
	}
}