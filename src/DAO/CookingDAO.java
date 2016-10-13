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
import VO.CookingVO;

public class CookingDAO {
	private DBConnection dbConnection;
	private static CookingDAO dao=new CookingDAO();
	private static final String codeType="0401CK";
	private static int codeNum=1;

	private CookingDAO() {
		dbConnection = DBConnection.getInstance();
		// TODO Auto-generated constructor stub
	}
	public static CookingDAO getInstance()
	{
		return dao;
	}

	public CookingDAO(DBConnection connection) {
		this.dbConnection = connection;
	}

	public DBConnection getConnection() {
		return dbConnection;
	}

	public void setConnection(DBConnection connection) {
		this.dbConnection = connection;
	}
	public String insertCooking(CookingVO cookingVO)
	{
		String cookingCode=cookingVO.getCookingCode();
		String recipeCode=cookingVO.getRecipeCode();
		int cookingSequence=cookingVO.getCookingSequence();
		String cookingImage=cookingVO.getCookingImage();
		String cookingCaption=cookingVO.getCookingCaption();
		if(cookingCode!=null)
		{
			return insertCooking(cookingCode, recipeCode, cookingSequence, cookingImage, cookingCaption);
		}
		else
		{
			return insertCooking(recipeCode, cookingSequence, cookingImage, cookingCaption);	
		}
		
	}

	public String insertCooking(String recipeCode,int cookingSequence,String cookingImage,String cookingCaption){
		int row=0;
		PreparedStatement pstmt = null;
		//String cookingCode=codeType+"||cooking_seq.nextval";//CalculateCode.makeCode(codeType, codeNum);
		String cookingCode=codeGenerator2();
		try
		{

			String sql="insert into cooking_tb VALUES(?,?,?,?,?)";
			pstmt=dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1,cookingCode);
			pstmt.setString(2,recipeCode);
			pstmt.setInt(3,cookingSequence);
			pstmt.setString(4,cookingImage);
			pstmt.setString(5,cookingCaption);
	
			row=pstmt.executeUpdate();
			if(row!=0)
				dbConnection.getConn().commit();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		if(row!=0)
		{
			codeNum++;
			return cookingCode;
		}
		return null;	
	}

	public String insertCooking(String cookingCode,String recipeCode,int cookingSequence,String cookingImage,String cookingCaption){
		int row=0;
		PreparedStatement pstmt = null;
		try
		{

			String sql="insert into cooking_tb VALUES(?,?,?,?,?)";
			pstmt=dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1,cookingCode);
			pstmt.setString(2,recipeCode);
			pstmt.setInt(3,cookingSequence);
			pstmt.setString(4,cookingImage);
			pstmt.setString(5,cookingCaption);
	
			row=pstmt.executeUpdate();
			if(row!=0)
				dbConnection.getConn().commit();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		if(row!=0)
		{
			return cookingCode;
		}
		return null;	
	}

	public byte deleteCookingRecipe(String recipeCode){
		int rowNum=0;
		PreparedStatement pstmt = null;
		try
		{

			String sql="delete from cooking_tb where recipe_code=?";
			pstmt=dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1,recipeCode);
	
			rowNum=pstmt.executeUpdate();
			if(rowNum!=0)
				dbConnection.getConn().commit();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch (SQLException se)
			{
				System.out.println(se.getMessage());
			}
		}
		return (byte)rowNum;	
		
	}/*public String codeGenerator2(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		
		return dTime+"UC"+System.currentTimeMillis();
	}*/
	/*public String codeGenerator2(){
		return "0401UC"+System.currentTimeMillis();
	}*/
	public String codeGenerator2(){
	      SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
	      Date currentTime = new Date( );
	      String dTime = formatter.format ( currentTime );
	      Random randomGenerator = new Random(); 
	      return dTime+"0401UC"+randomGenerator.nextInt(1000)+System.currentTimeMillis();
	}
	public LinkedList<CookingVO> searchCookingList(String recipeCode)
	{

		PreparedStatement pstmt = null;
		CookingVO cookingVO=null;
		LinkedList<CookingVO> cookingList=new LinkedList<CookingVO>();
		try {
			String sql = "SELECT * FROM cooking_tb WHERE recipe_code=? ORDER BY cooking_sequence asc";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recipeCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				String cookingCode=rs.getString("cooking_code");
				int cookingSequence=rs.getInt("cooking_sequence");
				String cookingImage=rs.getString("cooking_image");
				String cookingCaption=rs.getString("cooking_caption");
				
				cookingVO=new CookingVO(cookingCode, recipeCode, cookingSequence, cookingImage, cookingCaption);
				cookingList.add(cookingVO);
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
		if(cookingList.size()!=0)
		{
			return cookingList;
		}
		return null;
	}
	
	
	public static void main(String args[]){
		CookingDAO dao= CookingDAO.getInstance();
		//System.out.println(dao.insertCooking("Cooking_001", "RECIPE_001",1, "이미지2", "설명중입니다"));
//		System.out.println(dao.deleteCooking("Cooking_001"));
		//System.out.println(dao.updateCooking("RECIPE_002", "RECIPE_002",3, "image333", "newCaption", "cooking_001"));
	}
	
}
