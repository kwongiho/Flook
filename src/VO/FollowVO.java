package VO;

import java.io.Serializable;

public class FollowVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3147903006491063258L;
	private String followCode;
	private String userCode;
	private String followUserCode;
	public FollowVO() {
		// TODO Auto-generated constructor stub
	}
	public FollowVO(String followCode, String userCode, String followUserCode) {
		this.followCode = followCode;
		this.userCode = userCode;
		this.followUserCode = followUserCode;
	}
	public String getFollowCode() {
		return followCode;
	}
	public void setFollowCode(String followCode) {
		this.followCode = followCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getFollowUserCode() {
		return followUserCode;
	}
	public void setFollowUserCode(String followUserCode) {
		this.followUserCode = followUserCode;
	}
}
