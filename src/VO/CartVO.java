package VO;

import java.io.Serializable;

public class CartVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6879021549414587260L;
	private String cartCode;
	private String userCode;
	private String ingredientCode;
	public CartVO() {
		// TODO Auto-generated constructor stub
	}
	public CartVO(String cartCode, String userCode, String ingredientCode) {
		this.cartCode = cartCode;
		this.userCode = userCode;
		this.ingredientCode = ingredientCode;
	}
	public String getCartCode() {
		return cartCode;
	}
	public void setCartCode(String cartCode) {
		this.cartCode = cartCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getIngredientCode() {
		return ingredientCode;
	}
	public void setIngredientCode(String ingredientCode) {
		this.ingredientCode = ingredientCode;
	}
	@Override
	public String toString() {
		return "CartVO [cartCode=" + cartCode + ", userCode=" + userCode
				+ ", ingredientCode=" + ingredientCode + "]";
	}

}
