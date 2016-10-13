package VO;

import java.io.Serializable;

public class SNSFriendVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8047949729031531522L;
	private String snsFriendCode;
	private String userCode;
	private String friendUserCode;
	public SNSFriendVO() {
		// TODO Auto-generated constructor stub
	}
	public SNSFriendVO(String snsFriendCode, String userCode,
			String friendUserCode) {
		this.snsFriendCode = snsFriendCode;
		this.userCode = userCode;
		this.friendUserCode = friendUserCode;
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
}
