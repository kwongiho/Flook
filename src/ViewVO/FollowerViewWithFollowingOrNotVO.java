package ViewVO;

public class FollowerViewWithFollowingOrNotVO {
	private String vFollowCode;
	private String vUserCode;
	private String vFollowUserCode;
	private String vFollowUserName;
	private String vFollowUserImage;
	private String tFollowCode;
	private String tUserCode;
	private String tFollowUserCode;
	
	public FollowerViewWithFollowingOrNotVO(){}

	public FollowerViewWithFollowingOrNotVO(String vFollowCode, String vUserCode, String vFollowUserCode,
			String vFollowUserName, String vFollowUserImage, String tFollowCode, String tUserCode,
			String tFollowUserCode) {
		super();
		this.vFollowCode = vFollowCode;
		this.vUserCode = vUserCode;
		this.vFollowUserCode = vFollowUserCode;
		this.vFollowUserName = vFollowUserName;
		this.vFollowUserImage = vFollowUserImage;
		this.tFollowCode = tFollowCode;
		this.tUserCode = tUserCode;
		this.tFollowUserCode = tFollowUserCode;
	}

	public String getvFollowCode() {
		return vFollowCode;
	}

	public void setvFollowCode(String vFollowCode) {
		this.vFollowCode = vFollowCode;
	}

	public String getvUserCode() {
		return vUserCode;
	}

	public void setvUserCode(String vUserCode) {
		this.vUserCode = vUserCode;
	}

	public String getvFollowUserCode() {
		return vFollowUserCode;
	}

	public void setvFollowUserCode(String vFollowUserCode) {
		this.vFollowUserCode = vFollowUserCode;
	}

	public String getvFollowUserName() {
		return vFollowUserName;
	}

	public void setvFollowUserName(String vFollowUserName) {
		this.vFollowUserName = vFollowUserName;
	}

	public String getvFollowUserImage() {
		return vFollowUserImage;
	}

	public void setvFollowUserImage(String vFollowUserImage) {
		this.vFollowUserImage = vFollowUserImage;
	}

	public String gettFollowCode() {
		return tFollowCode;
	}

	public void settFollowCode(String tFollowCode) {
		this.tFollowCode = tFollowCode;
	}

	public String gettUserCode() {
		return tUserCode;
	}

	public void settUserCode(String tUserCode) {
		this.tUserCode = tUserCode;
	}

	public String gettFollowUserCode() {
		return tFollowUserCode;
	}

	public void settFollowUserCode(String tFollowUserCode) {
		this.tFollowUserCode = tFollowUserCode;
	}
	
	
}
