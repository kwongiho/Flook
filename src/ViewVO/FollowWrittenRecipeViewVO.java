package ViewVO;

public class FollowWrittenRecipeViewVO {
	private String followCode;
	private String userCode;
	private String followUserCode;
	private String followPostCode;
	private String followRecipeCode;
	private int likeCount;
	private int postHits;
	private String followPostDate;
	private String followCompleteImage;
	private String followRecipeName;
	private String followRecipeDescription;
	private String followUserName;
	private String followUserImage;
	
	public FollowWrittenRecipeViewVO() {
		// TODO Auto-generated constructor stub
	}
	
	public FollowWrittenRecipeViewVO(String followCode, String userCode, String followUserCode, String followPostCode,
			String followRecipeCode, int likeCount, int postHits, String followPostDate, String followCompleteImage,
			String followRecipeName, String followRecipeDescription, String followUserName, String followUserImage) {
		super();
		this.followCode = followCode;
		this.userCode = userCode;
		this.followUserCode = followUserCode;
		this.followPostCode = followPostCode;
		this.followRecipeCode = followRecipeCode;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.followPostDate = followPostDate;
		this.followCompleteImage = followCompleteImage;
		this.followRecipeName = followRecipeName;
		this.followRecipeDescription = followRecipeDescription;
		this.followUserName = followUserName;
		this.followUserImage = followUserImage;
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
	public String getFollowPostCode() {
		return followPostCode;
	}
	public void setFollowPostCode(String foolowPostCode) {
		this.followPostCode = foolowPostCode;
	}
	public String getFollowRecipeCode() {
		return followRecipeCode;
	}
	public void setFollowRecipeCode(String followRecipeCode) {
		this.followRecipeCode = followRecipeCode;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getPostHits() {
		return postHits;
	}
	public void setPostHits(int postHits) {
		this.postHits = postHits;
	}
	public String getFollowPostDate() {
		return followPostDate;
	}
	public void setFollowPostDate(String followPostDate) {
		this.followPostDate = followPostDate;
	}
	public String getFollowCompleteImage() {
		return followCompleteImage;
	}
	public void setFollowCompleteImage(String followCompleteImage) {
		this.followCompleteImage = followCompleteImage;
	}
	public String getFollowRecipeName() {
		return followRecipeName;
	}
	public void setFollowRecipeName(String followRecipeName) {
		this.followRecipeName = followRecipeName;
	}
	public String getFollowRecipeDescription() {
		return followRecipeDescription;
	}
	public void setFollowRecipeDescription(String followRecipeDescription) {
		this.followRecipeDescription = followRecipeDescription;
	}

	
	
}
