package UIBean;

public class SimpleUserRecipeUIBean {

	private String postCode;
	private String recipeCode;
	private String completeImage;
	private String recipeName;
	private String recipeDescription;
	private int likeCount;
	private int hits;
	
	public SimpleUserRecipeUIBean()
	{
		
	}

	public SimpleUserRecipeUIBean(String postCode, String recipeCode,
			String completeImage, String recipeName, String recipeDescription,
			int likeCount, int hits) {
		super();
		this.postCode = postCode;
		this.recipeCode = recipeCode;
		this.completeImage = completeImage;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.likeCount = likeCount;
		this.hits = hits;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getRecipeCode() {
		return recipeCode;
	}

	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
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
