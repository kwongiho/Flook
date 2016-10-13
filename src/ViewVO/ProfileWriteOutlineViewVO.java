package ViewVO;

public class ProfileWriteOutlineViewVO {
	private String userCode;
	private int recipeCount;
	public ProfileWriteOutlineViewVO() { 
	}
	public ProfileWriteOutlineViewVO(String userCode, int recipeCount) { 
		this.userCode = userCode;
		this.recipeCount = recipeCount;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public int getRecipeCount() {
		return recipeCount;
	}
	public void setRecipeCount(int recipeCount) {
		this.recipeCount = recipeCount;
	}
	@Override
	public String toString() {
		return "profileWriteOutlineViewVO [userCode=" + userCode
				+ ", recipeCount=" + recipeCount + "]";
	}
	

}
