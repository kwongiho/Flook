package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DBConnection;
import ViewVO.FollowerViewVO;
import ViewVO.FollowerViewWithFollowingOrNotVO;

public class FollowerViewDAO {
	private static final FollowerViewDAO followerViewDAO = new FollowerViewDAO();
	private DBConnection dbConn;
	private Connection conn;
	
	private FollowerViewDAO()
	{
		this.dbConn = DBConnection.getInstance();
		
		conn = dbConn.getConn();
	}
	
	public static FollowerViewDAO getInstance()
	{
		return followerViewDAO;
	}

	//���� �ȷ����ϴ� ����� ���(�ȷ���)
	public ArrayList<FollowerViewVO> requestFollowerList(String userCode)
	{
		ArrayList<FollowerViewVO> followingArray = null;
		FollowerViewVO followingVO = null;
		PreparedStatement pstmt = null;
		try
		{
			followingArray = new ArrayList<FollowerViewVO>();
			String sql = "select * from follower_view where user_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				String followCode1 = rs.getString("follow_code");
				String userCode1 = rs.getString("user_code");
				String followUserCode1 = rs.getString("follow_user_code");
				String followUserName1 = rs.getString("user_name");
				String followUserImage1 = rs.getString("user_image");
				
				followingVO = new FollowerViewVO(followCode1, userCode1, followUserCode1, followUserName1, followUserImage1);
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
	//���� �ȷο��ϴ� ������� ��� + �ȷο� ����
		public ArrayList<FollowerViewWithFollowingOrNotVO> requestFollowerListWithFollowingOrNot(String userCode)
		{
			ArrayList<FollowerViewWithFollowingOrNotVO> followingArray = null;
			FollowerViewWithFollowingOrNotVO vo = null;
			PreparedStatement pstmt = null;
			try
			{
				followingArray = new ArrayList<FollowerViewWithFollowingOrNotVO>();
				String sql = "select v.follow_code as vfollow_code, v.user_code as vuser_code, v.follow_user_code as vfollow_user_code, v.user_name as vuser_name, v.user_image as vuser_image, t.follow_code as tfollow_code, t.user_code as tuser_code, t.follow_user_code as tfollow_user_code from follower_view v left outer join follow_tb t on t.user_code = v.follow_user_code and t.follow_user_code = v.user_code where v.user_code=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userCode);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					String vFollowCode1 = rs.getString("vfollow_code");
					String vUserCode1 = rs.getString("vuser_code");
					String vFollowUserCode1 = rs.getString("vfollow_user_code");
					String vFollowUserName1 = rs.getString("vuser_name");
					String vFollowUserImage1 = rs.getString("vuser_image");
					String tFollowCode1 = rs.getString("tfollow_code");
					String tUserCode1 = rs.getString("tuser_code");
					String tFollowUserCode1 = rs.getString("tfollow_user_code");
					
					
					vo = new FollowerViewWithFollowingOrNotVO(vFollowCode1, vUserCode1, vFollowUserCode1, vFollowUserName1,
							vFollowUserImage1, tFollowCode1, tUserCode1, tFollowUserCode1);
					followingArray.add(vo);
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
		FollowerViewDAO dao = new FollowerViewDAO();
		ArrayList<FollowerViewVO> array = dao.requestFollowerList("code1");
		for(int i=0; i<array.size(); i++)
		{
			System.out.println(array.get(i).getFollowCode());
		}
	}
}
