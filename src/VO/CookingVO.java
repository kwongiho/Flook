package VO;

public class CookingVO {
	private String cookingCode;
	private String recipeCode;
	private int cookingSequence;
	private String cookingImage;
	private String cookingCaption;
	public CookingVO() { 
	}
	public CookingVO(String cookingCode, String recipeCode,
			int cookingSequence, String cookingImage, String cookingCaption) { 
		this.cookingCode = cookingCode;
		this.recipeCode = recipeCode;
		this.cookingSequence = cookingSequence;
		this.cookingImage = cookingImage;
		this.cookingCaption = cookingCaption;
	}
	public String getCookingCode() {
		return cookingCode;
	}
	public void setCookingCode(String cookingCode) {
		this.cookingCode = cookingCode;
	}
	public String getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}
	public int getCookingSequence() {
		return cookingSequence;
	}
	public void setCookingSequence(int cookingSequence) {
		this.cookingSequence = cookingSequence;
	}
	public String getCookingImage() {
		return cookingImage;
	}
	public void setCookingImage(String cookingImage) {
		this.cookingImage = cookingImage;
	}
	public String getCookingCaption() {
		return cookingCaption;
	}
	public void setCookingCaption(String cookingCaption) {
		this.cookingCaption = cookingCaption;
	}
	@Override
	public String toString() {
		return "CookingVO [cookingCode=" + cookingCode + ", recipeCode="
				+ recipeCode + ", cookingSequence=" + cookingSequence
				+ ", cookingImage=" + cookingImage + ", cookingCaption="
				+ cookingCaption + "]";
	} 
	
	

}
