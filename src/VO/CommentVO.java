package VO;

import java.io.Serializable;

public class CommentVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8279879618145480632L;
	private String commentCode;
	private String commentUserCode;
	private String commentContents;
	private String commentDate;
	private String postCode;
	
	public CommentVO() {
		// TODO Auto-generated constructor stub
	}

	public CommentVO(String commentCode, String commentUserCode,
			String commentContents, String commentDate, String postCode) {
		this.commentCode = commentCode;
		this.commentUserCode = commentUserCode;
		this.commentContents = commentContents;
		this.commentDate = commentDate;
		this.postCode = postCode;
	}

	public String getCommentCode() {
		return commentCode;
	}

	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
	}

	public String getCommentUserCode() {
		return commentUserCode;
	}

	public void setCommentUserCode(String commentUserCode) {
		this.commentUserCode = commentUserCode;
	}

	public String getCommentContents() {
		return commentContents;
	}

	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
}
