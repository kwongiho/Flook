package ViewVO;

public class FollowScrapViewVO {
	private String userCode;
	private String followUserCode;
	private String followCode;
	private String followScrapCode;
	private String followPostCode;
	private String scrapDate;
	private String recipeCode;
	private int likeCount;
	private int postHits;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	
	public FollowScrapViewVO() {
	}

	public FollowScrapViewVO(String userCode, String followUserCode,
			String followCode, String followScrapCode, String followPostCode,
			String scrapDate, String recipeCode, int likeCount, int postHits,
			String completeImage, String recipeName, String recipeDescription) {
		this.userCode = userCode;
		this.followUserCode = followUserCode;
		this.followCode = followCode;
		this.followScrapCode = followScrapCode;
		this.followPostCode = followPostCode;
		this.scrapDate = scrapDate;
		this.recipeCode = recipeCode;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
	}

	public String getUserCode() {
		return userCode;
	}

	public String getFollowUserCode() {
		return followUserCode;
	}

	public String getFollowCode() {
		return followCode;
	}

	public String getFollowScrapCode() {
		return followScrapCode;
	}

	public String getFollowPostCode() {
		return followPostCode;
	}

	public String getScrapDate() {
		return scrapDate;
	}

	public String getRecipeCode() {
		return recipeCode;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public int getPostHits() {
		return postHits;
	}

	public String getCompleteImage() {
		return completeImage;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public void setFollowUserCode(String followUserCode) {
		this.followUserCode = followUserCode;
	}

	public void setFollowCode(String followCode) {
		this.followCode = followCode;
	}

	public void setFollowScrapCode(String followScrapCode) {
		this.followScrapCode = followScrapCode;
	}

	public void setFollowPostCode(String followPostCode) {
		this.followPostCode = followPostCode;
	}

	public void setScrapDate(String scrapDate) {
		this.scrapDate = scrapDate;
	}

	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public void setPostHits(int postHits) {
		this.postHits = postHits;
	}

	public void setCompleteImage(String completeImage) {
		this.completeImage = completeImage;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	
}
