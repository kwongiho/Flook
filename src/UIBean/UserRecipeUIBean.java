package UIBean;

import java.util.Arrays;

public class UserRecipeUIBean {
	private String recipeName;
	private String completeImage;
	private String recipeDescription;
	private String countryCategory;
	private String ingredientCategory;
	private String kindCategory;
	private String situationCategory;
	private String methodCategory;
	private int personNumber;
	private String cookingTime;
	private String cookingLevel;
	private String hashTag;
	private CookingUIBean[] cookingList;
	private IngredientUIBean[] mainIngredientList;
	private IngredientUIBean[] subIngredientList;
	private String userName;
	private String userImage;
	public UserRecipeUIBean() {
		super();
	}
	public UserRecipeUIBean(String recipeName, String completeImage,
			String recipeDescription, String countryCategory,
			String ingredientCategory, String kindCategory,
			String situationCategory, String methodCategory, int personNumber,
			String cookingTime, String cookingLevel, String hashTag,
			CookingUIBean[] cookingList, IngredientUIBean[] mainIngredientList,
			IngredientUIBean[] subIngredientList, String userName,
			String userImage) {
		super();
		this.recipeName = recipeName;
		this.completeImage = completeImage;
		this.recipeDescription = recipeDescription;
		this.countryCategory = countryCategory;
		this.ingredientCategory = ingredientCategory;
		this.kindCategory = kindCategory;
		this.situationCategory = situationCategory;
		this.methodCategory = methodCategory;
		this.personNumber = personNumber;
		this.cookingTime = cookingTime;
		this.cookingLevel = cookingLevel;
		this.hashTag = hashTag;
		this.cookingList = cookingList;
		this.mainIngredientList = mainIngredientList;
		this.subIngredientList = subIngredientList;
		this.userName = userName;
		this.userImage = userImage;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getCompleteImage() {
		return completeImage;
	}
	public void setCompleteImage(String completeImage) {
		this.completeImage = completeImage;
	}
	public String getRecipeDescription() {
		return recipeDescription;
	}
	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
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
	public int getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}
	public String getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}
	public String getCookingLevel() {
		return cookingLevel;
	}
	public void setCookingLevel(String cookingLevel) {
		this.cookingLevel = cookingLevel;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	public CookingUIBean[] getCookingList() {
		return cookingList;
	}
	public void setCookingList(CookingUIBean[] cookingList) {
		this.cookingList = cookingList;
	}
	public IngredientUIBean[] getMainIngredientList() {
		return mainIngredientList;
	}
	public void setMainIngredientList(IngredientUIBean[] mainIngredientList) {
		this.mainIngredientList = mainIngredientList;
	}
	public IngredientUIBean[] getSubIngredientList() {
		return subIngredientList;
	}
	public void setSubIngredientList(IngredientUIBean[] subIngredientList) {
		this.subIngredientList = subIngredientList;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	@Override
	public String toString() {
		return "UserRecipeUIBean [recipeName=" + recipeName
				+ ", completeImage=" + completeImage + ", recipeDescription="
				+ recipeDescription + ", countryCategory=" + countryCategory
				+ ", ingredientCategory=" + ingredientCategory
				+ ", kindCategory=" + kindCategory + ", situationCategory="
				+ situationCategory + ", methodCategory=" + methodCategory
				+ ", personNumber=" + personNumber + ", cookingTime="
				+ cookingTime + ", cookingLevel=" + cookingLevel + ", hashTag="
				+ hashTag + ", cookingList=" + Arrays.toString(cookingList)
				+ ", mainIngredientList=" + Arrays.toString(mainIngredientList)
				+ ", subIngredientList=" + Arrays.toString(subIngredientList)
				+ ", userName=" + userName + ", userImage=" + userImage + "]";
	}
	}
