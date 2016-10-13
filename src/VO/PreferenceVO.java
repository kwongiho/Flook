package VO;

import java.io.Serializable;

public class PreferenceVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7811542262836790392L;
	private String preferenceCode;
	private String preferenceScore;
	private String userCode;
	private String recipeCode;
	public PreferenceVO() {
		// TODO Auto-generated constructor stub
	}
	public PreferenceVO(String preferenceCode, String preferenceScore,
			String userCode, String recipeCode) {
		this.preferenceCode = preferenceCode;
		this.preferenceScore = preferenceScore;
		this.userCode = userCode;
		this.recipeCode = recipeCode;
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
	
}
