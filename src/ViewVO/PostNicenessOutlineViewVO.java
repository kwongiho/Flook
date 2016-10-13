package ViewVO;

public class PostNicenessOutlineViewVO {
	private String postCode;
	private int likeCount;
	public PostNicenessOutlineViewVO() { 
	}
	public PostNicenessOutlineViewVO(String postCode, int likeCount) { 
		this.postCode = postCode;
		this.likeCount = likeCount;
	}
	@Override
	public String toString() {
		return "postNicenessOutlineViewVO [postCode=" + postCode
				+ ", likeCount=" + likeCount + "]";
	} 
	

}
