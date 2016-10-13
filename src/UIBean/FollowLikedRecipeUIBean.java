package UIBean;

public class FollowLikedRecipeUIBean {

	private String recipeCode;
	private String postCode;
	private String nicenessCode;
	private String nicenessUserCode;
	private String nicenessUserName;
	private String nicenessUserImage;
	private String ricpleName;
	private String completeImage;
	private String recipeDescription;
	private int likeCount;
	private int hits;

	public FollowLikedRecipeUIBean()
	{
		
	}
	public FollowLikedRecipeUIBean(String recipeCode, String postCode,
			String nicenessCode, String nicenessUserCode,
			String nicenessUserName, String nicenessUserImage,
			String ricpleName, String completeImage, String recipeDescription,
			int likeCount, int hits) {
		this.recipeCode = recipeCode;
		this.postCode = postCode;
		this.nicenessCode = nicenessCode;
		this.nicenessUserCode = nicenessUserCode;
		this.nicenessUserName = nicenessUserName;
		this.nicenessUserImage = nicenessUserImage;
		this.ricpleName = ricpleName;
		this.completeImage = completeImage;
		this.recipeDescription = recipeDescription;
		this.likeCount = likeCount;
		this.hits = hits;
	}

	public String getRecipeCode() {
		return recipeCode;
	}

	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public String getNicenessUserName() {
		return nicenessUserName;
	}

	public void setNicenessUserName(String nicenessUserName) {
		this.nicenessUserName = nicenessUserName;
	}

	public String getNicenessUserImage() {
		return nicenessUserImage;
	}

	public void setNicenessUserImage(String nicenessUserImage) {
		this.nicenessUserImage = nicenessUserImage;
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
 
