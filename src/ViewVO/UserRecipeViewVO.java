package ViewVO;


public class UserRecipeViewVO {
	private String postCode;
	private String recipeCode;
	private String userCode;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	private int personNumber;
	private String cookingTime;
	private String cookingLevel;
	private int likeCount;
	private int postHits;
	private String postHashTag;
	private String userName;
	private String userImage;

	public UserRecipeViewVO() {
	}
	public UserRecipeViewVO(String postCode, String recipeCode,
			String userCode, String completeImage, String recipeName,
			String recipeDescription, int personNumber, String cookingTime,
			String cookingLevel, int likeCount, int postHits,
			String postHashTag, String userName, String userImage) {
 		this.postCode = postCode;
		this.recipeCode = recipeCode;
		this.userCode = userCode;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.personNumber = personNumber;
		this.cookingTime = cookingTime;
		this.cookingLevel = cookingLevel;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.postHashTag = postHashTag;
		this.userName = userName;
		this.userImage = userImage;
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
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
	public int getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(int personNumger) {
		this.personNumber = personNumger;
	}
	public String getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}
	public String getCookingLevel() {
		return cookingLevel;
	}
	public void setCookingLevel(String cookingLevel) {
		this.cookingLevel = cookingLevel;
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
	public String getPostHashTag() {
		return postHashTag;
	}
	public void setPostHashTag(String postHashTag) {
		this.postHashTag = postHashTag;
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
	
}
