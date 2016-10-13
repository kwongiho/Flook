package ViewVO;

public class SimpleUserRecipeViewVO {
	private String postCode;
	private String recipeCode;
	private String userCode;
	private String userName;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	private int likeCount;
	private int postHits;
	private String countryCategoryName;
	private String ingredientCategoryName;
	private String kindCategoryName;
	private String situationCategoryName;
	private String methodCategoryName;
	public SimpleUserRecipeViewVO() {
		super();
	}
	public SimpleUserRecipeViewVO(String postCode, String recipeCode,
			String userCode, String userName, String completeImage,
			String recipeName, String recipeDescription, int likeCount,
			int postHits, String countryCategoryName,
			String ingredientCategoryName, String kindCategoryName,
			String situationCategoryName, String methodCategoryName) {
		super();
		this.postCode = postCode;
		this.recipeCode = recipeCode;
		this.userCode = userCode;
		this.userName = userName;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.countryCategoryName = countryCategoryName;
		this.ingredientCategoryName = ingredientCategoryName;
		this.kindCategoryName = kindCategoryName;
		this.situationCategoryName = situationCategoryName;
		this.methodCategoryName = methodCategoryName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCompleteImage() {
		return completeImage;
	}
	public void setCompleteImage(String completeImage) {
		this.completeImage = completeImage;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRecipeDescription() {
		return recipeDescription;
	}
	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getPostHits() {
		return postHits;
	}
	public void setPostHits(int postHits) {
		this.postHits = postHits;
	}
	public String getCountryCategoryName() {
		return countryCategoryName;
	}
	public void setCountryCategoryName(String countryCategoryName) {
		this.countryCategoryName = countryCategoryName;
	}
	public String getIngredientCategoryName() {
		return ingredientCategoryName;
	}
	public void setIngredientCategoryName(String ingredientCategoryName) {
		this.ingredientCategoryName = ingredientCategoryName;
	}
	public String getKindCategoryName() {
		return kindCategoryName;
	}
	public void setKindCategoryName(String kindCategoryName) {
		this.kindCategoryName = kindCategoryName;
	}
	public String getSituationCategoryName() {
		return situationCategoryName;
	}
	public void setSituationCategoryName(String situationCategoryName) {
		this.situationCategoryName = situationCategoryName;
	}
	public String getMethodCategoryName() {
		return methodCategoryName;
	}
	public void setMethodCategoryName(String methodCategoryName) {
		this.methodCategoryName = methodCategoryName;
	}
	@Override
	public String toString() {
		return "SimpleUserRecipeViewVO [postCode=" + postCode + ", recipeCode="
				+ recipeCode + ", userCode=" + userCode + ", userName="
				+ userName + ", completeImage=" + completeImage
				+ ", recipeName=" + recipeName + ", recipeDescription="
				+ recipeDescription + ", likeCount=" + likeCount
				+ ", postHits=" + postHits + ", countryCategoryName="
				+ countryCategoryName + ", ingredientCategoryName="
				+ ingredientCategoryName + ", kindCategoryName="
				+ kindCategoryName + ", situationCategoryName="
				+ situationCategoryName + ", methodCategoryName="
				+ methodCategoryName + "]";
	}
	
	
	
	
}
