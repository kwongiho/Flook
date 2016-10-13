package UIBean;

public class FollowWritenRecipeUIBean {

	private String followCode;
	private String follwUserCode;
	private String postCode;
	private String recipeCode;
	private String userName;
	private String userImage;
	private String ricpleName;
	private String completeImage;
	private String recipeDescription;
	private int likeCount;
	private int hits;

	public FollowWritenRecipeUIBean() {
	}

	public FollowWritenRecipeUIBean(String followCode, String follwUserCode,
			String postCode, String recipeCode, String userName,
			String userImage, String ricpleName, String completeImage,
			String recipeDescription, int likeCount, int hits) {
		this.followCode = followCode;
		this.follwUserCode = follwUserCode;
		this.postCode = postCode;
		this.recipeCode = recipeCode;
		this.userName = userName;
		this.userImage = userImage;
		this.ricpleName = ricpleName;
		this.completeImage = completeImage;
		this.recipeDescription = recipeDescription;
		this.likeCount = likeCount;
		this.hits = hits;
	}

	public String getFollowCode() {
		return followCode;
	}

	public void setFollowCode(String followCode) {
		this.followCode = followCode;
	}

	public String getFollwUserCode() {
		return follwUserCode;
	}

	public void setFollwUserCode(String follwUserCode) {
		this.follwUserCode = follwUserCode;
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

	public String getRicpleName() {
		return ricpleName;
	}

	public void setRicpleName(String ricpleName) {
		this.ricpleName = ricpleName;
	}

	public String getCompleteImage() {
		return completeImage;
	}

	public void setCompleteImage(String completeImage) {
		this.completeImage = completeImage;
	}

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
}
