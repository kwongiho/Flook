package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
import ViewVO.ProfileWriteOutlineViewVO;

public class ProfileWriteOutlineViewDAO {
	private static final ProfileWriteOutlineViewDAO dao=new ProfileWriteOutlineViewDAO();
	private DBConnection dbConnection;
	private ProfileWriteOutlineViewDAO()
	{
		dbConnection=DBConnection.getInstance();
	}
	public static ProfileWriteOutlineViewDAO getInstance()
	{
		return dao;
	}
	public int searchRecipeCount(String userCode)
	{
		PreparedStatement pstmt = null;
		ProfileWriteOutlineViewVO profileWriteOutlineViewVO=null; 
		int recipeCount=0;
		try {
			String sql = "SELECT * FROM PROFILE_WRITE_OUTLINE_VIEW WHERE user_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				recipeCount=rs.getInt("write_count"); 
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
		return recipeCount;
	}

}
