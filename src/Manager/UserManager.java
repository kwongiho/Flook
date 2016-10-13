package Manager;

import DAO.UserDAO;
import VO.UserVO;
import VO.UserWithFollowOrNotVO;

public class UserManager {
	private UserDAO userDAO;
	public UserManager()
	{
		userDAO=UserDAO.getInstance();
	}
	public UserVO seachEmail(String email)
	{
		return userDAO.findEmail(email);
	}
	public UserWithFollowOrNotVO searchEmailAndFollowOrNot(String email, String userCode)
	{
		return userDAO.findUserWithFollowOrNotByEmail(email, userCode);
	}
	
	public static void main(String[]args)
	{
		UserManager man = new UserManager();
		
		UserWithFollowOrNotVO vo = man.searchEmailAndFollowOrNot("kaka9887@naver.com", null);
		System.out.println(vo.getFollowCode());
	}
}
