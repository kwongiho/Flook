package ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import VO.IngredientVO;
import ViewVO.IngredientViewVO;
import ViewVO.RecipeCategoryViewVO;
import Connection.DBConnection;

public class IngredientViewDAO {

	private DBConnection dbConnection;
	private static IngredientViewDAO dao=new IngredientViewDAO();
	private IngredientViewDAO()
	{
		dbConnection=DBConnection.getInstance();
	}
	public static IngredientViewDAO getInstance()
	{
		return dao;
	}

	public LinkedList<IngredientViewVO> searchIngredientList(String recipeCode,String ingredientType)
	{
		LinkedList<IngredientViewVO> ingredientList=new LinkedList<IngredientViewVO>();

		PreparedStatement pstmt = null;
		IngredientViewVO ingredientViewVO=null;
		try {
			String sql = "SELECT * FROM ingredient_view WHERE recipe_code=? AND ingredient_type=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recipeCode); 
			pstmt.setString(2, ingredientType); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				String ingredientCode=rs.getString("ingredient_code"); 
				String ingredientName=rs.getString("ingredient_name");
				int ingredientAmount=rs.getInt("ingredient_amount"); 
				String ingredientUnitName=rs.getString("ingredient_unit_name");
				ingredientViewVO=new IngredientViewVO(ingredientCode, recipeCode, ingredientName, ingredientAmount, ingredientType, ingredientUnitName);
				ingredientList.add(ingredientViewVO);
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
		if(ingredientList.size()!=0)
		{
			return ingredientList;
		}
		return null;
	}
}
