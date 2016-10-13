package VO;

import java.io.Serializable;

public class UserVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3794442731781442661L;
	private String userCode;
	private String userName;
	private String userImage;
	private String userEmail;
	private String userPassword;
	private String userGender;
	private String birthday;
	private int userSns;
	public UserVO() {
		super();
	}
	public UserVO(String userCode, String userName, String userImage,
			String userEmail, String userPassword, String userGender,
			String birthday, int userSns) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.userImage = userImage;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.birthday = birthday;
		this.userSns = userSns;
	}
	public String getUserCode() {
		return userCode;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public String getUserGender() {
		return userGender;
	}
	public String getBirthday() {
		return birthday;
	}
	public int getUserSns() {
		return userSns;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setUserSns(int userSns) {
		this.userSns = userSns;
	}
	@Override
	public String toString() {
		return "UserVO [userCode=" + userCode + ", userName=" + userName
				+ ", userImage=" + userImage + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userGender="
				+ userGender + ", birthday=" + birthday + ", userSns="
				+ userSns + "]";
	}
	
	
	

}
