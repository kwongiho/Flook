package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import Connection.DBConnection;
import ViewVO.FollowCommentRecipeViewVO;

public class FollowCommentRecipeViewDAO {
	private static final FollowCommentRecipeViewDAO followCommentRecipeViewDAO = new FollowCommentRecipeViewDAO();
	private DBConnection dbConn;
	private Connection conn;
	
	private FollowCommentRecipeViewDAO()
	{
		this.dbConn = DBConnection.getInstance();
		try {
			conn = dbConn.getConn();	
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	private static FollowCommentRecipeViewDAO getInstance()
	{
		return followCommentRecipeViewDAO;
	}
	
	public HashMap<String, FollowCommentRecipeViewVO> searchFollowCommentRecipe(String commentDate)
	{
		int cnt=1;
		HashMap<String, FollowCommentRecipeViewVO> followCommentMap = null;
		FollowCommentRecipeViewVO postVO = null;
		PreparedStatement pstmt = null;
		try
		{
			followCommentMap = new HashMap<String, FollowCommentRecipeViewVO>();
			String sql = "select * from follow_Comment_recipe_view order by comment_date";
			pstmt = conn.prepareStatement(sql);
			/*pstmt.setInt(1, index);
			pstmt.setInt(2, index+2);*/
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String userCode1 = rs.getString("user_code");
				String followUserCode1 = rs.getString("follow_user_code");
				String followCode1 = rs.getString("follow_code");
				String commentCode1 = rs.getString("comment_code");
				String commentDate1 = rs.getString("comment_date");
				String postCode1 = rs.getString("post_code");
				String recipeCode1 = rs.getString("recipe_code");
				int likeCount1 = rs.getInt("like_count");
				int postHits1 = rs.getInt("post_hits");
				String completeImage1 = rs.getString("complete_image");
				String recipeName1 = rs.getString("recipe_name");
				String recipeDescription1 = rs.getString("recipe_description");
				
				
				postVO = new FollowCommentRecipeViewVO(userCode1, followUserCode1, followCode1, commentCode1,
						commentDate1, postCode1, recipeCode1, likeCount1, postHits1,
						completeImage1, recipeName1, recipeDescription1);
				followCommentMap.put(cnt+"", postVO);
				cnt++;
			}
		}
		catch(SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null)
					pstmt.close();
			}
			catch(SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return followCommentMap;
	}
	
	public static void main(String[] args)
	{
		FollowCommentRecipeViewDAO dao = new FollowCommentRecipeViewDAO();
		HashMap<String, FollowCommentRecipeViewVO> map = dao.searchFollowCommentRecipe(null);
		for(int i=0; i<map.size(); i++)
		{
			System.out.println(map.get(i+1+"").getCommentCode());
		}
	}
}
