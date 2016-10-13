package VO;

import java.io.Serializable;

public class VideoRecipeVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8527483538761028449L;
	private String videoRecipeCode;
	private String videoName;
	private String videoUrl;
	private String recipeCode;
	public VideoRecipeVO() {
		// TODO Auto-generated constructor stub
	}
	public VideoRecipeVO(String videoRecipeCode, String videoName,
			String videoUrl, String recipeCode) {
		this.videoRecipeCode = videoRecipeCode;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.recipeCode = recipeCode;
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
}
