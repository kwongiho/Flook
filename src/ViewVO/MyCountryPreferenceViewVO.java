package ViewVO;

public class MyCountryPreferenceViewVO {
	private String countryCategoryCode;
	private String countryCategoryName;
	private int scoreTotal;
	public MyCountryPreferenceViewVO() {
		// TODO Auto-generated constructor stub
	}
	public MyCountryPreferenceViewVO(String countryCategoryCode,
			String countryCategoryName, int scoreTotal) {
		this.countryCategoryCode = countryCategoryCode;
		this.countryCategoryName = countryCategoryName;
		this.scoreTotal = scoreTotal;
	}
	public String getCountryCategoryCode() {
		return countryCategoryCode;
	}
	public void setCountryCategoryCode(String countryCategoryCode) {
		this.countryCategoryCode = countryCategoryCode;
	}
	public String getCountryCategoryName() {
		return countryCategoryName;
	}
	public void setCountryCategoryName(String countryCategoryName) {
		this.countryCategoryName = countryCategoryName;
	}
	public int getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(int scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	public String toString() {
		return "MyCountryCategoryViewVO [countryCategoryCode="
				+ countryCategoryCode + ", countryCategoryName="
				+ countryCategoryName + ", scoreTotal=" + scoreTotal + "]";
	}
	

}
