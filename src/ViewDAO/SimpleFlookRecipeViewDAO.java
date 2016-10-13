package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import Connection.DBConnection;
import ViewVO.SimpleRecipeViewVO;

public class SimpleFlookRecipeViewDAO {

   final static SimpleFlookRecipeViewDAO obj;
   private DBConnection conn;
   static {
      obj = new SimpleFlookRecipeViewDAO();
   }

   private SimpleFlookRecipeViewDAO() {
      conn = DBConnection.getInstance();
   }

   public static SimpleFlookRecipeViewDAO getInstance() {
      return obj;
   }

   public LinkedList<SimpleRecipeViewVO> selectSimpleRecipe() {
      PreparedStatement pstmt = null;
      LinkedList<SimpleRecipeViewVO> list = null;
      try {
         String sql = "select * from simple_recipe_view where recipe_code like ?";
         pstmt = this.conn.getConn().prepareStatement(sql);
         pstmt.setString(1,"%F%");
         ResultSet rs = pstmt.executeQuery();

         list = new LinkedList<SimpleRecipeViewVO>();
         while (rs.next()) {
            list.add(new SimpleRecipeViewVO(rs
                  .getString("recipe_code"), rs
                  .getString("post_code"), rs.getString("complete_image"),rs
                  .getString("recipe_name"), rs
                  .getString("recipe_description"), rs
                  .getInt("like_count"), rs.getInt("post_hits"),rs
                  .getString("country_category_name"), rs
                  .getString("ingredient_category_name"), rs
                  .getString("kind_category_name"), rs
                  .getString("situation_category_name"), rs
                  .getString("method_category_name")));
         }
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
      return list;
      
   }
   public LinkedList<SimpleRecipeViewVO> searchFlookRecipeList(String mehtod,String situation,String nation,String ingredient,String kindOf) {
      PreparedStatement pstmt = null;
      LinkedList<SimpleRecipeViewVO> list = new LinkedList<SimpleRecipeViewVO>();
      try {
         String sql = "select * from simple_recipe_view where recipe_code like ? and method_category_name =? and situation_category_name =? and country_category_name =? and ingredient_category_name =? and kind_category_name = ?";
         pstmt = conn.getConn().prepareStatement(sql);
         pstmt.setString(1, "%F%");
         pstmt.setString(2, mehtod);
         pstmt.setString(3,situation);
         pstmt.setString(4,nation);
         pstmt.setString(5,ingredient);
         pstmt.setString(6, kindOf);
         ResultSet res = pstmt.executeQuery();
         while(res.next()) {
            list.add(new SimpleRecipeViewVO(res.getString("recipe_Code"),res.getString( "post_Code"),res.getString( "complete_Image"),res.getString(" recipe_Name"),res.getString(" recipe_Description"),res.getInt(" like_Count"),res.getInt("post_Hits"),res.getString("Country_Category_Name"),res.getString("Ingredient_Category_Name"),res.getString("Kind_Category_Name"),res.getString("Situation_Category_Name"),res.getString("Method_Category_Name")));
            System.out.println("while문 돌아감~~");
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
      return list;
   }
   public static void main(String[]args) {
      System.out.println(SimpleFlookRecipeViewDAO.getInstance().selectSimpleRecipe());
   }

}