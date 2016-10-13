package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import Connection.DBConnection;
import ViewVO.FollowScrapViewVO;

public class FollowScrapViewDAO {
	private static final FollowScrapViewDAO followScrapViewDAO = new FollowScrapViewDAO();
	private DBConnection dbConn;
	private Connection conn;
	
	private FollowScrapViewDAO()
	{
		this.dbConn = DBConnection.getInstance();
		conn = dbConn.getConn();
	}
	
	private static FollowScrapViewDAO getInstance()
	{
		return followScrapViewDAO;
	}
	
	public HashMap<String, FollowScrapViewVO> searchFollowScrap(String scrapDate)
	{
		int cnt=1;
		HashMap<String, FollowScrapViewVO> followScrapMap = null;
		FollowScrapViewVO postVO = null;
		PreparedStatement pstmt = null;
		try
		{
			followScrapMap = new HashMap<String, FollowScrapViewVO>();
			String sql = "select * from follow_scrap_view order by scrap_date";
			pstmt = conn.prepareStatement(sql);
			/*pstmt.setInt(1, index);
			pstmt.setInt(2, index+2);*/
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String userCode1 = rs.getString("user_code");
				String followUserCode1 = rs.getString("follow_user_code");
				String followCode1 = rs.getString("follow_code");
				String followScrapCode1 = rs.getString("scrap_code");
				String followPostCode1 = rs.getString("post_code");
				String scrapDate1 = rs.getString("scrap_date");
				String recipeCode1 = rs.getString("recipe_code");
				int likeCount1 = rs.getInt("like_count");
				int postHits1 = rs.getInt("post_hits");
				String completeImage1 = rs.getString("complete_image");
				String recipeName1 = rs.getString("recipe_name");
				String recipeDescription1 = rs.getString("recipe_description");
				
				
				postVO = new FollowScrapViewVO(userCode1, followUserCode1, followCode1, followScrapCode1, followPostCode1,
						scrapDate1, recipeCode1, likeCount1, postHits1, completeImage1, recipeName1, recipeDescription1);
				followScrapMap.put(cnt+"", postVO);
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
		return followScrapMap;
	}
	
	public static void main(String[] args)
	{
		FollowScrapViewDAO dao = new FollowScrapViewDAO();
		HashMap<String, FollowScrapViewVO> map = dao.searchFollowScrap(null);
		for(int i=0; i<map.size(); i++)
		{
			System.out.println(map.get(i+1+"").getFollowScrapCode());
		}
	}
}
