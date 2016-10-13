package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
import ViewVO.RecipeCategoryViewVO;

public class RecipeCategoryViewDAO {
	
	private DBConnection dbConnection;
	private static RecipeCategoryViewDAO dao=new RecipeCategoryViewDAO();
	private RecipeCategoryViewDAO()
	{
		dbConnection=DBConnection.getInstance();
	}
	public static RecipeCategoryViewDAO getInstance()
	{
		return dao;
	}
	public RecipeCategoryViewVO searchCategoryList(String recipeCode)
	{
		PreparedStatement pstmt = null;
		RecipeCategoryViewVO recipeCategoryViewVO=null;
		try {
			String sql = "SELECT * FROM recipe_category_view WHERE recipe_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recipeCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				String countryCategory=rs.getString("country_category_name");
				String ingredientCategory=rs.getString("ingredient_category_name");
				String kindCategory=rs.getString("kind_category_name");
				String situationCategory=rs.getString("situation_category_name");
				String methodCategory=rs.getString("method_category_name");
				
				recipeCategoryViewVO=new RecipeCategoryViewVO(recipeCode, countryCategory, ingredientCategory, kindCategory, situationCategory, methodCategory);		
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
		return recipeCategoryViewVO;
		
	}
}
