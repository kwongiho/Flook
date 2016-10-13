package ViewVO;

import java.io.Serializable;

public class CartViewVO implements Serializable{
	private String cartCode;
	private String completeImage;
	private String ingredientCode;
	private String userCode;
	private String recipeCode;
	private String recipeName;
	private String ingredientName;
	private int ingredientAmount;
	private String ingredientUnitCode;
	private String ingredientUnitName;
	public CartViewVO() {
		super();
	}
	public CartViewVO(String cartCode, String completeImage,
			String ingredientCode, String userCode, String recipeCode,
			String recipeName, String ingredientName, int ingredientAmount,
			String ingredientUnitCode, String ingredientUnitName) {
		super();
		this.cartCode = cartCode;
		this.completeImage = completeImage;
		this.ingredientCode = ingredientCode;
		this.userCode = userCode;
		this.recipeCode = recipeCode;
		this.recipeName = recipeName;
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.ingredientUnitCode = ingredientUnitCode;
		this.ingredientUnitName = ingredientUnitName;
	}
	public String getCartCode() {
		return cartCode;
	}
	public String getCompleteImage() {
		return completeImage;
	}
	public String getIngredientCode() {
		return ingredientCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public String getRecipeCode() {
		return recipeCode;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public int getIngredientAmount() {
		return ingredientAmount;
	}
	public String getIngredientUnitCode() {
		return ingredientUnitCode;
	}
	public String getIngredientUnitName() {
		return ingredientUnitName;
	}
	public void setCartCode(String cartCode) {
		this.cartCode = cartCode;
	}
	public void setCompleteImage(String completeImage) {
		this.completeImage = completeImage;
	}
	public void setIngredientCode(String ingredientCode) {
		this.ingredientCode = ingredientCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public void setIngredientAmount(int ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}
	public void setIngredientUnitCode(String ingredientUnitCode) {
		this.ingredientUnitCode = ingredientUnitCode;
	}
	public void setIngredientUnitName(String ingredientUnitName) {
		this.ingredientUnitName = ingredientUnitName;
	}
	@Override
	public String toString() {
		return "CartViewVO [cartCode=" + cartCode + ", completeImage="
				+ completeImage + ", ingredientCode=" + ingredientCode
				+ ", userCode=" + userCode + ", recipeCode=" + recipeCode
				+ ", recipeName=" + recipeName + ", ingredientName="
				+ ingredientName + ", ingredientAmount=" + ingredientAmount
				+ ", ingredientUnitCode=" + ingredientUnitCode
				+ ", ingredientUnitName=" + ingredientUnitName + "]";
	}
	
	
	
	
	

}
