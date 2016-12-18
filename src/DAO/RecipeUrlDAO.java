package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnection;



public class RecipeUrlDAO {
	private DBConnection dbConnection; 
	private static RecipeUrlDAO dao;
	public static RecipeUrlDAO getInstance(){
		if(dao==null)
			dao=new RecipeUrlDAO();
		return dao;
	}
	private RecipeUrlDAO(){
		dbConnection = DBConnection.getInstance();
	}
	public int insertRecipeUrl(String recipeCode , String recipeUrl) {
		PreparedStatement pstmt=null;
		//String recipeCode="'0101UR'||user_recipe_seq.nextval";//CalculateCode.makeCode(codeType, codeNum);
				//CalculateCode.makeCode(codeType, codeNum);
		int row = 0; 
		try
		{
			String sql = "INSERT INTO recipe_url_tb (recipe_code,recipe_url) VALUES(?,?)";
			
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,recipeCode);
			//pstmt.setString(1,codeType+"||recipe_seq.nextval");
			pstmt.setString(2,recipeUrl);
			
			row=pstmt.executeUpdate();
			if(row!=0)
			{
				conn.commit(); 
				return 1;
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
		return 0;
	}
	public String searchRecipeUrl(String recipeCode) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		//String recipeCode="'0101UR'||user_recipe_seq.nextval";//CalculateCode.makeCode(codeType, codeNum);
				//CalculateCode.makeCode(codeType, codeNum);
		int row = 0; 
		try
		{
			String sql = "select * from recipe_url_tb where recipe_code = ?";
			
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,recipeCode);
			//pstmt.setString(1,codeType+"||recipe_seq.nextval");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				return rs.getString("recipe_url");
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
		return null;
	}
	public static void main(String[]args) {
		RecipeUrlDAO dao = RecipeUrlDAO.getInstance();
		//System.out.println(dao.insertRecipeUrl("0101UR1478057704076", "naver.com"));
		//System.out.println(dao.searchRecipeUrl("0101UR1478057704076"));
	}
}
