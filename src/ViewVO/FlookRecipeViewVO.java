package ViewVO;

public class FlookRecipeViewVO {
	private String postCode;
	private String recipeCode;
	private String completeImage;
	private String recipeDescription;
	private int personNumber;
	private String cookingTime;
	private String cookingLevel;
	private String recipeName;
	private int likeCount;
	private int postHits;
	private String postHashTag;
	public FlookRecipeViewVO() {
		// TODO Auto-generated constructor stub
	}
	public FlookRecipeViewVO(String postCode, String recipeCode,
			String completeImage, String recipeDescription, int personNumber,
			String cookingTime, String cookingLevel, String recipeName,
			int likeCount, int postHits, String postHashTag) {
		this.postCode = postCode;
		this.recipeCode = recipeCode;
		this.completeImage = completeImage;
		this.recipeDescription = recipeDescription;
		this.personNumber = personNumber;
		this.cookingTime = cookingTime;
		this.cookingLevel = cookingLevel;
		this.recipeName = recipeName;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.postHashTag = postHashTag;
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
	public int getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
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
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
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
	
	

}
