package VO;

import java.io.Serializable;

public class NicenessInfoVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7858741859117260969L;
	private String nicenessCode;
	private String nicenessUserCode;
	private String postCode;
	private String nicenessDate;
	public NicenessInfoVO() {
		// TODO Auto-generated constructor stub
	}
	public NicenessInfoVO(String nicenessCode, String nicenessUserCode,
			String postCode, String nicenessDate) {
		this.nicenessCode = nicenessCode;
		this.nicenessUserCode = nicenessUserCode;
		this.postCode = postCode;
		this.nicenessDate = nicenessDate;
	}
	public String getNicenessCode() {
		return nicenessCode;
	}
	public void setNicenessCode(String nicenessCode) {
		this.nicenessCode = nicenessCode;
	}
	public String getNicenessUserCode() {
		return nicenessUserCode;
	}
	public void setNicenessUserCode(String nicenessUserCode) {
		this.nicenessUserCode = nicenessUserCode;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getNicenessDate() {
		return nicenessDate;
	}
	public void setNicenessDate(String nicenessDate) {
		this.nicenessDate = nicenessDate;
	}
}
