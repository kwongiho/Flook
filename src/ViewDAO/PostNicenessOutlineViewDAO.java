package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
import ViewVO.PostNicenessOutlineViewVO;
import ViewVO.ProfileWriteOutlineViewVO;

public class PostNicenessOutlineViewDAO {
	private static final PostNicenessOutlineViewDAO dao=new PostNicenessOutlineViewDAO();
	private DBConnection dbConnection;
	private PostNicenessOutlineViewDAO()
	{
		dbConnection=DBConnection.getInstance();
	}
	public static PostNicenessOutlineViewDAO getInstance()
	{
		return dao;
	}
	public int searchRecipeCount(String postCode)
	{
		PreparedStatement pstmt = null;
		//PostNicenessOutlineViewVO postNicenessOutlineViewVO=null; 
		int likeCount=0;
		try {
			String sql = "SELECT * FROM PROFILE_LIKENESSOUTLINE_VIEW WHERE post_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, postCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				likeCount=rs.getInt("like_count");
				
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
		return likeCount;
	}
	
}
