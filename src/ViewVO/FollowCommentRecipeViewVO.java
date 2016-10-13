package ViewVO;

public class FollowCommentRecipeViewVO {
	private String userCode;
	private String followUserCode;
	private String followCode;
	private String commentCode;
	private String commentDate;
	private String postCode;
	private String recipe_code;
	private int likeCount;
	private int postHits;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	
	public FollowCommentRecipeViewVO(){}
	
	public FollowCommentRecipeViewVO(String userCode, String followUserCode, String followCode, String commentCode,
			String commentDate, String postCode, String recipe_code, int likeCount, int postHits, String completeImage,
			String recipeName, String recipeDescription) {
		super();
		this.userCode = userCode;
		this.followUserCode = followUserCode;
		this.followCode = followCode;
		this.commentCode = commentCode;
		this.commentDate = commentDate;
		this.postCode = postCode;
		this.recipe_code = recipe_code;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
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
	public String getFollowCode() {
		return followCode;
	}
	public void setFollowCode(String followCode) {
		this.followCode = followCode;
	}
	public String getCommentCode() {
		return commentCode;
	}
	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getRecipe_code() {
		return recipe_code;
	}
	public void setRecipe_code(String recipe_code) {
		this.recipe_code = recipe_code;
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
	public String getRecipeDescription() {
		return recipeDescription;
	}
	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}
}
