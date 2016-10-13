package ViewDAO;
import Connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import ViewVO.MyCountryPreferenceViewVO;

public class MyCountryPreferenceViewDAO {
	private DBConnection dbConnnection;
	private static MyCountryPreferenceViewDAO myCountryCategoryViewDAO;
	static{
		myCountryCategoryViewDAO=new MyCountryPreferenceViewDAO();
	}
	private  MyCountryPreferenceViewDAO() {
		dbConnnection=DBConnection.getInstance();
		// TODO Auto-generated Connstructor stub
	}
	private MyCountryPreferenceViewDAO(DBConnection dbConnnection) {
		this.dbConnnection = dbConnnection;
	}
	
	public DBConnection getDbConnnection() {
		return dbConnnection;
	}
	public void setDbConnnection(DBConnection dbConnnection) {
		this.dbConnnection = dbConnnection;
	}
	public static MyCountryPreferenceViewDAO getMyCountryCategoryViewDAO() {
		return myCountryCategoryViewDAO;
	}
	public static MyCountryPreferenceViewDAO getInstance(){
		return myCountryCategoryViewDAO;
	}
	public static void setMyCountryCategoryViewDAO(
			MyCountryPreferenceViewDAO myCountryCategoryViewDAO) {
		MyCountryPreferenceViewDAO.myCountryCategoryViewDAO = myCountryCategoryViewDAO;
	}
	public String toString() {
		return "MyCountryCategoryViewDAO [dbConnnection=" + dbConnnection + "]";
	}
	public LinkedList<MyCountryPreferenceViewVO> analyzingMyCountryPreference(String userCode){
		String countryCategoryCode=null;
		String countryCategoryName=null;
		int scoreTotal;
		
		LinkedList<MyCountryPreferenceViewVO> myCountryPreferenceList=new LinkedList<MyCountryPreferenceViewVO>();
		
		PreparedStatement pstmt = null;
		try
		{
			String sql ="select COUNTRY_CATEGORY_CODE,COUNTRY_CATEGORY_NAME,SCORE_TOTAL from (select COUNTRY_CATEGORY_CODE,COUNTRY_CATEGORY_NAME,SCORE_TOTAL from my_COUNTRY_preference_view where user_code=? order by score_total desc)";
			pstmt=dbConnnection.getConn().prepareStatement(sql);
			pstmt.setString(1,userCode);
			
			//pstmt.setInt(4, scoreTotal);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				countryCategoryCode = rs.getString("COUNTRY_CATEGORY_CODE");
				//System.out.println(kindCategoryName);
				countryCategoryName=rs.getString("COUNTRY_CATEGORY_NAME");
				scoreTotal=rs.getInt("score_total");
				myCountryPreferenceList.add(new MyCountryPreferenceViewVO(countryCategoryCode,countryCategoryName,scoreTotal));
				
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
		return myCountryPreferenceList;
	}
	
	public static void main(String args[]){
		MyCountryPreferenceViewDAO list=MyCountryPreferenceViewDAO.getInstance();
		
		LinkedList<MyCountryPreferenceViewVO> arr=list.analyzingMyCountryPreference("UT001");
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i));
		}
	}
	
	
	
		 
	

}
