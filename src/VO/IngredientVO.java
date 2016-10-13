package VO;

public class IngredientVO {
	
	private String ingredientCode;
	private String recipeCode;
	private String ingredientName;
	private int ingredientAmount; 
	private String ingredientType;
	private String ingredientUnitCode;
	public IngredientVO() { 
	}
	public IngredientVO(String ingredientCode, String recipeCode,
			String ingredientName, int ingredientAmount,
			String ingredientType, String ingredientUnitCode) { 
		this.ingredientCode = ingredientCode;
		this.recipeCode = recipeCode;
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount; 
		this.ingredientType = ingredientType;
		this.ingredientUnitCode = ingredientUnitCode;
	}
	public String getIngredientCode() {
		return ingredientCode;
	}
	public void setIngredientCode(String ingredientCode) {
		this.ingredientCode = ingredientCode;
	}
	public String getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public int getIngredientAmount() {
		return ingredientAmount;
	}
	public void setIngredientAmount(int ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	} 
	public String getIngredientType() {
		return ingredientType;
	}
	public void setIngredientType(String ingredientType) {
		this.ingredientType = ingredientType;
	}
	public String getIngredientUnitCode() {
		return ingredientUnitCode;
	}
	public void setIngredientUnitCode(String ingredientUnitCode) {
		this.ingredientUnitCode = ingredientUnitCode;
	}
	@Override
	public String toString() {
		return "IngredientVO [ingredientCode=" + ingredientCode
				+ ", recipeCode=" + recipeCode + ", ingredientName="
				+ ingredientName + ", ingredientAmount=" + ingredientAmount
				+ ", ingredientType=" + ingredientType
				+ ", ingredientUnitCode=" + ingredientUnitCode + "]";
	}
	

}
