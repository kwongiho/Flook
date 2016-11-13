package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.CartManager;
import ViewVO.CartViewVO;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String cartKindOf = request.getParameter("cartKindOf");
		CartManager cartManager = new CartManager();
		String userCode = (String)request.getSession().getAttribute("userCode");
		if(cartKindOf.equals("readOnly")) {/*네비바 상단 버튼 클릭 시.*/
			ArrayList<CartViewVO> cartList = cartManager.searchUserCode(userCode);
			/*ArrayList<CartViewVO> cartList2 = (ArrayList<CartViewVO>)request.getAttribute("cartList");
			System.out.println("cartList 1 =" +cartList);
			System.out.println("cartList 2 =" + cartList2);
			if( cartList2 != null ) {
				System.out.println("????");
				for(int i=0;i<=cartList.size();i++) { // 같은 data 두개 안뜨게 하기 위해서.
					for(int j=0;j<=cartList2.size();j++) {
						if(cartList.get(i).getIngredientCode().equals(cartList2.get(j).getIngredientCode())) 
						{
							System.out.println("i - j ="+i+" - "+j);
							System.out.println(cartList.get(i).getIngredientCode());
							System.out.println(cartList2.get(j).getIngredientCode());
							cartList.remove(i);
							
						}
					}
				}
			}*/
			request.setAttribute("cartList", cartList);
			request.getRequestDispatcher("cartFactory.jsp").forward(request,response);
			
		} else if ( cartKindOf.equals("addCart")) { /*추가시*/
			/*String ingredientCode = request.getParameter("ingredientCode");*/
			cartManager.insertCart(userCode, request.getParameter("ingredientCode"));
			
		} else if ( cartKindOf.equals("deleteCart")) { /*삭제시*/
			cartManager.deleteCart(userCode, request.getParameter("ingredientCode"));
		}
	}

}
/*${mainIngredient.ingredientName }
												/${mainIngredient.ingredientAmount }/${mainIngredient.ingredientUnit }*/