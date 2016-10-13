package VO;

public class UserWithFollowOrNotVO {
	private String uUserCode;
	private String userName;
	private String userImage;
	private String userEmail;
	private String userPassword;
	private String userGender;
	private String userBirthday;
	private int userSNS;
	private String followCode;
	private String fUserCode;
	private String followUserCode;
	
	public UserWithFollowOrNotVO(){}
	
	
	public UserWithFollowOrNotVO(String uUserCode, String userName, String userImage, String userEmail,
			String userPassword, String userGender, String userBirthday, int userSNS, String followCode,
			String fUserCode, String followUserCode) {
		super();
		this.uUserCode = uUserCode;
		this.userName = userName;
		this.userImage = userImage;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userBirthday = userBirthday;
		this.userSNS = userSNS;
		this.followCode = followCode;
		this.fUserCode = fUserCode;
		this.followUserCode = followUserCode;
	}


	@Override
	public String toString() {
		return "UserWithFollowOrNotVO [uUserCode=" + uUserCode + ", userName=" + userName + ", userImage=" + userImage
				+ ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userGender=" + userGender
				+ ", userBirthday=" + userBirthday + ", userSNS=" + userSNS + ", followCode=" + followCode
				+ ", fUserCode=" + fUserCode + ", followUserCode=" + followUserCode + "]";
	}


	public String getuUserCode() {
		return uUserCode;
	}
	public void setuUserCode(String uUserCode) {
		this.uUserCode = uUserCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public int getUserSNS() {
		return userSNS;
	}
	public void setUserSNS(int userSNS) {
		this.userSNS = userSNS;
	}
	public String getFollowCode() {
		return followCode;
	}
	public void setFollowCode(String followCode) {
		this.followCode = followCode;
	}
	public String getfUserCode() {
		return fUserCode;
	}
	public void setfUserCode(String fUserCode) {
		this.fUserCode = fUserCode;
	}
	public String getFollowUserCode() {
		return followUserCode;
	}
	public void setFollowUserCode(String followUserCode) {
		this.followUserCode = followUserCode;
	}
}
