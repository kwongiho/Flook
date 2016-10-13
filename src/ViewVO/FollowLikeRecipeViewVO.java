package ViewVO;

public class FollowLikeRecipeViewVO {
	private String userCode;
	private String followUserCode;
	private String followCode;
	private String nicenessCode;
	private String postCode;
	private String nicenessDate;	
	private int likeCount;
	private int postHits;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	private String followUserName;
	private String followUserImage;
	
	public FollowLikeRecipeViewVO(){}

	public FollowLikeRecipeViewVO(String userCode, String followUserCode, String followCode, String nicenessCode,
			String postCode, String nicenessDate, int likeCount, int postHits, String completeImage,
			String recipeName, String recipeDescription, String followUserName, String followUserImage) {
		super();
		this.userCode = userCode;
		this.followUserCode = followUserCode;
		this.followCode = followCode;
		this.nicenessCode = nicenessCode;
		this.postCode = postCode;
		this.nicenessDate = nicenessDate;
		this.likeCount = likeCount;
		this.postHits = postHits;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.followUserName = followUserName;
		this.followUserImage = followUserImage;
	}

	public String getFollowUserName() {
		return followUserName;
	}

	public void setFollowUserName(String followUserName) {
		this.followUserName = followUserName;
	}

	public String getFollowUserImage() {
		return followUserImage;
	}

	public void setFollowUserImage(String followUserImage) {
		this.followUserImage = followUserImage;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getFollowUserCode() {
		return followUserCode;
	}

	public void setFollowUserCode(String followUserCode) {
		this.followUserCode = followUserCode;
	}

	public String getFollowCode() {
		return followCode;
	}

	public void setFollowCode(String followCode) {
		this.followCode = followCode;
	}

	public String getNicenessCode() {
		return nicenessCode;
	}

	public void setNicenessCode(String nicenessCode) {
		this.nicenessCode = nicenessCode;
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
	
	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getPostHits() {
		return postHits;
	}

	public void setPostHits(int postHits) {
		this.postHits = postHits;
	}

	public String getCompleteImage() {
		return completeImage;
	}

	public void setCompleteImage(String completeImage) {
		this.completeImage = completeImage;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}
	
}
