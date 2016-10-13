package UIBean;

public class FollowCommentRecipeUIBean {

	private String commentUserCode;
	private String commentCode;
	private String recopieCode;
	private String postCode;
	private String ricpleName;
	private String completeImage;
	private String recipeDescription;
	private int likeCount;
	private int hits;

	public FollowCommentRecipeUIBean()
	
	{
		
	}

	public FollowCommentRecipeUIBean(String commentUserCode, String commentCode,
			String recopieCode, String postCode, String ricpleName,
			String completeImage, String recipeDescription, int likeCount,
			int hits) {
		this.commentUserCode = commentUserCode;
		this.commentCode = commentCode;
		this.recopieCode = recopieCode;
		this.postCode = postCode;
		this.ricpleName = ricpleName;
		this.completeImage = completeImage;
		this.recipeDescription = recipeDescription;
		this.likeCount = likeCount;
		this.hits = hits;
	}

	public String getCommentUserCode() {
		return commentUserCode;
	}

	public void setCommentUserCode(String commentUserCode) {
		this.commentUserCode = commentUserCode;
	}

	public String getCommentCode() {
		return commentCode;
	}

	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
	}

	public String getRecopieCode() {
		return recopieCode;
	}

	public void setRecopieCode(String recopieCode) {
		this.recopieCode = recopieCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getRicpleName() {
		return ricpleName;
	}

	public void setRicpleName(String ricpleName) {
		this.ricpleName = ricpleName;
	}

	public String getCompleteImage() {
		return completeImage;
	}

	public void setCompleteImage(String completeImage) {
		this.completeImage = completeImage;
	}

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
}
