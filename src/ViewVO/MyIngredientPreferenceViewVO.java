package ViewVO;

public class MyIngredientPreferenceViewVO {
	private String ingredientCategoryCode;
	private String ingredientCategoryName;
	private int scoreTotal;
	
	public MyIngredientPreferenceViewVO() {
		// TODO Auto-generated constructor stub
	}
	public MyIngredientPreferenceViewVO(String ingredientCategoryCode, String ingredientCategoryName,int scoreTotal) {
		this.ingredientCategoryCode = ingredientCategoryCode;
		this.ingredientCategoryName = ingredientCategoryName;
		this.scoreTotal = scoreTotal;
	}
	
	
	
	public String getIngredientCategoryName() {
		return ingredientCategoryName;
	}
	public void setIngredientCategoryName(String ingredientCategoryName) {
		this.ingredientCategoryName = ingredientCategoryName;
	}
	
	public String getIngredientCategoryCode() {
		return ingredientCategoryCode;
	}
	public void setIngredientCategoryCode(String ingredientCategoryCode) {
		this.ingredientCategoryCode = ingredientCategoryCode;
	}
	public int getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(int scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	public String toString() {
		return "MyIngredientPreferenceViewVO [ingredientCategoryCode="
				+ ingredientCategoryCode + ", ingredientCategoryName="
				+ ingredientCategoryName + ", scoreTotal=" + scoreTotal + "]";
	}
	
	


}
