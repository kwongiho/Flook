package ViewVO;

public class MyKindPreferenceViewVO {
	private String kindCategoryCode;
	private String kindCategoryName;
	private int scoreTotal;
	public MyKindPreferenceViewVO() {
		// TODO Auto-generated constructor stub
	}
	public MyKindPreferenceViewVO(String kindCategoryCode,String kindCategoryName, int scoreTotal) {
		this.kindCategoryCode = kindCategoryCode;
		this.kindCategoryName = kindCategoryName;
		this.scoreTotal = scoreTotal;
	}
	public String getKindCategoryCode() {
		return kindCategoryCode;
	}
	public void setKindCategoryCode(String kindCategoryCode) {
		this.kindCategoryCode = kindCategoryCode;
	}
	public String getKindCategoryName() {
		return kindCategoryName;
	}
	public void setKindCategoryName(String kindCategoryName) {
		this.kindCategoryName = kindCategoryName;
	}
	public int getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(int scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	public String toString() {
		return "MyKindPreferenceViewVO [kindCategoryCode=" + kindCategoryCode
				+ ", kindCategoryName=" + kindCategoryName + ", scoreTotal="
				+ scoreTotal + "]";
	}
	
	
	

}
