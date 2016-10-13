package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DBConnection;
import ViewVO.FollowerViewVO;
import ViewVO.FollowingViewVO;

public class FollowingViewDAO {
	public static final FollowingViewDAO followingViewDAO = new FollowingViewDAO();
	private DBConnection dbConn;
	private Connection conn;
	
	private FollowingViewDAO()
	{
		this.dbConn = DBConnection.getInstance();
		conn = dbConn.getConn();
	}
	
	public static FollowingViewDAO getInsatance()
	{
		return followingViewDAO;
	}
	
	public ArrayList<FollowingViewVO> requestFollowingList(String userCode)
	{
		ArrayList<FollowingViewVO> followingArray = null;
		FollowingViewVO followingVO = null;
		PreparedStatement pstmt = null;
		try
		{
			followingArray = new ArrayList<FollowingViewVO>();
			String sql = "select * from following_view where follow_user_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String followCode1 = rs.getString("follow_code");
				String userCode1 = rs.getString("user_code");
				String followUserCode1 = rs.getString("follow_user_code");
				String userName1 = rs.getString("user_name");
				String userImage1 = rs.getString("user_image");
				
				followingVO = new FollowingViewVO(followUserCode1,  userCode1, userName1, userImage1, followCode1);
				followingArray.add(followingVO);
			}
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt != null)
					pstmt.close();
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
		return followingArray;
	}
	
	public static void main(String[]args)
	{
		FollowingViewDAO dao = new FollowingViewDAO();
		ArrayList<FollowingViewVO> array = dao.requestFollowingList("code1");
		for(int i=0; i<array.size(); i++)
		{
			System.out.println(array.get(i).getUserCode());
		}
	}
}
