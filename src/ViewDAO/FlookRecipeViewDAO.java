package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import Connection.DBConnection;
import ViewVO.FlookRecipeViewVO;

public class FlookRecipeViewDAO {
	private final static FlookRecipeViewDAO flookRecipeViewDAO ;
	private DBConnection conn;
	static {
		flookRecipeViewDAO = new FlookRecipeViewDAO();
	}
	private FlookRecipeViewDAO() {
		this(DBConnection.getInstance());
	}
	private FlookRecipeViewDAO(DBConnection conn) {
		this.conn=conn;
	}
	public static FlookRecipeViewDAO getInstance(){
		return flookRecipeViewDAO;
	}
	public LinkedList<FlookRecipeViewVO> searchFlookRecipeListByHashTag(String keyword)
	{
		LinkedList<FlookRecipeViewVO> flookRecipeVOList = new LinkedList<FlookRecipeViewVO>();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from flook_recipe_view where UPPER(RECIPE_CODE) LIKE ? AND POST_HASH_TAG Like ?";
			pstmt = conn.getConn().prepareStatement(sql);
			pstmt.setString(1,"%FR%");
			pstmt.setString(2, "%"+keyword+"%");
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				flookRecipeVOList.add(new FlookRecipeViewVO(res.getString("post_Code"), res.getString("recipe_Code"), res.getString("complete_image"),res.getString("recipe_description"), res.getInt("person_number"), res.getString("Cooking_time"), res.getString("cooking_level"),res.getString("recipe_name"),res.getInt("like_count"),res.getInt("post_hits"),res.getString("post_hash_tag")));
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
		return flookRecipeVOList;
		
	}
	public static void main(String[]args) {
		System.out.println(FlookRecipeViewDAO.getInstance().searchFlookRecipeListByHashTag("Ä«·¹"));
	}
}
