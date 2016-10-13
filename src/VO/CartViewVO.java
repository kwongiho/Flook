package VO;

import java.io.Serializable;

public class CartViewVO implements Serializable{
	private String cartCode;
	private String ingredientCode;
	private String userCode;
	private String recipeCode;
	private String recipeName;
	private String ingredientName;
	private int ingredientAmount;
	private String ingredientUnit;
	public CartViewVO() {
		super();
	}
	public CartViewVO(String cartCode, String ingredientCode, String userCode,
			String recipeCode, String recipeName, String ingredientName,
			int ingredientAmount, String ingredientUnit) {
		super();
		this.cartCode = cartCode;
		this.ingredientCode = ingredientCode;
		this.userCode = userCode;
		this.recipeCode = recipeCode;
		this.recipeName = recipeName;
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.ingredientUnit = ingredientUnit;
	}
	public String getCartCode() {
		return cartCode;
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
	public String getIngredientUnit() {
		return ingredientUnit;
	}
	public void setCartCode(String cartCode) {
		this.cartCode = cartCode;
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
	public void setIngredientUnit(String ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}
	@Override
	public String toString() {
		return "CartViewVIO [cartCode=" + cartCode + ", ingredientCode="
				+ ingredientCode + ", userCode=" + userCode + ", recipeCode="
				+ recipeCode + ", recipeName=" + recipeName
				+ ", ingredientName=" + ingredientName + ", ingredientAmount="
				+ ingredientAmount + ", ingredientUnit=" + ingredientUnit + "]";
	}
	
}
