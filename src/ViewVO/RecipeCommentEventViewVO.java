package ViewVO;

public class RecipeCommentEventViewVO {
	private String commentUserCode;
	private String commnetCode;
	private String userCode;
	private String recipeCode;
	private String postCode;
	private String commentDate;
	private String completeImage;
	private String recipeName;
	private String commentUserName;
	private String commentUserImage;
	public RecipeCommentEventViewVO() {
		// TODO Auto-generated constructor stub
	}
	public RecipeCommentEventViewVO(String commentUserCode, String commnetCode,
			String userCode, String recipeCode, String postCode,
			String commentDate, String completeImage, String recipeName,
			String commentUserName, String commentUserImage) {
		this.commentUserCode = commentUserCode;
		this.commnetCode = commnetCode;
		this.userCode = userCode;
		this.recipeCode = recipeCode;
		this.postCode = postCode;
		this.commentDate = commentDate;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.commentUserName = commentUserName;
		this.commentUserImage = commentUserImage;
	}
	public String getCommentUserCode() {
		return commentUserCode;
	}
	public void setCommentUserCode(String commentUserCode) {
		this.commentUserCode = commentUserCode;
	}
	public String getCommnetCode() {
		return commnetCode;
	}
	public void setCommnetCode(String commnetCode) {
		this.commnetCode = commnetCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
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
	public String getCommentUserName() {
		return commentUserName;
	}
	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}
	public String getCommentUserImage() {
		return commentUserImage;
	}
	public void setCommentUserImage(String commentUserImage) {
		this.commentUserImage = commentUserImage;
	}
	
	

}
