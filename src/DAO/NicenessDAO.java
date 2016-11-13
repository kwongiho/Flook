package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

import Connection.DBConnection;
import VO.NicenessVO;

public class NicenessDAO {
	private DBConnection dbConnection;
	private static NicenessDAO dao=new NicenessDAO();
	
	public NicenessDAO() {
		// TODO Auto-generated constructor stub
		dbConnection=DBConnection.getInstance();
		
	}
	public static NicenessDAO getInstance()
	{
		return dao;
	}
	public int insertNiceness(String userCode,String postCode)
	{
		PreparedStatement pstmt=null;
		String nicenessCode=codeGenerator2();
		
		int row=0;
		
		try
		{
			String sql="INSERT INTO niceness_tb VALUES(?,?,?,sysdate)";
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,nicenessCode);//�ڵ�����ʿ�
			pstmt.setString(2,userCode);
			pstmt.setString(3,postCode); 

			row=pstmt.executeUpdate();
			System.out.println("isCheck");
			
			if(row!=0)
				conn.commit();  
		}
		
		catch(SQLException se)
		{
				se.printStackTrace();
			//se.stackTracePrint();
		}
		catch(Exception e)
		{
				System.out.println(e.getMessage());
			//e.stackTracePrint();
		}
		finally
		{
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(SQLException se)
				{
					System.out.println(se.getMessage());
					//se.stackTracePrint();
				}
			}
		}

		return row;
	}

	public int deleteNiceness(String userCode,String postCode)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "delete from niceness_tb where NICENESS_USER_CODE=? AND post_code = ?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, userCode);
			pstmt.setString(2, postCode);

			rowNum = pstmt.executeUpdate();
			if (rowNum != 0)
				dbConnection.getConn().commit();
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	public NicenessVO searchNiceness(String userCode,String postCode)
	{
		PreparedStatement pstmt=null;
		NicenessVO nicenessVO=null;
		  
		try {
			String sql = "SELECT * FROM niceness_tb WHERE niceness_user_code=? AND post_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode); 
			pstmt.setString(2, postCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {  
				String nicenessCode=rs.getString("niceness_code");
				String nicenessDate=rs.getString("niceness_DATE");
				nicenessVO=new NicenessVO(nicenessCode, userCode, postCode, nicenessDate);		
			}
		} catch (Exception se) {
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
		return nicenessVO; 
	}
	
	public LinkedList<String> searchTodayPostCode(String today){
		/*select post_code,count,rownum
		from(
		select post_code,count(*) count
		from niceness_tb
		WHERE NICENESS_DATE='15/08/09'
		group by post_code
		)
		WHERE rownum<2*/
		PreparedStatement pstmt=null;
		/*NicenessVO nicenessVO=null;*/
		LinkedList<String> stringList=new LinkedList<String>();
		  
		try {
			String sql = "select post_code,count,rownum from(select post_code,count(*) countfrom niceness_tb WHERE NICENESS_DATE=?'group by post_code) WHERE rownum<7";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, today); 
			/*pstmt.setString(2, postCode); */

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {  
				String temp=rs.getString("post_code");
				/*String nicenessDate=rs.getString("niceness_DATE");*/
				stringList.add(temp);//=new NicenessVO(nicenessCode, userCode, postCode, nicenessDate);
				if(stringList.size()==6)//����ȭ�鿡�� ������ ��õ�� 6���ϱ� 6���Ǹ� ����
					return stringList;
			}
		} catch (Exception se) {
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
		return stringList; 
		
	}
	public String codeGenerator2(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		Random randomGenerator = new Random(); 
		return dTime+"NT"+randomGenerator.nextInt(1000)+System.currentTimeMillis();
	}
	public static void main(String[] args) {
		NicenessDAO dao=NicenessDAO.getInstance();
		//System.out.println(dao.insertNiceness("UT1439032038247", "0201UP1438933708771"));
		System.out.println(dao.insertNiceness("UT1438928667977", "0201UP1439037912233"));
		//System.out.println(dao.deleteNiceness("UT1439032038247", "0201UP1438933708771"));
		System.out.println(dao.searchNiceness("UT1439032038247", "0201UP1438933708771"));
	}
}
