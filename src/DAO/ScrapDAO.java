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
import VO.ScrapVO;

public class ScrapDAO {
	private DBConnection dbConnection;
	private static ScrapDAO dao=new ScrapDAO();
	
	private ScrapDAO() {
		// TODO Auto-generated constructor stub
		dbConnection=DBConnection.getInstance();
	}
	public static ScrapDAO getInstance()
	{
		return dao;	
	}
	public int insertScrap(String userCode,String postCode)
	{
		PreparedStatement pstmt=null;
		String scrapCode=codeGenerator2();
		
		int row=0;
		
		try
		{
			String sql="INSERT INTO scrap_tb VALUES(?,?,?,sysdate)";
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,scrapCode);//코드생성필요
			pstmt.setString(2,userCode);
			pstmt.setString(3,postCode); 

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
	public int deleteScrap(String userCode,String postCode)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "delete from scrap_tb where user_code=? AND post_code = ?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, userCode);
			pstmt.setString(2, postCode);

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
	public ScrapVO searchScrap(String userCode,String postCode)
	{
		PreparedStatement pstmt=null;
		ScrapVO scrapVO=null;
		  
		try {
			String sql = "SELECT * FROM scrap_tb WHERE user_code=? AND post_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode); 
			pstmt.setString(2, postCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {  
				String scrapCode=rs.getString("scrap_code");
				String scrapDate=rs.getString("SCRAP_DATE");
				scrapVO=new ScrapVO(scrapCode, userCode, postCode, scrapDate);		
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
		return scrapVO;
		
	}
	public LinkedList<ScrapVO> searchScrapList(String userCode)
	{
		PreparedStatement pstmt=null; 
		LinkedList<ScrapVO> scrapList =new LinkedList<ScrapVO>();
		  
		try {
			String sql = "SELECT * FROM scrap_tb WHERE user_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode);  

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {  
				String scrapCode=rs.getString("scrap_code");
				String postCode=rs.getString("post_code");
				String scrapDate=rs.getString("SCRAP_DATE");
				ScrapVO scrapVO=new ScrapVO(scrapCode, userCode, postCode, scrapDate);
				scrapList.add(scrapVO);
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
		return scrapList;
	}
	
	public String codeGenerator2(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		Random randomGenerator = new Random(); 
		return dTime+"SC"+randomGenerator.nextInt(1000)+System.currentTimeMillis();
	}
	public static void main(String []args)
	{
		ScrapDAO dao=ScrapDAO.getInstance();
		dao.insertScrap("UT1439032038247", "0201UP1438933708771");
		
	}
}
