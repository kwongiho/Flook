package ViewVO;

public class PreferenceViewVO {
	private String preferenceCode;
	private String preferenceScore;
	private String userCode;
	private String recipeCode;
	private String countryCategory;
	private String kindCategory;
	private String situationCategory;
	private String ingredientCategory;
	public PreferenceViewVO() {
		// TODO Auto-generated constructor stub
	}
	public PreferenceViewVO(String preferenceCode, String preferenceScore,
			String userCode, String recipeCode, String countryCategory,
			String kindCategory, String situationCategory,
			String ingredientCategory) {
		this.preferenceCode = preferenceCode;
		this.preferenceScore = preferenceScore;
		this.userCode = userCode;
		this.recipeCode = recipeCode;
		this.countryCategory = countryCategory;
		this.kindCategory = kindCategory;
		this.situationCategory = situationCategory;
		this.ingredientCategory = ingredientCategory;
	}
	public String getPreferenceCode() {
		return preferenceCode;
	}
	public void setPreferenceCode(String preferenceCode) {
		this.preferenceCode = preferenceCode;
	}
	public String getPreferenceScore() {
		return preferenceScore;
	}
	public void setPreferenceScore(String preferenceScore) {
		this.preferenceScore = preferenceScore;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
	public String getIngredientCategory() {
		return ingredientCategory;
	}
	public void setIngredientCategory(String ingredientCategory) {
		this.ingredientCategory = ingredientCategory;
	}
	
	

}
