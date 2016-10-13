package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
import ViewVO.ProfileNicenessCountViewVO;

public class ProfileNicenessCountViewDAO {
	private static final ProfileNicenessCountViewDAO dao=new ProfileNicenessCountViewDAO();
	private DBConnection dbConnection;
	private ProfileNicenessCountViewDAO()
	{
		dbConnection=DBConnection.getInstance();
	}
	public static ProfileNicenessCountViewDAO getInstance()
	{
		return dao;
	}
	public int searchProfileNicenessCount(String userCode)
	{
		PreparedStatement pstmt = null;
		ProfileNicenessCountViewVO profileNicenessCountViewVO=null;
		int likeCount=0;
		try {
			String sql = "SELECT * FROM PROFILE_NICENESS_COUNT_VIEW  WHERE user_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				likeCount=rs.getInt("like_count");
				
				//profileNicenessCountViewVO = new ProfileNicenessCountViewVO(userCode, likeCount);
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