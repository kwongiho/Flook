package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Connection.DBConnection;
import ViewVO.UserRecipeViewVO;

public class UserRecipeViewDAO {
	private static UserRecipeViewDAO userRecipeViewDAO;
	private DBConnection conn;
	static {
		userRecipeViewDAO = new UserRecipeViewDAO();
	}
	private UserRecipeViewDAO()
	{
		this(DBConnection.getInstance());
	}
	private UserRecipeViewDAO(DBConnection conn) {
		this.conn=conn;
	}
	public static UserRecipeViewDAO getInstance()
	{
		return userRecipeViewDAO;
	}
	public UserRecipeViewVO searchUserRecipe(String postCode) 
	{
		PreparedStatement pstmt = null;
		UserRecipeViewVO userRecipeViewVO=null;
		try {
			String sql = "SELECT * FROM user_recipe_view WHERE recipe_code=?";
			
			pstmt = conn.getConn().prepareStatement(sql);
			pstmt.setString(1, postCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String recipeCode=rs.getString("recipe_code");
				String userCode=rs.getString("user_code");
				String completeImage=rs.getString("complete_image");
				String recipeName=rs.getString("recipe_name");
				String recipeDescription=rs.getString("recipe_description");
				int personNumber=rs.getInt("person_number");
				String cookingTime=rs.getString("cooking_time");
				String cookingLevel=rs.getString("cooking_level");
				int likeCount=rs.getInt("like_count");
				int postHits=rs.getInt("post_hits");
				String postHashTag=rs.getString("post_hash_tag");
				String userName=rs.getString("user_name");
				String userImage=rs.getString("user_image");
				userRecipeViewVO=new UserRecipeViewVO(postCode, recipeCode, userCode, completeImage, recipeName, recipeDescription, personNumber, cookingTime, cookingLevel, likeCount, postHits, postHashTag, userName, userImage);				
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return userRecipeViewVO;
		
	}
	public LinkedList<UserRecipeViewVO> searchUserRecipeListByHashTag(String keyword)
	{
		LinkedList<UserRecipeViewVO> userRecipeVOList = new LinkedList<UserRecipeViewVO>();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from user_recipe_view where post_hash_tag Like ? and UPPER(recipe_code) like ?";
			pstmt = conn.getConn().prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%UR%");
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				userRecipeVOList.add(new UserRecipeViewVO(res.getString("post_Code"), res.getString("recipe_Code"), res.getString("user_Code"), res.getString("complete_image"), res.getString("recipe_name"), res.getString("recipe_description"), res.getInt("person_number"), res.getString("cooking_time"), res.getString("cooking_level"), res.getInt("like_count"), res.getInt("post_hits"), res.getString("post_hash_tag"), res.getString("user_name"), res.getString("user_image")));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return userRecipeVOList;
		
	}
	public static void main(String [] args) {
		System.out.println(UserRecipeViewDAO.getInstance().searchUserRecipeListByHashTag("·¹¼Ò"));
	}
	
}
