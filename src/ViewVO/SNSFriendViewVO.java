package ViewVO;

import java.io.Serializable;

public class SNSFriendViewVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1599517050622686594L;
	private String snsFriendCode;
	private String userCode;
	private String friendUserCode;
	private String friendUserName;
	private String friendUserImage;
	private String friendUserBirthday;
	public SNSFriendViewVO() {
		// TODO Auto-generated constructor stub
	}
	public SNSFriendViewVO(String snsFriendCode, String userCode,
			String friendUserCode, String friendUserName,
			String friendUserImage, String friendUserBirthday) {
		this.snsFriendCode = snsFriendCode;
		this.userCode = userCode;
		this.friendUserCode = friendUserCode;
		this.friendUserName = friendUserName;
		this.friendUserImage = friendUserImage;
		this.friendUserBirthday = friendUserBirthday;
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
	public String getFriendUserCode() {
		return friendUserCode;
	}
	public void setFriendUserCode(String friendUserCode) {
		this.friendUserCode = friendUserCode;
	}
	public String getFriendUserName() {
		return friendUserName;
	}
	public void setFriendUserName(String friendUserName) {
		this.friendUserName = friendUserName;
	}
	public String getFriendUserImage() {
		return friendUserImage;
	}
	public void setFriendUserImage(String friendUserImage) {
		this.friendUserImage = friendUserImage;
	}
	public String getFriendUserBirthday() {
		return friendUserBirthday;
	}
	public void setFriendUserBirthday(String friendUserBirthday) {
		this.friendUserBirthday = friendUserBirthday;
	}
		
}
