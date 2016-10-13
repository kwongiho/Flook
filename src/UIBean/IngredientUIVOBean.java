package UIBean;
/**
 * 구현을 위해 만든 빈입니다.
 * UIBean변경시 modify영향줘서 ㅠ
 * 나중에 삭제하고 리팩토링 하십쇼.
 * ※해당 클래스 API작성자는 팀원들에게 API주석 삭제하기 전에 이 사실을 통보할것.
 * @author GHKwon
 *
 */
public class IngredientUIVOBean extends IngredientUIBean{
	private String ingredientName;
	private int ingredientAmount;
	private String ingredientUnit;
	private String ingredientCode;
	public IngredientUIVOBean() {
		super();
	}
	public IngredientUIVOBean(String ingredientName, int ingredientAmount,
			String ingredientUnit, String ingredientCode) {
		super();
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.ingredientUnit = ingredientUnit;
		this.ingredientCode = ingredientCode;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public int getIngredientAmount() {
		return ingredientAmount;
	}
	public void setIngredientAmount(int ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}
	public String getIngredientUnit() {
		return ingredientUnit;
	}
	public void setIngredientUnit(String ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}
	public String getIngredientCode() {
		return ingredientCode;
	}
	public void setIngredientCode(String ingredientCode) {
		this.ingredientCode = ingredientCode;
	}
	@Override
	public String toString() {
		return "IngredientUIVOBean [ingredientName=" + ingredientName
				+ ", ingredientAmount=" + ingredientAmount
				+ ", ingredientUnit=" + ingredientUnit + ", ingredientCode="
				+ ingredientCode + "]";
	}
	
}
