package ViewVO;

public class SimpleVideoRecipeViewVO {
	private String postCode;
	private String videoRecipeCode;
	private String videoName;
	private String videoUrl;
	private String recipeCode;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	private int likeCount;
	private int postHits;
	private String postDate;
	
	public SimpleVideoRecipeViewVO() {
		// TODO Auto-generated constructor stub
	}
	public SimpleVideoRecipeViewVO(String postCode, String videoRecipeCode,
			String videoName, String videoUrl, String recipeCode,
			String completeImage, String recipeName, String recipeDescription,
			int likeCount, int postHits, String postDate) {
		this.postCode = postCode;
		this.videoRecipeCode = videoRecipeCode;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.recipeCode = recipeCode;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.postDate = postDate;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getVideoRecipeCode() {
		return videoRecipeCode;
	}
	public void setVideoRecipeCode(String videoRecipeCode) {
		this.videoRecipeCode = videoRecipeCode;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getRecipeCode() {
		return recipeCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
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
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	
	

}
