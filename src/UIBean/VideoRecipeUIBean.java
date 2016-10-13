package UIBean;

import VO.IngredientVO;

public class VideoRecipeUIBean {

	private String postCode;
	private String videoRecipeCode;
	private String videoname;
	private String videoUrl;
	private String recipeCode;
	private int likeCount;
	private String postHits;
	private String recipeDescription;
	
	public VideoRecipeUIBean()
	{
	}

	public VideoRecipeUIBean(String postCode, String videoRecipeCode,
			String videoname, String videoUrl, String recipeCode,
			int likeCount, String postHits, String recipeDescription) {
		this.postCode = postCode;
		this.videoRecipeCode = videoRecipeCode;
		this.videoname = videoname;
		this.videoUrl = videoUrl;
		this.recipeCode = recipeCode;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.recipeDescription = recipeDescription;
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

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
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

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getPostHits() {
		return postHits;
	}

	public void setPostHits(String postHits) {
		this.postHits = postHits;
	}

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}
	
}
