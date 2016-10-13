package ViewVO;

public class FollowingViewVO {
	private String followUserCode;
	private String userCode;
	private String userName;
	private String userImage;
	private String followerCode;
	
	public FollowingViewVO(){}
	
	public FollowingViewVO(String followUserCode, String userCode, String userName, String userImage,
			String followerCode) {
		super();
		this.followUserCode = followUserCode;
		this.userCode = userCode;
		this.userName = userName;
		this.userImage = userImage;
		this.followerCode = followerCode;
	}

	public String getFollowUserCode() {
		return followUserCode;
	}
	public void setFollowUserCode(String followUserCode) {
		this.followUserCode = followUserCode;
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
	public String getFollowerCode() {
		return followerCode;
	}
	public void setFollowerCode(String followerCode) {
		this.followerCode = followerCode;
	}
	
	
}
