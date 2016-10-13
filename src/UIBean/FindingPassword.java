package UIBean;

public class FindingPassword {

	private String identificationCode;
	private String email;
	private String newPassword;
	
	public FindingPassword()
	{
		
	}

	public FindingPassword(String identificationCode, String email,
			String newPassword) {
		super();
		this.identificationCode = identificationCode;
		this.email = email;
		this.newPassword = newPassword;
	}

	public String getIdentificationCode() {
		return identificationCode;
	}

	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "FindingPassword [identificationCode=" + identificationCode
				+ ", email=" + email + ", newPassword=" + newPassword + "]";
	}
}
