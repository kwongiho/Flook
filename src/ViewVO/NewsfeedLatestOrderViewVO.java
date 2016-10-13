package ViewVO;

public class NewsfeedLatestOrderViewVO {
	private String postCode;
	private String recipeCode;
	private int likeCount;
	private String userCode;
	private int postHits;
	private String postDate;
	private String completeImage;
	private String recipeName;
	private String userName;
	private String userImage;
	private String recipeDescription;
	private String followUserImage;
	public NewsfeedLatestOrderViewVO() {
		// TODO Auto-generated constructor stub
	}
	public NewsfeedLatestOrderViewVO(String postCode, String recipeCode,
			int likeCount, String userCode, int postHits, String postDate,
			String completeImage, String recipeName, String userName,
			String userImage, String recipeDescription) {
		this.postCode = postCode;
		this.recipeCode = recipeCode;
		this.likeCount = likeCount;
		this.userCode = userCode;
		this.postHits = postHits;
		this.postDate = postDate;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.userName = userName;
		this.userImage = userImage;
		this.recipeDescription = recipeDescription;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public int getPostHits() {
		return postHits;
	}
	public void setPostHits(int postHits) {
		this.postHits = postHits;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getCompleteImage() {
		return completeImage;
	}
	public void setCompleteImage(String completeImage) {
		this.completeImage = completeImage;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
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
	public String getRecipeDescription() {
		return recipeDescription;
	}
	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}
	public String getFollowUserImage() {
		return followUserImage;
	}
	public void setFollowUserImage(String followUserImage) {
		this.followUserImage = followUserImage;
	}
	@Override
	public String toString() {
		return "NewsfeedLatestOrderViewVO [postCode=" + postCode
				+ ", recipeCode=" + recipeCode + ", likeCount=" + likeCount
				+ ", userCode=" + userCode + ", postHits=" + postHits
				+ ", postDate=" + postDate + ", completeImage=" + completeImage
				+ ", recipeName=" + recipeName + ", userName=" + userName
				+ ", userImage=" + userImage + ", recipeDescription="
				+ recipeDescription + ", followUserImage=" + followUserImage
				+ "]";
	}
	
	
	
}
