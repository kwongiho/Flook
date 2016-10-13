package ViewVO;

public class RecipeCategoryViewVO {
	private String recipeCode;
	private String countryCategory;
	private String ingredientCategory;
	private String kindCategory;
	private String situationCategory;
	private String methodCategory;
	public RecipeCategoryViewVO() { 
	}
	public RecipeCategoryViewVO(String recipeCode, String countryCategory,
			String ingredientCategory, String kindCategory,
			String situationCategory, String methodCategory) { 
		this.recipeCode = recipeCode;
		this.countryCategory = countryCategory;
		this.ingredientCategory = ingredientCategory;
		this.kindCategory = kindCategory;
		this.situationCategory = situationCategory;
		this.methodCategory = methodCategory;
	}
	public String getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}
	public String getCountryCategory() {
		return countryCategory;
	}
	public void setCountryCategory(String countryCategory) {
		this.countryCategory = countryCategory;
	}
	public String getIngredientCategory() {
		return ingredientCategory;
	}
	public void setIngredientCategory(String ingredientCategory) {
		this.ingredientCategory = ingredientCategory;
	}
	public String getKindCategory() {
		return kindCategory;
	}
	public void setKindCategory(String kindCategory) {
		this.kindCategory = kindCategory;
	}
	public String getSituationCategory() {
		return situationCategory;
	}
	public void setSituationCategory(String situationCategory) {
		this.situationCategory = situationCategory;
	}
	public String getMethodCategory() {
		return methodCategory;
	}
	public void setMethodCategory(String methodCategory) {
		this.methodCategory = methodCategory;
	}
	@Override
	public String toString() {
		return "RecipeCategoryViewVO [recipeCode=" + recipeCode
				+ ", countryCategory=" + countryCategory
				+ ", ingredientCategory=" + ingredientCategory
				+ ", kindCategory=" + kindCategory + ", situationCategory="
				+ situationCategory + ", methodCategory=" + methodCategory
				+ "]";
	}
	

}
