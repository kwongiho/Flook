package Manager;

import java.util.LinkedList;

import ViewDAO.MyCountryPreferenceViewDAO;
import ViewDAO.MyIngredientPreferenceViewDAO;
import ViewDAO.MyKindPreferenceViewDAO;
import ViewDAO.MyMethodPreferenceViewDAO;
import ViewDAO.MySituationPreferenceViewDAO;
import ViewVO.MyCountryPreferenceViewVO;
import ViewVO.MyIngredientPreferenceViewVO;
import ViewVO.MyKindPreferenceViewVO;
import ViewVO.MyMethodPreferenceViewVO;
import ViewVO.MySituationPreferenceViewVO;

public class ProfileAnalyzingManager {
	private MyIngredientPreferenceViewDAO myIngredientPreferenceviewDAO;
	private MyKindPreferenceViewDAO myKindPreferenceViewDAO;
	private MyMethodPreferenceViewDAO myMethodPreferenceViewDAO;
	private MySituationPreferenceViewDAO mySituationPreferenceViewDAO;
	private MyCountryPreferenceViewDAO myCountryPreferenceViewDAO;
	public ProfileAnalyzingManager() {
		// TODO Auto-generated constructor stub
		this.myIngredientPreferenceviewDAO=MyIngredientPreferenceViewDAO.getInstance();
		this.myKindPreferenceViewDAO= MyKindPreferenceViewDAO.getInstance();
		this.myMethodPreferenceViewDAO= MyMethodPreferenceViewDAO.getInstance();
		this.mySituationPreferenceViewDAO= MySituationPreferenceViewDAO.getInstance();
		this.myCountryPreferenceViewDAO= MyCountryPreferenceViewDAO.getInstance();
		
	}
	public ProfileAnalyzingManager(
			MyIngredientPreferenceViewDAO myIngredientPreferenceviewDAO,
			MyKindPreferenceViewDAO myKindPreferenceViewDAO,
			MyMethodPreferenceViewDAO myMethodPreferenceViewDAO,
			MySituationPreferenceViewDAO mySituationPreferenceViewDAO,
			MyCountryPreferenceViewDAO myCountryPreferenceViewDAO) {
		this.myIngredientPreferenceviewDAO = myIngredientPreferenceviewDAO;
		this.myKindPreferenceViewDAO = myKindPreferenceViewDAO;
		this.myMethodPreferenceViewDAO = myMethodPreferenceViewDAO;
		this.mySituationPreferenceViewDAO = mySituationPreferenceViewDAO;
		this.myCountryPreferenceViewDAO = myCountryPreferenceViewDAO;
	}
	public String toString() {
		return "ProfileAnalyzingManager [myIngredientPreferenceviewDAO="
				+ myIngredientPreferenceviewDAO + ", myKindPreferenceViewDAO="
				+ myKindPreferenceViewDAO + ", myMethodPreferenceViewDAO="
				+ myMethodPreferenceViewDAO + ", mySituationPreferenceViewDAO="
				+ mySituationPreferenceViewDAO
				+ ", myCountryPreferenceViewDAO=" + myCountryPreferenceViewDAO
				+ "]";
	}
	public LinkedList<MyCountryPreferenceViewVO> analyzingMyCountryPreference(String userCode){
		return myCountryPreferenceViewDAO.analyzingMyCountryPreference(userCode);
		
	}
	public LinkedList<MyIngredientPreferenceViewVO> analyzingMyIngredientPreference(String userCode){
		return myIngredientPreferenceviewDAO.analyzingMyIngredientPreference(userCode);
		
	}
	public LinkedList<MyKindPreferenceViewVO> analyzingMyKindPreference(String userCode){
		return myKindPreferenceViewDAO.analyzingMyKindPreference(userCode);
	}
	public LinkedList<MyMethodPreferenceViewVO> analyzingMyMethodPreference(String userCode){
		return myMethodPreferenceViewDAO.analyzingMyMethodPreference(userCode);
	}
	public LinkedList<MySituationPreferenceViewVO> analyzingMySituationPreference(String userCode){
		return mySituationPreferenceViewDAO.analyzingMySituationPreference(userCode); 
	}

}
