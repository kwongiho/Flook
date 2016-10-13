package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import Connection.DBConnection;
import VO.IngredientVO;

public class IngredientDAO {
	private DBConnection dbConnection;
	private static IngredientDAO dao = new IngredientDAO();
	private static final String codeType = "03";
	private static int mainCodeNum=1;
	private static int subCodeNum=1;
	

	private IngredientDAO() {
		dbConnection = DBConnection.getInstance();
		// TODO Auto-generated constructor stub
	}

	public static IngredientDAO getInstance() {
		return IngredientDAO.dao;

	}

	public IngredientDAO(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public String insertIngredient(IngredientVO ingredientVO)
	{
		String recipeCode=ingredientVO.getRecipeCode();
		String ingredientName=ingredientVO.getIngredientName();
		int ingredientAmount=ingredientVO.getIngredientAmount();
		String ingredientType=ingredientVO.getIngredientType();
		String ingredientUnitCode=ingredientVO.getIngredientUnitCode();
		return insertIngredient(recipeCode, ingredientName, ingredientAmount, ingredientType, ingredientUnitCode);
	}

	public String insertIngredient( String recipeCode,
			String ingredientName, int ingredientAmount,
			String ingredientType, String ingredientUnitCode) {
		int row = 0;
		PreparedStatement pstmt = null;
		String ingredientCode=codeType;
		if(ingredientType.equals("M"))
		{
			ingredientCode=codeGeneratorMI();
			//mainCodeNum++;
		}
		else
		{
			//ingredientCode=CalculateCode.makeCode(codeType+"02"+ingredientType,subCodeNum);
			//subCodeNum++;
			ingredientCode=codeGeneratorSI();
		}
		try {

			String sql = "insert into ingredient_tb values(?,?,?,?,?,?) ";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, ingredientCode);
			pstmt.setString(2, recipeCode);
			pstmt.setString(3, ingredientName);
			pstmt.setInt(4, ingredientAmount);
			pstmt.setString(5, ingredientType);
			pstmt.setString(6, ingredientUnitCode);

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
		if(row!=0)
		{
			return ingredientCode;
		}
		return null;

	}
	public String insertIngredient(String ingredientCode, String recipeCode,
			String ingredientName, String ingredientAmount,
			String ingredientType, String ingredientUnitCode) {
		int row = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "insert into ingredient_tb values(?,?,?,?,?,?) ";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, ingredientCode);
			pstmt.setString(2, recipeCode);
			pstmt.setString(3, ingredientName);
			pstmt.setString(4, ingredientAmount);
			pstmt.setString(5, ingredientType);
			pstmt.setString(6, ingredientUnitCode);

			row= pstmt.executeUpdate();
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

		if(row!=0)
		{
			return ingredientCode;
		}
		return null;

	}

	public byte deleteIngredientRecipe(String recipeCode){
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "delete from ingredient_tb where recipe_code=?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, recipeCode);

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
		return (byte)rowNum;

		
	}
/*	public String codeGeneratorMI(){
		return "0301MI"+System.currentTimeMillis();
	}
	public String codeGeneratorSI(){
		return "0302SI"+System.currentTimeMillis();
	}*/
	
	public String codeGeneratorMI(){
	      SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
	      Date currentTime = new Date( );
	      String dTime = formatter.format ( currentTime );
	      Random randomGenerator = new Random(); 
	      return dTime+"0301MI"+randomGenerator.nextInt(1000)+System.currentTimeMillis();
	}
	public String codeGeneratorSI(){
	      SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
	      Date currentTime = new Date( );
	      String dTime = formatter.format ( currentTime );
	      Random randomGenerator = new Random(); 
	      return dTime+"0302SI"+randomGenerator.nextInt(1000)+System.currentTimeMillis();
	}
	
	public static void main(String args[]) {
		System.out.println(new IngredientDAO().insertIngredient(
				"code2", "음식재료1", 1000, "M", "unitCode"));
		System.out.println(new IngredientDAO().insertIngredient(
				"code2", "음식재료1", 1000, "M", "unitCode"));
		System.out.println(new IngredientDAO().insertIngredient(
				"code2", "음식재료1", 1000, "S", "unitCode"));
		System.out.println(new IngredientDAO().insertIngredient(
				"code2", "음식재료1", 1000, "M", "unitCode"));
		System.out.println(new IngredientDAO().insertIngredient(
				"code2", "음식재료1", 1000, "S", "unitCode"));
		// System.out.println(new
		// IngredientDAO().deleteIngrediet("INGRE"));//("INGRE", "RECIPE_001",
		// "음식재료1", "1000", "G", "주"));
		// System.out.println(new IngredientDAO().deleteIngrediet("INGRE",
		// "음식재료1"));
/*	}public String codeGeneratorMI(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		
		return dTime+"MI"+System.currentTimeMillis();
	}public String codeGeneratorSI(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		
		return dTime+"SI"+System.currentTimeMillis();*/
	}
}
