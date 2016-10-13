package UIBean;

public class ProfileAnalyzingUIBean {
	private String name;
	private String percent;
	public ProfileAnalyzingUIBean() {
		// TODO Auto-generated constructor stub
	}
	public ProfileAnalyzingUIBean(String name, String percent) {
		this.name = name;
		this.percent = percent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String toString() {
		return "ProfileAnalyzingUIBean [name=" + name + ", percent=" + percent
				+ "]";
	}
	

}
