package Calculate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

import ViewVO.MyCountryPreferenceViewVO;
import ViewVO.MyIngredientPreferenceViewVO;
import ViewVO.MyMethodPreferenceViewVO;

public class CalculatePercent {
	private int countryTotalScore;
	private int ingredientTotalScore;
	private int methodTotalScore;
	
	public CalculatePercent(LinkedList<MyCountryPreferenceViewVO> countryList,LinkedList<MyIngredientPreferenceViewVO> ingredientList,LinkedList<MyMethodPreferenceViewVO> methodList)
	{
		countryTotalScore=calculateCountryScore(countryList);
		ingredientTotalScore=calculateIngredientScore(ingredientList);
		methodTotalScore=calculateMethodScore(methodList);
		//System.out.println("totalScore"+totalScore);
		
	}
	public int calculateCountryScore(LinkedList<MyCountryPreferenceViewVO> countryList){
		int totalScore=0;
		for(int i=0;i<countryList.size();i++){
			totalScore+=countryList.get(i).getScoreTotal();
		}
		
		
		return totalScore;
	}
	public int calculateIngredientScore(LinkedList<MyIngredientPreferenceViewVO> ingredientList){
		int totalScore=0;
		for(int i=0;i<ingredientList.size();i++){
			totalScore+=ingredientList.get(i).getScoreTotal();
		}
		return totalScore;
	}
	public int calculateMethodScore(LinkedList<MyMethodPreferenceViewVO> methodList){
		int totalScore=0;
		for(int i=0;i<methodList.size();i++){
			totalScore+=methodList.get(i).getScoreTotal();
		}
		return totalScore;
	}
	public LinkedList<String> calculateCountryPercent(LinkedList<MyCountryPreferenceViewVO> countryList)
	{
		//int totalScore=0;
		LinkedList<String> stringArr=new LinkedList<String>();
		for(int i=0;i<countryList.size();i++){
			//totalScore+=countryList.get(i).getScoreTotal();
			System.out.println("scorescore"+countryList.get(i).getScoreTotal());
			stringArr.add((int)((countryList.get(i).getScoreTotal()/(double)countryTotalScore)*100)+"");
		}
		//int percent=0;
	/*	for(int i=0;i<countryList.size();i++){
			
		}*/
		return stringArr;

	}
	public LinkedList<String> calculateIngredientPercent(LinkedList<MyIngredientPreferenceViewVO> ingredientList)
	{
		//int totalScore=0;
		LinkedList<String> stringArr=new LinkedList<String>();
		for(int i=0;i<ingredientList.size();i++){
			//totalScore+=ingredientList.get(i).getScoreTotal();
			/*stringArr.add(totalScore/ingredientList.get(i).getScoreTotal()+"%");*/
			stringArr.add((int)((ingredientList.get(i).getScoreTotal()/(double)ingredientTotalScore)*100)+"");
		}
		//int percent=0;
		/*for(int i=0;i<ingredientList.size();i++){
			stringArr.add(totalScore/ingredientList.get(i).getScoreTotal()+"%");
		}*/
		return stringArr;

	}
	public LinkedList<String> calculateMethodPercent(LinkedList<MyMethodPreferenceViewVO> methodList)
	{
		//int totalScore=0;
		LinkedList<String> stringArr=new LinkedList<String>();
		/*for(int i=0;i<methodList.size();i++){
			totalScore+=methodList.get(i).getScoreTotal();
		}*/
		//int percent=0;
		/*for(int i=0;i<methodList.size();i++){
			stringArr.add(totalScore/methodList.get(i).getScoreTotal()+"%");
		}*/
		for(int i=0;i<methodList.size();i++){
			//totalScore+=ingredientList.get(i).getScoreTotal();
			/*stringArr.add(totalScore/ingredientList.get(i).getScoreTotal()+"%");*/
			stringArr.add((int)((methodList.get(i).getScoreTotal()/(double)methodTotalScore)*100)+"");
		}
		return stringArr;

	}
	public static void main(String args[]){
		
	}
	public String codeGenerator(){
		return "0101UR"+System.currentTimeMillis();
	}
	public String codeGenerator2(){
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		Date currentTime = new Date( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime );
		
		return dTime+"UT"+System.currentTimeMillis();
	}
	

}
