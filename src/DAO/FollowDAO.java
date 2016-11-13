package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

import Connection.DBConnection;
import VO.FollowVO;

public class FollowDAO {
	private DBConnection dbConnection;
	private static FollowDAO dao=new FollowDAO();
	
	private FollowDAO() {
		// TODO Auto-generated constructor stub
		dbConnection=DBConnection.getInstance();
	}
	public static FollowDAO getInstance()
	{
		return dao;	
	}
	public int insertFollow(String targetUserCode,String myUserCode)
	{
		PreparedStatement pstmt=null;
		String followCode=codeGenerator2();
		
		int row=0;
		
		try
		{
			String sql="INSERT INTO follow_tb VALUES(?,?,?)";
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,followCode);//�ڵ�����ʿ�
			pstmt.setString(2,targetUserCode);
			pstmt.setString(3,myUserCode); 

			row=pstmt.executeUpdate();
			System.out.println("isCheck");
			
			if(row!=0)
				conn.commit();  
		}
		
		catch(SQLException se)
		{
				se.printStackTrace();
			//se.stackTracePrint();
		}
		catch(Exception e)
		{
				System.out.println(e.getMessage());
			//e.stackTracePrint();
		}
		finally
		{
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(SQLException se)
				{
					System.out.println(se.getMessage());
					//se.stackTracePrint();
				}
			}
		}

		return row;
	}
	public int deleteFollow(String targetUserCode,String myUserCode)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "delete from follow_tb where USER_CODE=? AND FOLLOW_USER_CODE = ?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, targetUserCode);
			pstmt.setString(2, myUserCode);

			rowNum = pstmt.executeUpdate();
			if (rowNum != 0)
				dbConnection.getConn().commit();
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	} 

	public int deleteFollowByFollowCode(String followCode)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "delete from follow_tb where follow_code=?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, followCode);

			rowNum = pstmt.executeUpdate();
			if (rowNum != 0)
				dbConnection.getConn().commit();
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	} 
	public FollowVO searchFollow(String targetUserCode,String myUserCode)
	{
		PreparedStatement pstmt=null;
		FollowVO followVO=null;
		  
		try {
			String sql = "SELECT * FROM follow_tb WHERE USER_CODE=? AND FOLLOW_USER_CODE = ?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, targetUserCode); 
			pstmt.setString(2, myUserCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {  
				String followCode=rs.getString("FOLLOW_CODE"); 
				followVO=new FollowVO(followCode, targetUserCode, myUserCode);		
			}
		} catch (Exception se) {
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
		return followVO;
	}

	public LinkedList<FollowVO> searchFollowList(String userCode)
	{
		PreparedStatement pstmt=null; 
		LinkedList<FollowVO> followList =new LinkedList<FollowVO>();
		  
		try {
			String sql = "SELECT * FROM follow_tb WHERE user_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode);  

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {  
				String followCode=rs.getString("FOLLOW_CODE"); 
				String followUserCode=rs.getString("FOLLOW_USER_CODE");
				FollowVO followVO = new FollowVO(followCode, userCode, followUserCode);
				followList.add(followVO);
			}
		} catch (Exception se) {
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
		return followList;
	}
	public String codeGenerator2(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		Random randomGenerator = new Random(); 
		return dTime+"FT"+randomGenerator.nextInt(1000)+System.currentTimeMillis();
	}
	public static void main(String[] args) {
		FollowDAO dao=FollowDAO.getInstance();
		dao.insertFollow("UT1439032038247", "UT1438928667977");
		//dao.deleteFollow("UT1439032038247", "UT1438928667977");
		System.out.println(dao.searchFollow("UT1439032038247", "UT1438928667977"));
	}
}
