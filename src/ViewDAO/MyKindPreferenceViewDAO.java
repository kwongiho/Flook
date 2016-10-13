package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Connection.DBConnection;
import ViewVO.MyKindPreferenceViewVO;

public class MyKindPreferenceViewDAO {
	private DBConnection dbConnection;
	private static MyKindPreferenceViewDAO myKindPreferenceViewDAO;
	static{
		myKindPreferenceViewDAO =new MyKindPreferenceViewDAO();
	}
	private MyKindPreferenceViewDAO(){
		this.dbConnection=DBConnection.getInstance();
		
	}
	private MyKindPreferenceViewDAO(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public DBConnection getDbConnection() {
		return dbConnection;
	}
	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public static MyKindPreferenceViewDAO getInstance(){
		return myKindPreferenceViewDAO;
	}
	public static MyKindPreferenceViewDAO getMyKindPreferenceViewDAO() {
		return myKindPreferenceViewDAO;
	}
	public static void setMyKindPreferenceViewDAO(
			MyKindPreferenceViewDAO myKindPreferenceViewDAO) {
		MyKindPreferenceViewDAO.myKindPreferenceViewDAO = myKindPreferenceViewDAO;
	}
	public String toString() {
		return "MyKindPreferenceViewDAO [dbConnection=" + dbConnection + "]";
	}
	public LinkedList<MyKindPreferenceViewVO> analyzingMyKindPreference(String userCode){
		String kindCategoryCode = null;
		String kindCategoryName = null;
		int scoreTotal= 0;
		LinkedList<MyKindPreferenceViewVO> myKindPreferenceList=new LinkedList<MyKindPreferenceViewVO>();
		PreparedStatement pstmt = null;
		try
		{
			String sql ="select KIND_CATEGORY_CODE,KIND_CATEGORY_NAME,SCORE_TOTAL from (select KIND_CATEGORY_CODE,KIND_CATEGORY_NAME,SCORE_TOTAL from my_kind_preference_view where user_code=? order by score_total desc)";
			pstmt=dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1,userCode);
			
			//pstmt.setInt(4, scoreTotal);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				kindCategoryCode = rs.getString("KIND_CATEGORY_CODE");
				//System.out.println(kindCategoryName);
				kindCategoryName=rs.getString("KIND_CATEGORY_NAME");
				System.out.println(kindCategoryName);
				scoreTotal=rs.getInt("score_total");
				myKindPreferenceList.add(new MyKindPreferenceViewVO(kindCategoryCode,kindCategoryName,scoreTotal));
				
			}
			for(int i=0;i<myKindPreferenceList.size();i++){
				System.out.println(myKindPreferenceList.get(i));
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
		return myKindPreferenceList;
		
		
	}
	public static void main(String args[]){
		MyKindPreferenceViewDAO list=MyKindPreferenceViewDAO.getInstance();
		
		LinkedList<MyKindPreferenceViewVO> linked=list.analyzingMyKindPreference("UT001");
		for(int i=0;i<linked.size();i++){
			System.out.println(linked.get(i));
		}
	
	}

}
