package UIBean;

public class IngredientUIBean {
	private String ingredientName;
	private int ingredientAmount;
	private String ingredientUnit;
	public IngredientUIBean() { 
	}
	public IngredientUIBean(String ingredientName, int ingredientAmount,
			String ingredientUnit) { 
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.ingredientUnit = ingredientUnit;
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
	@Override
	public String toString() {
		return "IngredientUIBean [ingredientName=" + ingredientName
				+ ", ingredientAmount=" + ingredientAmount
				+ ", ingredientUnit=" + ingredientUnit + "]";
	}
	

}
