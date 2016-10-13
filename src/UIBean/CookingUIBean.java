package UIBean;

public class CookingUIBean {
	private String cookingCode;
	private String cookingImage;
	private String cookingDescription;
	public CookingUIBean() { 
	}
	public CookingUIBean(String cookingCode, String cookingImage,
			String cookingDescription) { 
		this.cookingCode = cookingCode;
		this.cookingImage = cookingImage;
		this.cookingDescription = cookingDescription;
	}
	public String getCookingCode() {
		return cookingCode;
	}
	public void setCookingCode(String cookingCode) {
		this.cookingCode = cookingCode;
	}
	public String getCookingImage() {
		return cookingImage;
	}
	public void setCookingImage(String cookingImage) {
		this.cookingImage = cookingImage;
	}
	public String getCookingDescription() {
		return cookingDescription;
	}
	public void setCookingDescription(String cookingDescription) {
		this.cookingDescription = cookingDescription;
	}
	@Override
	public String toString() {
		return "CookingUIBean [cookingCode=" + cookingCode + ", cookingImage="
				+ cookingImage + ", cookingDescription=" + cookingDescription
				+ "]";
	}
	
}
