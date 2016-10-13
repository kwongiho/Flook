package ViewVO;

public class MyMethodPreferenceViewVO {
	private String methodCategoryCode;
	private String methodCategoryName;
	private int scoreTotal;
	public MyMethodPreferenceViewVO() {
		// TODO Auto-generated constructor stub
	}
	public MyMethodPreferenceViewVO(String methodCategoryCode,
			String methodCategoryName, int scoreTotal) {
		this.methodCategoryCode = methodCategoryCode;
		this.methodCategoryName = methodCategoryName;
		this.scoreTotal = scoreTotal;
	}
	
	public String getMethodCategoryCode() {
		return methodCategoryCode;
	}
	public void setMethodCategoryCode(String methodCategoryCode) {
		this.methodCategoryCode = methodCategoryCode;
	}
	public String getMethodCategoryName() {
		return methodCategoryName;
	}
	public void setMethodCategoryName(String methodCategoryName) {
		this.methodCategoryName = methodCategoryName;
	}
	public int getScoreTotal() {
		return scoreTotal;
	}
	public void setScoreTotal(int scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	public String toString() {
		return "MyMethodPreferenceViewVO [methodCategoryCode="
				+ methodCategoryCode + ", methodCategoryName="
				+ methodCategoryName + ", scoreTotal=" + scoreTotal + "]";
	}
	
	

}
