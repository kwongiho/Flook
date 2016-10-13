package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DBConnection;
import ViewVO.NewsfeedLatestOrderViewVO;
import ViewVO.SimpleVideoRecipeViewVO;

public class NewsfeedLatestOrderViewDAO {
	private static final NewsfeedLatestOrderViewDAO newsfeedLatestOrderViewDAO = new NewsfeedLatestOrderViewDAO();
	private DBConnection dbConn;
	private Connection conn;
	
	private NewsfeedLatestOrderViewDAO()
	{
		this.dbConn = DBConnection.getInstance();
		conn = dbConn.getConn();
	}
	
	public static NewsfeedLatestOrderViewDAO getInstance()
	{
		return newsfeedLatestOrderViewDAO;
	}
	
	public ArrayList<NewsfeedLatestOrderViewVO> searchNewsfeedInLatestOrder(int index)
	{
		ArrayList<NewsfeedLatestOrderViewVO> array = null;
		NewsfeedLatestOrderViewVO postVO = null;
		PreparedStatement pstmt = null;
		try
		{
			array = new ArrayList<NewsfeedLatestOrderViewVO>();
			String sql = "select * from newsfeed_latest_order_view order by post_date desc";
			pstmt = conn.prepareStatement(sql);
			/*pstmt.setInt(1, index);
			pstmt.setInt(2, index+2);*/
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String postCode1 = rs.getString("post_Code");
				String recipeCode1 = rs.getString("recipe_Code");
				int likeCount1 = rs.getInt("like_Count");
				String userCode1 = rs.getString("user_code");
				int postHits1 = rs.getInt("post_Hits");
				String postDate1 = rs.getString("post_date");
				String completeImage1 = rs.getString("complete_image");
				String recipeName1 = rs.getString("recipe_Name");
				String userName1 = rs.getString("user_name");
				String userImage1 = rs.getString("user_image");
				String recipeDescription1 = rs.getString("recipe_Description");
				
				postVO = new NewsfeedLatestOrderViewVO(postCode1, recipeCode1,
						likeCount1, userCode1, postHits1, postDate1,
						completeImage1, recipeName1, userName1,
						userImage1, recipeDescription1);
				array.add(postVO);
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
		return array;
	}
	
	public static void main(String[]args)
	{
		NewsfeedLatestOrderViewDAO dao = NewsfeedLatestOrderViewDAO.getInstance();
		ArrayList<NewsfeedLatestOrderViewVO> array = dao.searchNewsfeedInLatestOrder(0);
		for(int i=0; i<array.size(); i++)
		{
			System.out.println(array.get(i).getPostCode());
		}
	}
}
