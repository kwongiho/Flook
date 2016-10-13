package ViewVO;

public class SimpleRecipeViewVO {
	private String recipeCode;
	private String postCode;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	private int likeCount;
	private int postHits;
	private String resCountryCategoryName;
	private String resIngredientCategoryName;
	private String resKindCategoryName;
	private String resSituationCategoryName;
	private String resMethodCategoryName;
	
	public SimpleRecipeViewVO()
	{
		
	}

	public SimpleRecipeViewVO(String recipeCode, String postCode,
			String completeImage, String recipeName, String recipeDescription,
			int likeCount, int postHits, String resCountryCategoryName,
			String resIngredientCategoryName, String resKindCategoryName,
			String resSituationCategoryName, String resMethodCategoryName) {
		super();
		this.recipeCode = recipeCode;
		this.postCode = postCode;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.resCountryCategoryName = resCountryCategoryName;
		this.resIngredientCategoryName = resIngredientCategoryName;
		this.resKindCategoryName = resKindCategoryName;
		this.resSituationCategoryName = resSituationCategoryName;
		this.resMethodCategoryName = resMethodCategoryName;
	}

	public String getRecipeCode() {
		return recipeCode;
	}

	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public String getResCountryCategoryName() {
		return resCountryCategoryName;
	}

	public void setResCountryCategoryName(String resCountryCategoryName) {
		this.resCountryCategoryName = resCountryCategoryName;
	}

	public String getResIngredientCategoryName() {
		return resIngredientCategoryName;
	}

	public void setResIngredientCategoryName(String resIngredientCategoryName) {
		this.resIngredientCategoryName = resIngredientCategoryName;
	}

	public String getResKindCategoryName() {
		return resKindCategoryName;
	}

	public void setResKindCategoryName(String resKindCategoryName) {
		this.resKindCategoryName = resKindCategoryName;
	}

	public String getResSituationCategoryName() {
		return resSituationCategoryName;
	}

	public void setResSituationCategoryName(String resSituationCategoryName) {
		this.resSituationCategoryName = resSituationCategoryName;
	}

	public String getResMethodCategoryName() {
		return resMethodCategoryName;
	}

	public void setResMethodCategoryName(String resMethodCategoryName) {
		this.resMethodCategoryName = resMethodCategoryName;
	}

	@Override
	public String toString() {
		return "SimpleRecipeViewVO [recipeCode=" + recipeCode + ", postCode="
				+ postCode + ", completeImage=" + completeImage
				+ ", recipeName=" + recipeName + ", recipeDescription="
				+ recipeDescription + ", likeCount=" + likeCount
				+ ", postHits=" + postHits + ", resCountryCategoryName="
				+ resCountryCategoryName + ", resIngredientCategoryName="
				+ resIngredientCategoryName + ", resKindCategoryName="
				+ resKindCategoryName + ", resSituationCategoryName="
				+ resSituationCategoryName + ", resMethodCategoryName="
				+ resMethodCategoryName + "]";
	}
}
