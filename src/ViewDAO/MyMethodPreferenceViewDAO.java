package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Connection.DBConnection;
import ViewVO.MyMethodPreferenceViewVO;

public class MyMethodPreferenceViewDAO {
	private DBConnection dbConnection;
	private static MyMethodPreferenceViewDAO myMethodPreferenceViewDAO;
	static{
		 myMethodPreferenceViewDAO=new MyMethodPreferenceViewDAO();
		 
	}
	private MyMethodPreferenceViewDAO() {
		// TODO Auto-generated constructor stub
		dbConnection=DBConnection.getInstance();
	}
	private MyMethodPreferenceViewDAO(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public DBConnection getDbConnection() {
		return dbConnection;
	}
	public static MyMethodPreferenceViewDAO getInstance(){
		return myMethodPreferenceViewDAO;
	}
	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public static MyMethodPreferenceViewDAO getMyMethodPreferenceViewDAO() {
		return myMethodPreferenceViewDAO;
	}
	public static void setMyMethodPreferenceViewDAO(
			MyMethodPreferenceViewDAO myMethodPreferenceViewDAO) {
		MyMethodPreferenceViewDAO.myMethodPreferenceViewDAO = myMethodPreferenceViewDAO;
	}
	public String toString() {
		return "MyMethodCategoryViewDAO [dbConnection=" + dbConnection + "]";
	}
	public LinkedList<MyMethodPreferenceViewVO> analyzingMyMethodPreference(String userCode){
		String methodCategoryCode=null;
		String methodCategoryName=null;
		int scoreTotal;
		LinkedList<MyMethodPreferenceViewVO> myMethodPreferenceList=new LinkedList<MyMethodPreferenceViewVO>();
		
		PreparedStatement pstmt = null;
		try
		{
			String sql ="select METHOD_CATEGORY_CODE,METHOD_CATEGORY_NAME,SCORE_TOTAL from (select METHOD_CATEGORY_CODE,METHOD_CATEGORY_NAME,SCORE_TOTAL from my_method_preference_view where user_code=? order by score_total desc)";
			pstmt=dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1,userCode);
			
			//pstmt.setInt(4, scoreTotal);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				methodCategoryCode = rs.getString("METHOD_CATEGORY_CODE");
				//System.out.println(kindCategoryName);
				methodCategoryName=rs.getString("METHOD_CATEGORY_NAME");
				scoreTotal=rs.getInt("score_total");
				myMethodPreferenceList.add(new MyMethodPreferenceViewVO(methodCategoryCode,methodCategoryName,scoreTotal));
				
			}
			for(int i=0;i<myMethodPreferenceList.size();i++){
				System.out.println(myMethodPreferenceList.get(i));
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
		return myMethodPreferenceList;
	}
	public static void main(String args[]){
		MyMethodPreferenceViewDAO list=MyMethodPreferenceViewDAO.getInstance();
		
		LinkedList<MyMethodPreferenceViewVO> linked=list.analyzingMyMethodPreference("USER_001");
		for(int i=0;i<linked.size();i++){
			System.out.println(linked.get(i));
		}
	
	}

	
	

}
