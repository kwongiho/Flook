package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DBConnection;
import ViewVO.SimpleVideoRecipeViewVO;

public class SimpleVideoRecipeViewDAO {
	//private HashMap<Integer, SimpleVideoRecipeViewVO> postMap = new HashMap<Integer, SimpleVideoRecipeViewVO>();
	private static final SimpleVideoRecipeViewDAO simpleVideoRecipeViewDAO = new SimpleVideoRecipeViewDAO();
	private DBConnection dbConn;
	private Connection conn;
	
	private SimpleVideoRecipeViewDAO()
	{
		this.dbConn = DBConnection.getInstance();
		conn = dbConn.getConn();
	}
	
	public static SimpleVideoRecipeViewDAO getInstance()
	{
		return simpleVideoRecipeViewDAO;
	}
	
	public ArrayList<SimpleVideoRecipeViewVO> searchVideoRecipeList(int index)
	{
		ArrayList<SimpleVideoRecipeViewVO> array = null;
		SimpleVideoRecipeViewVO videoVO = null;
		PreparedStatement pstmt = null;
		try
		{
			array = new ArrayList<SimpleVideoRecipeViewVO>();
			String sql = "select * from(select rownum rnum, s.* from(select * from simple_video_recipe_view order by post_date) s)where rnum>? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, index+2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String postCode1 = rs.getString("post_Code");
				String videoRecipeCode1 = rs.getString("video_Recipe_Code");
				String videoName1 = rs.getString("video_Name");
				String videoUrl1 = rs.getString("video_Url");
				String recipeCode1 = rs.getString("recipe_Code");
				String completeImage1 = rs.getString("complete_image");
				String recipeName1 = rs.getString("recipe_Name");
				String recipeDescription1 = rs.getString("recipe_Description");
				int likeCount1 = rs.getInt("like_Count");
				int postHits1 = rs.getInt("post_Hits");
				String postDate1 = rs.getString("post_Date");
				
				videoVO = new SimpleVideoRecipeViewVO(postCode1, videoRecipeCode1, videoName1, videoUrl1, 
						recipeCode1, completeImage1, recipeName1, recipeDescription1, likeCount1, postHits1, postDate1);
				array.add(videoVO);
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
		SimpleVideoRecipeViewDAO dao = SimpleVideoRecipeViewDAO.getInstance();
		ArrayList<SimpleVideoRecipeViewVO> array = dao.searchVideoRecipeList(1);
		for(int i=0; i<array.size(); i++)
		{
			System.out.println(array.get(i).getPostCode());
		}
	}
}

