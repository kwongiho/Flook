package VO;

public class RecipeVO {
	private String recipeCode;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	private int personNumber;
	private String cookingTime;
	private String cookingLevel;
	public RecipeVO() { 
	}
	public RecipeVO(String recipeCode, String completeImage, String recipeName,
			String recipeDescription, int personNumber, String cookingTime,
			String cookingLevel) { 
		this.recipeCode = recipeCode;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.personNumber = personNumber;
		this.cookingTime = cookingTime;
		this.cookingLevel = cookingLevel;
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
	@Override
	public String toString() {
		return "RecipeVO [recipeCode=" + recipeCode + ", completeImage="
				+ completeImage + ", recipeName=" + recipeName
				+ ", recipeDescription=" + recipeDescription
				+ ", personNumber=" + personNumber + ", cookingTime="
				+ cookingTime + ", cookingLevel=" + cookingLevel + "]";
	}
	
	
}
