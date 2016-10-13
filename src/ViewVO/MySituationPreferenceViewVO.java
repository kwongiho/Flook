package ViewVO;

public class MySituationPreferenceViewVO {
	private String situationCategoryCode;
	private String situationCategoryName;
	private int scoreTotal;
	public MySituationPreferenceViewVO() {
		// TODO Auto-generated constructor stub
	}
	public MySituationPreferenceViewVO(String situationCategoryCode,String situationCategoryName, int scoreTotal) {
		this.situationCategoryCode = situationCategoryCode;
		this.situationCategoryName = situationCategoryName;
		this.scoreTotal = scoreTotal;
	}
	public String getSituationCategoryCode() {
		return situationCategoryCode;
	}
	public void setSituationCategoryCode(String situationCategoryCode) {
		this.situationCategoryCode = situationCategoryCode;
	}
	public String getSituationCategoryName() {
		return situationCategoryName;
	}
	public void setSituationCategoryName(String situationCategoryName) {
		this.situationCategoryName = situationCategoryName;
	}
	public int getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(int scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	public String toString() {
		return "MySituationPreferenceVO [situationCategoryCode="
				+ situationCategoryCode + ", situationCategoryName="
				+ situationCategoryName + ", scoreTotal=" + scoreTotal + "]";
	}
	
	

}
