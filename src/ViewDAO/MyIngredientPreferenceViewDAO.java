package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Connection.DBConnection;
import ViewVO.MyIngredientPreferenceViewVO;

public class MyIngredientPreferenceViewDAO {
	private DBConnection dbConnection;
	private static MyIngredientPreferenceViewDAO myIngredientPreferenceViewDAO;
	static{
		myIngredientPreferenceViewDAO=new MyIngredientPreferenceViewDAO();
	}

	private  MyIngredientPreferenceViewDAO() {
		// TODO Auto-generated constructor stub
		this.dbConnection = DBConnection.getInstance();
	}

	private MyIngredientPreferenceViewDAO(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public static MyIngredientPreferenceViewDAO getInstance(){
		return myIngredientPreferenceViewDAO;
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public String toString() {
		return "MyIngredientPreferenceViewDAO [dbConnection=" + dbConnection
				+ "]";
	}
	public LinkedList<MyIngredientPreferenceViewVO> analyzingMyIngredientPreference(String userCode){
		//String userCode=null;
		String ingredientCategoryCode = null;
		String ingredientCategoryName = null;
		int scoreTotal= 0;
		LinkedList<MyIngredientPreferenceViewVO> myIngredientPreferenceList=new LinkedList<MyIngredientPreferenceViewVO>();
		
		
		
		PreparedStatement pstmt = null;
		try
		{
			String sql ="select INGREDIENT_CATEGORY_CODE,INGREDIENT_CATEGORY_NAME,SCORE_TOTAL from (select INGREDIENT_CATEGORY_CODE,INGREDIENT_CATEGORY_NAME,SCORE_TOTAL from my_ingredient_preference_view where user_code=? order by score_total desc)";
			pstmt=dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1,userCode);
			
			//pstmt.setInt(4, scoreTotal);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				ingredientCategoryCode = rs.getString("INGREDIENT_CATEGORY_CODE");
				ingredientCategoryName=rs.getString("INGREDIENT_CATEGORY_NAME");
				scoreTotal=rs.getInt("score_total");
				myIngredientPreferenceList.add(new MyIngredientPreferenceViewVO(ingredientCategoryCode,ingredientCategoryName,scoreTotal));
			}
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
		return myIngredientPreferenceList;
	}
	
	public static void main(String args[]){
		MyIngredientPreferenceViewDAO list=MyIngredientPreferenceViewDAO.getInstance();
		
		LinkedList<MyIngredientPreferenceViewVO> arr=list.analyzingMyIngredientPreference("UT001");
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i));
		}
	}
	
		
}
	
	
	
