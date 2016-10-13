package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.el.parser.ParseException;

import Connection.DBConnection;
import ViewVO.FollowLikeRecipeViewVO;

public class FollowLikeRecipeViewDAO {
	private static final FollowLikeRecipeViewDAO followLikeRecipeViewDAO = new FollowLikeRecipeViewDAO();
	private DBConnection dbConn;
	private Connection conn;
	
	private FollowLikeRecipeViewDAO()
	{
		this.dbConn = DBConnection.getInstance();
		conn = dbConn.getConn();
	}
	
	public static FollowLikeRecipeViewDAO getInstance()
	{
		return followLikeRecipeViewDAO;
	}
	
	public ArrayList<FollowLikeRecipeViewVO> searchNewsFeedPopularOrder(String userCode)
	{
		int cnt=1;
		ArrayList<FollowLikeRecipeViewVO> followLikeMap = null;
		FollowLikeRecipeViewVO postVO = null;
		PreparedStatement pstmt = null;
		try
		{
			followLikeMap = new ArrayList<FollowLikeRecipeViewVO>();
			String sql = "select * from follow_like_recipe_view where follow_user_code=? order by niceness_date";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode);
			/*pstmt.setInt(1, index);
			pstmt.setInt(2, index+2);*/
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String userCode1 = rs.getString("user_code");
				String followUserCode1 = rs.getString("follow_user_code");
				String followCode1 = rs.getString("follow_code");
				String nicenessCode1 = rs.getString("niceness_code");
				String postCode1 = rs.getString("post_code");
				String nicenessDate1 = rs.getString("niceness_date");
				int likeCount1 = rs.getInt("like_count");
				int postHits1 = rs.getInt("post_hits");
				String completeImage1 = rs.getString("complete_image");
				String recipeName1 = rs.getString("recipe_name");
				String recipeDescription1 = rs.getString("recipe_description");
				String userImage1 = rs.getString("user_image");
				String userName1 = rs.getString("user_name");
				
				
				postVO = new FollowLikeRecipeViewVO(userCode1, followUserCode1, followCode1, nicenessCode1,
						postCode1, nicenessDate1, likeCount1, postHits1,
						completeImage1, recipeName1, recipeDescription1, userName1, userImage1);
				/*followLikeMap.put(cnt+"", postVO);*/
				followLikeMap.add(postVO);
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
		return followLikeMap;
	}
	
	public static void main(String[] args) throws ParseException
	{
		FollowLikeRecipeViewDAO dao = new FollowLikeRecipeViewDAO();
		ArrayList<FollowLikeRecipeViewVO> map = dao.searchNewsFeedPopularOrder(null);
		/*for(int i=0; i<map.size(); i++)
		{
			System.out.println(map.get(i+1+"").getNicenessDate());
		}*/
		/*System.out.println(map.get(1+"").getNicenessDate());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		System.out.println("확인1");
		String dateInString = map.get(1+"").getNicenessDate();
		System.out.println("확인2");
		try{
			Date date = formatter.parse(dateInString);
			
			System.out.println(date);
			System.out.println(formatter.format(date));
		}
		catch(java.text.ParseException e){
			e.printStackTrace();
		}*/
		
		
		/*StringTokenizer stok = new StringTokenizer(map.get(1+"").getNicenessDate(),"-: ");*/
		/*while(stok.hasMoreTokens())
		{
			String str = stok.nextToken();
			System.out.println(str);
			
		}
		for(int j=5; j>0; j--)
		{
			System.out.println("야");
		}*/
		for(int i=0; i<map.size(); i++)
		{
			System.out.println(map.get(i).getFollowUserName());
		}
	}
}
