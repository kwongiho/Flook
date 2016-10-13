package VO;

import java.io.Serializable;

public class ScrapVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4926690084157100326L;
	private String scrapCode;
	private String userCode;
	private String postCode;
	private String scrapDate;
	public ScrapVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ScrapVO(String scrapCode, String userCode, String postCode,
			String scrapDate) {
		this.scrapCode = scrapCode;
		this.userCode = userCode;
		this.postCode = postCode;
		this.scrapDate = scrapDate;
	}

	public String getScrapCode() {
		return scrapCode;
	}

	public void setScrapCode(String scrapCode) {
		this.scrapCode = scrapCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getScrapDate() {
		return scrapDate;
	}

	public void setScrapDate(String scrapDate) {
		this.scrapDate = scrapDate;
	}
}
