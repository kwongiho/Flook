package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import Connection.DBConnection;
import ViewVO.ScrapViewVO;

public class ScrapViewDAO {

   static final private ScrapViewDAO obj;
   private DBConnection conn;
   static
   {
      obj=new ScrapViewDAO();
   }
   
   private ScrapViewDAO()
   {
      conn=DBConnection.getInstance();
      
   }
   public static ScrapViewDAO getInstance()
   {
      return obj;
   }
   public LinkedList<ScrapViewVO> requestMyScrapList(String userCode)
   {
      LinkedList<ScrapViewVO> scrapViewVOList = new LinkedList<ScrapViewVO>();
      PreparedStatement pstmt = null;
      try {
         String sql = "select * from scrap_view where user_code=?";
         pstmt = conn.getConn().prepareStatement(sql);
         pstmt.setString(1,userCode);
         ResultSet res = pstmt.executeQuery();
         while(res.next()) {
            String recipeDescription = res.getString("recipe_description");
            scrapViewVOList.add(new ScrapViewVO(res
                  .getString("scrap_Code"), res
                  .getString("post_Code"), res
                  .getString("recipe_Code"), res
                  .getString("user_code"),res
                  .getString("user_name"),res
                  .getString("complete_image"),res
                  .getString("recipe_name"), recipeDescription.substring(0,recipeDescription.length()/2)+"...(»ý·«)", res
                  .getInt("like_count"),res
                  .getInt("post_hits"), res
                  .getString("scrap_date")));
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
      return scrapViewVOList;
   }
}