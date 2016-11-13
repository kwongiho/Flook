package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import Connection.DBConnection;
import VO.RecipeVO;

public class RecipeDAO {
	private DBConnection dbConnection; 
	private static RecipeDAO dao;
	private static int codeNum=1;
	private static final String codeType="0101UR";
	static{
		dao=new RecipeDAO();
		
	}
	public static RecipeDAO getInstance()
	{
		return dao;
	}
	private RecipeDAO() { 
		dbConnection = DBConnection.getInstance();
	} 
	public DBConnection getDbConnection() {
		return dbConnection;
	}
	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	} 
	public String insertRecipe(RecipeVO recipeVO)
	{
		String recipeCode=recipeVO.getRecipeCode();
		String completeImage=recipeVO.getCompleteImage();
		String recipeName=recipeVO.getRecipeName();
		String recipeDescription=recipeVO.getRecipeDescription();
		int personNumber=recipeVO.getPersonNumber();
		String cookingTime=recipeVO.getCookingTime();
		String cookingLevel=recipeVO.getCookingLevel();
		if(recipeCode!=null)
		{
			
			return this.insertRecipe(recipeCode, completeImage, recipeName, recipeDescription, personNumber, cookingTime, cookingLevel);
		}
		else
		{
			System.out.println(recipeVO);
			return this.insertRecipe(completeImage, recipeName, recipeDescription, personNumber, cookingTime, cookingLevel);
		}
	}
	public String insertRecipe(String completeImage,String recipeName,String recipeDescription,int personNumber,String cookingTime,String cookingLevel)
	{
		PreparedStatement pstmt=null;
		//String recipeCode="'0101UR'||user_recipe_seq.nextval";//CalculateCode.makeCode(codeType, codeNum);
		String recipeCode=codeGenerator2();
				//CalculateCode.makeCode(codeType, codeNum);
		int row = 0; 
		try
		{
			String sql = "INSERT INTO recipe_tb VALUES(?,?,?,?,?,?,?)";
			System.out.println("recipeCode : " +recipeCode);
			
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,recipeCode);
			//pstmt.setString(1,codeType+"||recipe_seq.nextval");
			pstmt.setString(2,completeImage);
			pstmt.setString(3,recipeName);
			pstmt.setString(4,recipeDescription);
			pstmt.setInt(5,personNumber);
			pstmt.setString(6,cookingTime);
			pstmt.setString(7,cookingLevel);
			
			row=pstmt.executeUpdate();
			if(row!=0)
			{
				codeNum++;
				conn.commit(); 
			}

		}
		catch(Exception se){
			System.out.println(se.getMessage());
		}finally{
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception se) {
				System.out.println(se.getMessage());
			}
		}   
		if(row!=0)
		{ 
			codeNum++;
			return recipeCode;
		}			
		return null; 	
	}
	public String insertRecipe(String recipeCode,String completeImage,String recipeName,String recipeDescription,int personNumber,String cookingTime,String cookingLevel)
	{
		PreparedStatement pstmt=null;
		int row = 0; 
		try
		{
			String sql = "INSERT INTO recipe_tb VALUES(?,?,?,?,?,?,?)";
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,recipeCode);
			pstmt.setString(2,completeImage);
			pstmt.setString(3,recipeName);
			pstmt.setString(4,recipeDescription);
			pstmt.setInt(5,personNumber);
			pstmt.setString(6,cookingTime);
			pstmt.setString(7,cookingLevel);
			
			row=pstmt.executeUpdate();
			if(row!=0)
			{
				conn.commit(); 
			}

		}
		catch(Exception se){
			System.out.println(se.getMessage());
		}finally{
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception se) {
				System.out.println(se.getMessage());
			}
		}   
		if(row!=0)
		{ 
			return recipeCode;
		}			
		return null; 	
	}
	public byte deleteRecipe(String recipeCode)
	{
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			String sql = "DELETE FROM recipe_tb WHERE recipe_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recipeCode);
			row = pstmt.executeUpdate();
			if(row!=0)
			{
				conn.commit();
			}

		} catch (Exception se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception se) {
				System.out.println(se.getMessage());
			}
		}   
		return (byte)row;
	}
	public String modifyRecipe(String recipeCode,RecipeVO recipeVO)
	{

		System.out.println("modifyRecipeCon");
		String completeImage=recipeVO.getCompleteImage();
		String recipeName=recipeVO.getRecipeName();
		String recipeDescription=recipeVO.getRecipeDescription();
		int personNumber=recipeVO.getPersonNumber();
		String cookingTime=recipeVO.getCookingTime();
		String cookingLevel=recipeVO.getCookingLevel();
		if(recipeCode!=null)
		{ 
			System.out.println("modifyRecipeCon2");
			return this.modifyRecipe(recipeCode, completeImage, recipeName, recipeDescription, personNumber, cookingTime, cookingLevel);
		} 
		return null;
		
	}
	public String modifyRecipe(String recipeCode,String completeImage,String recipeName,String recipeDescription,int personNumber,String cookingTime,String cookingLevel)
	{
		PreparedStatement pstmt=null;
		int row = 0; 
		try
		{
			// �ϼ����� ���� �Ұ�
			String sql = "UPDATE recipe_tb SET complete_image=?,recipe_name=?,recipe_description=?,person_number=?,cooking_time=?,cooking_level=? WHERE recipe_code=?";
			
			
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,completeImage); 
			pstmt.setString(2,recipeName);
			pstmt.setString(3,recipeDescription);
			pstmt.setInt(4,personNumber);
			pstmt.setString(5,cookingTime);
			pstmt.setString(6,cookingLevel);
			pstmt.setString(7,recipeCode);
			
			row=pstmt.executeUpdate();
			if(row!=0)
			{ 
				conn.commit(); 
			}
		}
		catch(Exception se){
			System.out.println(se.getMessage());
		}finally{
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception se) {
				System.out.println(se.getMessage());
			}
		}    
		if(row!=0)
		{  
			return recipeCode;
		}			
		return null; 	
	}	
	
	
	public String codeGenerator2(){
		return "0101UR"+System.currentTimeMillis();
	}
	public static void main(String[] args)
	{
		RecipeDAO dao=RecipeDAO.getInstance();
		/*System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff")); 
		System.out.println(dao.insertRecipe( "bbb", "ccc", "ddd", 5, "eee", "fff"));*/ 
		dao.insertRecipe("a", "b", "cd", 5, "20", "ff");
		int b=100;
		System.out.println(Integer.toString(b));
	}
}
