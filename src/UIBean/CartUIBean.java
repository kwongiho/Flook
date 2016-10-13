package UIBean;

public class CartUIBean {

	private String cartCode;
	private String ingredientCode;
	private String recipeCode;
	private String recipeName;
	private String ingredientName;
	private int ingredientAmount;
	private String ingredientUnit;
	private String completeImage;
	
	public CartUIBean()
	{
		
	}

	public CartUIBean(String cartCode, String ingredientCode,
			String recipeCode, String recipeName, String ingredientName,
			int ingredientAmount, String ingredientUnit, String completeImage) {
		this.cartCode = cartCode;
		this.ingredientCode = ingredientCode;
		this.recipeCode = recipeCode;
		this.recipeName = recipeName;
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.ingredientUnit = ingredientUnit;
		this.completeImage = completeImage;
	}

	public String getCartCode() {
		return cartCode;
	}

	public void setCartCode(String cartCode) {
		this.cartCode = cartCode;
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

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
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

	public String getIngredientUnit() {
		return ingredientUnit;
	}

	public void setIngredientUnit(String ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}

	public String getCompleteImage() {
		return completeImage;
	}

	public void setCompleteImage(String completeImage) {
		this.completeImage = completeImage;
	}
	
}
