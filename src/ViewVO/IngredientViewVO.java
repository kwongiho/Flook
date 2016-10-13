package ViewVO;

public class IngredientViewVO {
	private String ingredientCode;
	private String recipeCode;
	private String ingredientName;
	private int ingredientAmount;
	private String ingredientType;
	private String ingredientUnitName;
	public IngredientViewVO() { 
	}
	public IngredientViewVO(String ingredientCode, String recipeCode,
			String ingredientName, int ingredientAmount, String ingredientType,
			String ingredientUnitName) { 
		this.ingredientCode = ingredientCode;
		this.recipeCode = recipeCode;
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.ingredientType = ingredientType;
		this.ingredientUnitName = ingredientUnitName;
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
	public String getIngredientUnitName() {
		return ingredientUnitName;
	}
	public void setIngredientUnitName(String ingredientUnitName) {
		this.ingredientUnitName = ingredientUnitName;
	}
	@Override
	public String toString() {
		return "IngredientViewVO [ingredientCode=" + ingredientCode
				+ ", recipeCode=" + recipeCode + ", ingredientName="
				+ ingredientName + ", igredientAmount=" + ingredientAmount
				+ ", ingredientType=" + ingredientType
				+ ", ingredientUnitName=" + ingredientUnitName + "]";
	}
	

}
