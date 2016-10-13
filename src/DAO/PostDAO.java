package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import Connection.DBConnection;
import VO.PostVO;

public class PostDAO {
	private DBConnection dbConnection; 
	private static int codeNum=1; 
	private static final String codeType="0201UP";

	private static PostDAO dao;
	static{
		dao=new PostDAO();
	}

	public static PostDAO getInstance()
	{
		return dao;
	} 
	private PostDAO() {
		dbConnection = DBConnection.getInstance();
	}
	public DBConnection getDbConnection() {
		return dbConnection;
	}
	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public String insertPost(String recipeCode,String userCode,int likeCount,int postHits,String postHashTag)
	{
		PreparedStatement pstmt=null;
		String postCode=codeGenerator2();//CalculateCode.makeCode(codeType, codeNum);
		int row = 0; 
		try
		{
			String sql = "INSERT INTO post_tb VALUES(?,?,?,?,?,?,sysdate)";
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,postCode);
			pstmt.setString(2,recipeCode);
			pstmt.setString(3,userCode);
			pstmt.setInt(4,likeCount);
			pstmt.setInt(5,postHits);
			pstmt.setString(6,postHashTag);  
			
			row=pstmt.executeUpdate();
			if(row!=0)
			{
				conn.commit();
			}
			
		}
		catch(SQLException se){
			se.printStackTrace(); 
		}finally{
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException se) {
				se.printStackTrace(); 
			}
		}   
		if(row!=0)
		{
			codeNum++;
			return postCode;
		}
		return null; 	
	}
	public String insertPost(String postCode,String recipeCode,String userCode,int likeCount,int postHits,String postHashTag)
	{
		PreparedStatement pstmt=null;
		int row = 0; 
		try
		{
			String sql = "INSERT INTO post_tb VALUES(?,?,?,?,?,?,sysdate)";
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,postCode);
			pstmt.setString(2,recipeCode);
			pstmt.setString(3,userCode);
			pstmt.setInt(4,likeCount);
			pstmt.setInt(5,postHits);
			pstmt.setString(6,postHashTag);  
			
			row=pstmt.executeUpdate();
			if(row!=0)
			{
				conn.commit();
			}
			
		}
		catch(SQLException se){
			se.printStackTrace(); 
		}finally{
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException se) {
				se.printStackTrace(); 
			}
		}   
		if(row!=0)
		{
			return postCode; 	
		}
		return null;
	}
	public String insertPost(PostVO postVO)
	{
		String postCode=postVO.getPostCode();
		String recipeCode=postVO.getRecipeCode();
		String userCode=postVO.getUserCode();
		int likeCount=postVO.getLikeCount();
		int postHits=postVO.getPostHits();
		String postHashTag=postVO.getPostHashtag();
		String postDate=postVO.getPostDate();
		if(postCode!=null)
		{
			return this.insertPost(postCode, recipeCode, userCode, likeCount, postHits, postHashTag); 	
			}
		else
		{
			System.out.println(postVO);
			return this.insertPost(recipeCode, userCode, likeCount, postHits, postHashTag);			
		}
	}
	public byte deletePost(String recipeCode)
	{
		int row = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "DELETE FROM post_tb WHERE recipe_code=?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			
			pstmt.setString(1, recipeCode);
			
			row = pstmt.executeUpdate();
			if (row != 0)
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
		return (byte)row;
	}
	public String modifyPost(String recipeCode,PostVO postVO)
	{ 
		
		String userCode=postVO.getUserCode(); 
		String postHashTag=postVO.getPostHashtag(); 
		
		if(recipeCode!=null)
		{
			System.out.println(postVO);
			return this.modifyPost(recipeCode, userCode, postHashTag);			
		}
		return null;
	}

	public String modifyPost(String recipeCode,String userCode,String postHashTag)
	{
		PreparedStatement pstmt=null;
		//String postCode=codeGenerator2();//CalculateCode.makeCode(codeType, codeNum);
		int row = 0; 
		System.out.println(recipeCode);
		System.out.println(userCode);
		try
		{
			String sql = "UPDATE post_tb SET post_hash_tag=?,post_date=sysdate WHERE recipe_code=? AND user_code=?";
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,postHashTag);
			pstmt.setString(2, recipeCode);
			pstmt.setString(3,userCode);  
			
			row=pstmt.executeUpdate();
			if(row!=0)
			{
				conn.commit();
			}
			
		}
		catch(SQLException se){
			se.printStackTrace(); 
		}finally{
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException se) {
				se.printStackTrace(); 
			}
		}   
		if(row!=0)
		{
			return recipeCode;
		}
		return null; 	
	}
/*	public String codeGenerator2(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		
		return dTime+"UP"+System.currentTimeMillis();
	}*/

	/*public String codeGenerator2(){
		return "0201UP"+System.currentTimeMillis();
	}*/
	public int refreshNiceness(String postCode,int niceCount){
		PreparedStatement pstmt=null;
		//String postCode=codeGenerator2();//CalculateCode.makeCode(codeType, codeNum);
		int row = 0; 
		try
		{
			String sql = "update post_tb set LIKE_COUNT=? where post_code=?";
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,niceCount);
			pstmt.setString(2, postCode);
			
			row=pstmt.executeUpdate();
			if(row!=0)
			{
				conn.commit();
			}
			
		}
		catch(SQLException se){
			se.printStackTrace(); 
		}finally{
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException se) {
				se.printStackTrace(); 
			}
		}   
		if(row!=0)
		{
			return row;
		}
		return row; 	
	}

	
	public String codeGenerator2(){
	      SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
	      Date currentTime = new Date( );
	      String dTime = formatter.format ( currentTime );
	      Random randomGenerator = new Random(); 
	      return dTime+"0201FP"+randomGenerator.nextInt(1000)+System.currentTimeMillis();
	}
	public String searchPostCodeByRecipeCode(String recipeCode) {
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from post_tb where recipe_code=?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, recipeCode);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				return res.getString("post_code");
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	public int addPostHits(String recipeCode)
	{
		PreparedStatement pstmt = null;
		int row=0;
		int i=0;
		try {
			Connection conn = dbConnection.getConn();
			String sql = "select * from post_tb where recipe_code=?"; 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, recipeCode);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				i=res.getInt("POST_HITS");
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}  finally {
			try {
				pstmt.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		try{
			Connection conn = dbConnection.getConn();
			String sql = "UPDATE post_tb SET post_hits=? WHERE recipe_code=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ++i);
			pstmt.setString(2, recipeCode);
			row=pstmt.executeUpdate();
			if(row!=0)
			{
				conn.commit();
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}  finally {
			try {
				pstmt.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return row;
	}
	
	public int searchRecipeCount(String userCode)
	{
		PreparedStatement pstmt = null;
		int recipeCount=0;
		try {
			String sql = "SELECT COUNT(*) write_count FROM POST_TB WHERE user_code=?";
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
	
	
	public static void main(String[] args)
	{
		PostDAO dao=PostDAO.getInstance();
		//System.out.println(dao.insertPost("0101UR3", "USER_150729_001", 1, 1, "#a"));
		System.out.println(dao.deletePost("0101UR3"));
	}
}
