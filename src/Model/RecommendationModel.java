package Model;

import java.util.LinkedList;

import ViewVO.SimpleUserRecipeViewVO;

public class RecommendationModel {
	//나중에 Flook레시피로 바꿔야한다.
	LinkedList<SimpleUserRecipeViewVO> countryList;
	LinkedList<SimpleUserRecipeViewVO> situationList;
	LinkedList<SimpleUserRecipeViewVO> methodList;
	LinkedList<SimpleUserRecipeViewVO> kindList;
	LinkedList<SimpleUserRecipeViewVO> ingredientList;
	public RecommendationModel() {
		countryList=new LinkedList<SimpleUserRecipeViewVO>();
		situationList=new LinkedList<SimpleUserRecipeViewVO>();
		methodList=new LinkedList<SimpleUserRecipeViewVO>();
		kindList=new LinkedList<SimpleUserRecipeViewVO>();
		ingredientList=new LinkedList<SimpleUserRecipeViewVO>();
	}
	public RecommendationModel(LinkedList<SimpleUserRecipeViewVO> coutryList,
			LinkedList<SimpleUserRecipeViewVO> situationList,
			LinkedList<SimpleUserRecipeViewVO> methodList,
			LinkedList<SimpleUserRecipeViewVO> kindList,
			LinkedList<SimpleUserRecipeViewVO> ingredientList) {
		this.countryList = coutryList;
		this.situationList = situationList;
		this.methodList = methodList;
		this.kindList = kindList;
		this.ingredientList = ingredientList;
	}
	public String toString() {
		return "RecommendationModel [coutryList=" + countryList
				+ ", situationList=" + situationList + ", methodList="
				+ methodList + ", kindList=" + kindList + ", ingredientList="
				+ ingredientList + "]";
	}
	public LinkedList<SimpleUserRecipeViewVO> filteringIngredient(LinkedList<SimpleUserRecipeViewVO> list,String firstIngredient,String secondIngredient){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getIngredientCategoryName().equals(firstIngredient)|| list.get(i).getIngredientCategoryName().equals(secondIngredient)){
				ingredientList.add(new SimpleUserRecipeViewVO(list.get(i).getPostCode(), list.get(i).getRecipeCode(),
						list.get(i).getUserCode(), list.get(i).getUserName(),
						list.get(i).getCompleteImage(), 
						list.get(i).getRecipeName(),
						list.get(i).getRecipeDescription(),
						list.get(i).getLikeCount(),
						list.get(i).getPostHits(),
						list.get(i).getCountryCategoryName(),
						list.get(i).getIngredientCategoryName(),
						list.get(i).getKindCategoryName(),
						list.get(i).getSituationCategoryName(),
						list.get(i).getMethodCategoryName()));
			}
		}
		return ingredientList;
	}
	public LinkedList<SimpleUserRecipeViewVO> filteringMethod(LinkedList<SimpleUserRecipeViewVO> list,String firstMethod,String secondMethod){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getMethodCategoryName().equals(firstMethod)|| list.get(i).getMethodCategoryName().equals(secondMethod)){
				methodList.add(new SimpleUserRecipeViewVO(list.get(i).getPostCode(), list.get(i).getRecipeCode(),
						list.get(i).getUserCode(), list.get(i).getUserName(),
						list.get(i).getCompleteImage(), 
						list.get(i).getRecipeName(),
						list.get(i).getRecipeDescription(),
						list.get(i).getLikeCount(),
						list.get(i).getPostHits(),
						list.get(i).getCountryCategoryName(),
						list.get(i).getIngredientCategoryName(),
						list.get(i).getKindCategoryName(),
						list.get(i).getSituationCategoryName(),
						list.get(i).getMethodCategoryName()));
			}
		}
		return methodList;
	}
	public LinkedList<SimpleUserRecipeViewVO> filteringCountry(LinkedList<SimpleUserRecipeViewVO> list,String firstCountry,String secondCountry){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getCountryCategoryName().equals(firstCountry)|| list.get(i).getCountryCategoryName().equals(secondCountry)){
				countryList.add(new SimpleUserRecipeViewVO(list.get(i).getPostCode(), list.get(i).getRecipeCode(),
						list.get(i).getUserCode(), list.get(i).getUserName(),
						list.get(i).getCompleteImage(), 
						list.get(i).getRecipeName(),
						list.get(i).getRecipeDescription(),
						list.get(i).getLikeCount(),
						list.get(i).getPostHits(),
						list.get(i).getCountryCategoryName(),
						list.get(i).getIngredientCategoryName(),
						list.get(i).getKindCategoryName(),
						list.get(i).getSituationCategoryName(),
						list.get(i).getMethodCategoryName()));
			}
		}
		return countryList;
	}

	
	public LinkedList<SimpleUserRecipeViewVO> filteringKind(LinkedList<SimpleUserRecipeViewVO> list,String firstKind,String secondKind){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getKindCategoryName().equals(firstKind)|| list.get(i).getKindCategoryName().equals(secondKind)){
				countryList.add(new SimpleUserRecipeViewVO(list.get(i).getPostCode(), list.get(i).getRecipeCode(),
						list.get(i).getUserCode(), list.get(i).getUserName(),
						list.get(i).getCompleteImage(), 
						list.get(i).getRecipeName(),
						list.get(i).getRecipeDescription(),
						list.get(i).getLikeCount(),
						list.get(i).getPostHits(),
						list.get(i).getCountryCategoryName(),
						list.get(i).getIngredientCategoryName(),
						list.get(i).getKindCategoryName(),
						list.get(i).getSituationCategoryName(),
						list.get(i).getMethodCategoryName()));
			}
		}
		return countryList;
	}


}
