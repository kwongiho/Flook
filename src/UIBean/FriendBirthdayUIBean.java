package UIBean;

public class FriendBirthdayUIBean {
	
	private String snsFriendCode;
	private String friendUserCode;
	private String userName;
	private String userImage;
	private String userBirthday;
	private String ricpleName;
	private String completeImage;
	private String recipeDescription;
	private int likeCount;
	private int hits;
	public FriendBirthdayUIBean()
	{
		
	}
	public FriendBirthdayUIBean(String snsFriendCode, String friendUserCode,
			String userName, String userImage, String userBirthday,
			String ricpleName, String completeImage, String recipeDescription,
			int likeCount, int hits) {
		super();
		this.snsFriendCode = snsFriendCode;
		this.friendUserCode = friendUserCode;
		this.userName = userName;
		this.userImage = userImage;
		this.userBirthday = userBirthday;
		this.ricpleName = ricpleName;
		this.completeImage = completeImage;
		this.recipeDescription = recipeDescription;
		this.likeCount = likeCount;
		this.hits = hits;
	}
	public String getSnsFriendCode() {
		return snsFriendCode;
	}
	public void setSnsFriendCode(String snsFriendCode) {
		this.snsFriendCode = snsFriendCode;
	}
	public String getFriendUserCode() {
		return friendUserCode;
	}
	public void setFriendUserCode(String friendUserCode) {
		this.friendUserCode = friendUserCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
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
