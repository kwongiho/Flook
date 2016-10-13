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
import VO.CartVO;

public class CartDAO {
	private DBConnection dbConnection;
	private static CartDAO dao=new CartDAO();
	
	private CartDAO() {
		// TODO Auto-generated constructor stub
		dbConnection=DBConnection.getInstance();
	}
	public static CartDAO getInstance()
	{
		return dao;	
	}
	public int insertCart(String userCode,String ingredientCode)
	{
		PreparedStatement pstmt=null;
		String cartCode=codeGenerator2();
		
		int row=0;
		
		try
		{
			String sql="INSERT INTO cart_tb VALUES(?,?,?)";
			Connection conn = dbConnection.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,cartCode);//코드생성필요
			pstmt.setString(2,userCode);
			pstmt.setString(3,ingredientCode); 

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
					dbConnection.getConn().commit();
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
	public int deleteCart(String userCode,String ingredientCode)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try {

			String sql = "delete from cart_tb where USER_CODE=? AND INGREDIENT_CODE = ?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, userCode);
			pstmt.setString(2, ingredientCode);

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
					dbConnection.getConn().commit();
					pstmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	} 
	public CartVO searchCart(String userCode,String ingredientCode)
	{
		PreparedStatement pstmt=null;
		CartVO cartVO=null;
		  
		try {
			String sql = "SELECT * FROM cart_tb WHERE USER_CODE=? AND INGREDIENT_CODE = ?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode); 
			pstmt.setString(2, ingredientCode); 

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {  
				String cartCode=rs.getString("CART_CODE"); 
				cartVO=new CartVO(cartCode, userCode, ingredientCode);	
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
		return cartVO;
	}

	public LinkedList<CartVO> searchCartList(String userCode)
	{
		PreparedStatement pstmt=null; 
		LinkedList<CartVO> cartList =new LinkedList<CartVO>();
		  
		try {
			String sql = "SELECT * FROM cart_tb WHERE user_code=?";
			Connection conn = dbConnection.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCode);  

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {  
				String cartCode=rs.getString("CART_CODE"); 
				String ingredientCode=rs.getString("INGREDIENT_CODE");
				CartVO cartVO = new CartVO(cartCode, userCode, ingredientCode);
				cartList.add(cartVO);
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
		return cartList;
	}
	public String codeGenerator2(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		Random randomGenerator = new Random(); 
		return dTime+"CA"+randomGenerator.nextInt(1000)+System.currentTimeMillis();
	}
	public static void main(String[] args) {
		CartDAO dao=CartDAO.getInstance();
		dao.insertCart("UT1439032038247", "0301MI1438933708830");
		dao.deleteCart("UT1439032038247", "0301MI1438933708830");
		
		//System.out.println(dao.searchCart("UT1439032038247", "0301MI1438933708830"));
	}
}
