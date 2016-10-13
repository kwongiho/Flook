package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

import Connection.DBConnection;
import VO.CommentVO;
import ViewVO.CommentViewVO;
/**
 * 싱글톤이 적용된 CommentDAO 클래스.
 * Comment_tb에 접근하며 data를 handling한다.
 * @author GHKwon
 *
 */
public class CommentDAO {
	private final static CommentDAO commentDAO;
	private DBConnection conn;
	static {
		commentDAO = new CommentDAO();
	}
	private CommentDAO(){
		this(DBConnection.getInstance());
	}
	private CommentDAO(DBConnection conn) {
		this.conn=conn;
	}
	public static CommentDAO getInstance() {
		return commentDAO;
	}
	/**
	 * 게시글 작성 메소드.
	 * 게시글 작성이 성공하면 1을, 실패하면 0을 반환한다.
	 * @param userCode 댓글을 작성한 사용자의 식별코드.
	 * @param commentString 댓글 내용.
	 * @param postCode 댓글이 작성된 게시글의 식별코드
	 * @return 댓글 작성 성공여부.
	 */
	public CommentVO writeComment(String userCode,String commentString,String postCode) {
		PreparedStatement pstmt = null ;
		try {
			String sql = "insert into comment_tb (comment_code,comment_user_code,comment_contents,post_code,comment_date) values(?,?,?,?,sysdate)";
			pstmt = conn.getConn().prepareStatement(sql);
			String commentCode = codeGenerator2();
			pstmt.setString(1, commentCode);
			pstmt.setString(2, userCode);
			pstmt.setString(3, commentString);
			pstmt.setString(4,postCode);
			if(pstmt.executeUpdate()==1) 
				return searchCommentVOByCommentCode(commentCode);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.getConn().commit();
				conn.getConn().rollback();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 댓글의 식별코드를 생성해주는 메소드. 현재 날자+CO+현재 시간 밀리세컨드로 구성되어 String으로 반환한다.
	 * @return CommentCode
	 */
	/*public String codeGenerator2(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		
		return dTime+"CO"+System.currentTimeMillis();
	}*/
	public String codeGenerator2(){
	      SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
	      Date currentTime = new Date( );
	      String dTime = formatter.format ( currentTime );
	      Random randomGenerator = new Random(); 
	      return dTime+"CO"+randomGenerator.nextInt(1000)+System.currentTimeMillis();
	}
	public CommentVO searchCommentVOByCommentCode(String commentCode) {
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from comment_tb where comment_code = ?";
			pstmt = conn.getConn().prepareStatement(sql);
			pstmt.setString(1, commentCode);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				return new CommentVO(res.getString("comment_Code"), res.getString("comment_User_Code"), res.getString("comment_Contents"), res.getString("comment_Date"), res.getString("post_Code"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.getConn().commit();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	public int deleteComment(String commentCode) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from comment_tb where comment_code = ?";
			pstmt = conn.getConn().prepareStatement(sql);
			pstmt.setString(1, commentCode);
			if(pstmt.executeUpdate()==1) {
				conn.getConn().commit();
				return 1;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally 
		{
			try 
			{
				pstmt.close();
				conn.getConn().rollback();
			}
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
		}
		return 0;
	}
	/*
	 * 얘 원래 여기있으면 안됨.. 나중에 수정해야함
	 * @param args
	 */
	public LinkedList<CommentViewVO> searchComment(String reicpeCode) {
		PreparedStatement pstmt = null;
		LinkedList<CommentViewVO> list=new LinkedList<CommentViewVO>();
		try {
			String sql = "select * from comment_view where recipe_code=?";
			pstmt  = conn.getConn().prepareStatement(sql);
			pstmt.setString(1, reicpeCode);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				list.add(new CommentViewVO(res.getString("comment_Code"),res.getString("comment_User_Code"),res.getString("user_Name"),res.getString("user_Image"),res.getString("comment_Contents"),res.getString("comment_Date"),res.getString("post_Code"),res.getString("recipe_Code")));
			}
			return list;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				conn.getConn().commit();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void main(String[]args) {
		System.out.println(CommentDAO.getInstance().codeGenerator2());
	}
	
}
