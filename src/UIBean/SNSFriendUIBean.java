package UIBean;

public class SNSFriendUIBean {

	private String snsFriendCode;
	private String userCode;
	private String userName;
	private String userImage;
	private String code;
	
	public SNSFriendUIBean()
	{
		
	}

	public SNSFriendUIBean(String snsFriendCode, String userCode,
			String userName, String userImage, String code) {
		this.snsFriendCode = snsFriendCode;
		this.userCode = userCode;
		this.userName = userName;
		this.userImage = userImage;
		this.code = code;
	}

	public String getSnsFriendCode() {
		return snsFriendCode;
	}

	public void setSnsFriendCode(String snsFriendCode) {
		this.snsFriendCode = snsFriendCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
