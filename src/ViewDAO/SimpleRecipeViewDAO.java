package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import Connection.DBConnection;
import ViewVO.SimpleRecipeViewVO;

public class SimpleRecipeViewDAO {

	private static final SimpleRecipeViewDAO simpleRecipeViewDAO;
	private DBConnection conn;

	static {
		simpleRecipeViewDAO = new SimpleRecipeViewDAO();
	}

	private SimpleRecipeViewDAO() {

		conn = DBConnection.getInstance();
	}

	public static SimpleRecipeViewDAO getInstance() {
		return simpleRecipeViewDAO;
	}

	public LinkedList<SimpleRecipeViewVO> searchFlookRecipeListByRecipeName(
			String keyword) {
		LinkedList<SimpleRecipeViewVO> simpleRecipeVOList = new LinkedList<SimpleRecipeViewVO>();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from simple_recipe_view where recipe_name Like ? and UPPER(recipe_code) like ?";
			pstmt = conn.getConn().prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%FR%");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				simpleRecipeVOList
						.add(new SimpleRecipeViewVO(res
								.getString("recipe_Code"), res
								.getString("post_Code"), res
								.getString("complete_Image"), res
								.getString("recipe_Name"), res
								.getString("RECIPE_DESCRIPTION"), res
								.getInt("like_Count"),res
								.getInt("post_Hits"),res
								.getString("country_category_name"),res
								.getString("ingredient_category_name"),res
								.getString("kind_category_name"), res
								.getString("situation_category_name"), res
								.getString("method_category_name")));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return simpleRecipeVOList;

	}

	public LinkedList<SimpleRecipeViewVO> searchFlookRecipeListByHashTag(
			String keyword) {
		LinkedList<SimpleRecipeViewVO> simpleRecipeVOList = new LinkedList<SimpleRecipeViewVO>();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from flook_recipe_view where POST_HASH_TAG Like ?";
			pstmt = conn.getConn().prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				simpleRecipeVOList
						.add(new SimpleRecipeViewVO(res
								.getString("recipe_Code"), res
								.getString("post_Code"), res
								.getString("complete_Image"), res
								.getString("recipe_Name"), res
								.getString("RECIPE_DESCRIPTION"), res
								.getInt("like_Count"),res
								.getInt("post_Hits"),res
								.getString("country_category_name"),res
								.getString("ingredient_category_name"),res
								.getString("kind_category_name"), res
								.getString("situation_category_name"), res
								.getString("method_category_name")));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return simpleRecipeVOList;

	}

	public static void main(String[] args) {
		/*
		 * System.out.println(SimpleRecipeViewDAO.getInstance().
		 * searchFlookRecipeListByHashTag("½ºÆÔ").get(0));
		 */
		System.out.println(SimpleRecipeViewDAO.getInstance()
				.searchFlookRecipeListByRecipeName("±èÄ¡").get(0));
	}
	/*
	 * public LinkedList<SimpleRecipeViewVO> selectSimpleRecipe(String psotCode)
	 * { return null; }
	 */
}
