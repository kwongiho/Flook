package ViewVO;

import java.io.Serializable;

public class ScrapViewVO implements Serializable{
	private String scrapCode;
	private String postCode;
	private String recipeCode;
	private String userCode;
	private String userName;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	private int likeCount;
	private int postHits;
	private String scrapDate;
	public ScrapViewVO() {
		super();
	}
	public ScrapViewVO(String scrapCode, String postCode, String recipeCode,
			String userCode, String userName, String completeImage,
			String recipeName, String recipeDescription, int likeCount,
			int postHits, String scrapDate) {
		super();
		this.scrapCode = scrapCode;
		this.postCode = postCode;
		this.recipeCode = recipeCode;
		this.userCode = userCode;
		this.userName = userName;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.scrapDate = scrapDate;
	}
	public String getScrapCode() {
		return scrapCode;
	}
	public void setScrapCode(String scrapCode) {
		this.scrapCode = scrapCode;
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
	public String getScrapDate() {
		return scrapDate;
	}
	public void setScrapDate(String scrapDate) {
		this.scrapDate = scrapDate;
	}
	@Override
	public String toString() {
		return "ScrapViewVO [scrapCode=" + scrapCode + ", postCode=" + postCode
				+ ", recipeCode=" + recipeCode + ", userCode=" + userCode
				+ ", userName=" + userName + ", completeImage=" + completeImage
				+ ", recipeName=" + recipeName + ", recipeDescription="
				+ recipeDescription + ", likeCount=" + likeCount
				+ ", postHits=" + postHits + ", scrapDate=" + scrapDate + "]";
	}
}
