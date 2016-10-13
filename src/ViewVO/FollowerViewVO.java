package ViewVO;

import java.io.Serializable;

public class FollowerViewVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8474803969773893630L;
	private String followCode;
	private String userCode;
	private String followUserCode;
	private String followUserName;
	private String followUserImage;
	public FollowerViewVO() {
		// TODO Auto-generated constructor stub
	}
	public FollowerViewVO(String followCode, String userCode,
			String followUserCode, String followUserName, String followUserImage) {
		this.followCode = followCode;
		this.userCode = userCode;
		this.followUserCode = followUserCode;
		this.followUserName = followUserName;
		this.followUserImage = followUserImage;
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
	public String getFollowUserName() {
		return followUserName;
	}
	public void setFollowUserName(String followUserName) {
		this.followUserName = followUserName;
	}
	public String getFollowUserImage() {
		return followUserImage;
	}
	public void setFollowUserImage(String followUserImage) {
		this.followUserImage = followUserImage;
	}

}
