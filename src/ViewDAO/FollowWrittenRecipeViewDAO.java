package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import Connection.DBConnection;
import ViewVO.FollowWrittenRecipeViewVO;

public class FollowWrittenRecipeViewDAO {
	private static final FollowWrittenRecipeViewDAO followWrittenRecipeViewDAO = new FollowWrittenRecipeViewDAO();
	private DBConnection dbConn;
	private Connection conn;
	
	private FollowWrittenRecipeViewDAO()
	{
		this.dbConn = DBConnection.getInstance();
		conn = dbConn.getConn();
	}
	
	private static FollowWrittenRecipeViewDAO getInstance()
	{
		return followWrittenRecipeViewDAO;
	}
	
	public HashMap<String, FollowWrittenRecipeViewVO> searchFollowWrittenRecipe(String WrittenRecipeDate)
	{
		int cnt=1;
		HashMap<String, FollowWrittenRecipeViewVO> followWrittenRecipeMap = null;
		FollowWrittenRecipeViewVO postVO = null;
		PreparedStatement pstmt = null;
		try
		{
			followWrittenRecipeMap = new HashMap<String, FollowWrittenRecipeViewVO>();
			String sql = "select * from follow_written_recipe_view order by post_date";
			pstmt = conn.prepareStatement(sql);
			/*pstmt.setInt(1, index);
			pstmt.setInt(2, index+2);*/
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String followCode1 = rs.getString("follow_code");
				String userCode1 = rs.getString("user_code");
				String followUserCode1 = rs.getString("follow_user_code");
				String followPostCode1 = rs.getString("post_code");
				String followRecipeCode1 = rs.getString("recipe_code");
				int likeCount1 = rs.getInt("like_count");
				int postHits1 = rs.getInt("post_hits");
				String followPostDate1 = rs.getString("post_date");
				String followCompleteImage1 = rs.getString("complete_image");
				String followRecipeName1 = rs.getString("recipe_name");
				String followRecipeDescription1 = rs.getString("recipe_description");
				String followUserName1 = rs.getString("user_name");
				String followUserImage1 = rs.getString("user_image");
				
				
				postVO = new FollowWrittenRecipeViewVO(followCode1, userCode1, followUserCode1, followPostCode1,
						followRecipeCode1, likeCount1, postHits1, followPostDate1, followCompleteImage1,
						followRecipeName1, followRecipeDescription1, followUserName1, followUserImage1);
				followWrittenRecipeMap.put(cnt+"", postVO);
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
		return followWrittenRecipeMap;
	}
	
	public static void main(String[] args)
	{
		FollowWrittenRecipeViewDAO dao = new FollowWrittenRecipeViewDAO();
		HashMap<String, FollowWrittenRecipeViewVO> map = dao.searchFollowWrittenRecipe(null);
		for(int i=0; i<map.size(); i++)
		{
			System.out.println(map.get(i+1+"").getFollowCode());
		}
	}
}
