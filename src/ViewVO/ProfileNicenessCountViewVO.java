package ViewVO;

public class ProfileNicenessCountViewVO {
	private String userCode;
	private int likeCount;
	public ProfileNicenessCountViewVO() { 
	}
	public ProfileNicenessCountViewVO(String userCode, int likeCount) { 
		this.userCode = userCode;
		this.likeCount = likeCount;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	

}
