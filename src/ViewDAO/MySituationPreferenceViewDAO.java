package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Connection.DBConnection;
import ViewVO.MySituationPreferenceViewVO;

public class MySituationPreferenceViewDAO {
	private DBConnection dbConnection;
	private static MySituationPreferenceViewDAO mySituationPreferenceViewDAO;
	static{
		 mySituationPreferenceViewDAO=new MySituationPreferenceViewDAO();
		 
	}
	private MySituationPreferenceViewDAO() {
		// TODO Auto-generated constructor stub
		this.dbConnection=DBConnection.getInstance();
	}
	private MySituationPreferenceViewDAO(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public MySituationPreferenceViewDAO(String situationCategoryCode, String situationCategoryName, int scoreTotal) {
		// TODO Auto-generated constructor stub
		dbConnection=DBConnection.getInstance();
	}
	
	public DBConnection getDbConnection() {
		return dbConnection;
	}
	public static MySituationPreferenceViewDAO getInstance(){
		return mySituationPreferenceViewDAO;
	}
	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	public static MySituationPreferenceViewDAO getMySituationPreferenceViewDAO() {
		return mySituationPreferenceViewDAO;
	}
	
	public static void setMySituationPreferenceViewDAO(MySituationPreferenceViewDAO mySituationPreferenceViewDAO) {
		MySituationPreferenceViewDAO.mySituationPreferenceViewDAO = mySituationPreferenceViewDAO;
	}
	
	@Override
	public String toString() {
		return "MySituationPreferenceViewDAO [dbConnection=" + dbConnection
				+ "]";
	}			
	public LinkedList<MySituationPreferenceViewVO> analyzingMySituationPreference(String userCode){
		String situationCategoryCode=null;
		String situationCategoryName=null;
		int scoreTotal;
		
		LinkedList<MySituationPreferenceViewVO> mySituationPreferenceList=new LinkedList<MySituationPreferenceViewVO>();
		
		PreparedStatement pstmt = null;
		try
		{
			String sql ="select SITUATION_CATEGORY_CODE,SITUATION_CATEGORY_NAME,SCORE_TOTAL from (select SITUATION_CATEGORY_CODE,SITUATION_CATEGORY_NAME,SCORE_TOTAL from my_SITUATION_preference_view where user_code=? order by score_total desc)";
			pstmt=dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1,userCode);
			
			//pstmt.setInt(4, scoreTotal);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				situationCategoryCode = rs.getString("SITUATION_CATEGORY_CODE");
				//System.out.println(kindCategoryName);
				situationCategoryName=rs.getString("SITUATION_CATEGORY_NAME");
				scoreTotal=rs.getInt("score_total");
				mySituationPreferenceList.add(new MySituationPreferenceViewVO(situationCategoryCode,situationCategoryName,scoreTotal));
				
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
		return mySituationPreferenceList;
	}
	public static void main(String args[]){
		MySituationPreferenceViewDAO list=MySituationPreferenceViewDAO.getInstance();
		
		LinkedList<MySituationPreferenceViewVO> linked=list.analyzingMySituationPreference("USER_001");
		for(int i=0;i<linked.size();i++){
			System.out.println(linked.get(i));
		}
	
	}


}
