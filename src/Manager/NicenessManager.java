package Manager;

import DAO.NicenessDAO;
import DAO.PostDAO;
import VO.NicenessVO;
import ViewDAO.PostNicenessOutlineViewDAO;

public class NicenessManager { 
	private NicenessDAO nicenessDAO;
	private PostDAO postDAO;
	private PostNicenessOutlineViewDAO postNicenessOutlineViewDAO;
	
	public NicenessManager()
	{
		nicenessDAO=NicenessDAO.getInstance();
		postDAO=PostDAO.getInstance();
		postNicenessOutlineViewDAO=PostNicenessOutlineViewDAO.getInstance();
	}
	public int changeNiceness(String userCode,String postCode)
	{
		if(nicenessDAO.searchNiceness(userCode, postCode)==null)
		{
			return nicenessDAO.insertNiceness(userCode, postCode);
		}
		else
		{
			return nicenessDAO.deleteNiceness(userCode, postCode);
		}
	}
	/*public int insertNiceness(String userCode,String postCode)
	{ 
		return nicenessDAO.insertNiceness(userCode, postCode);
	}*/
	public int insertNiceness(String userCode,String postCode)
	{ 
		int check=0;
		check=nicenessDAO.insertNiceness(userCode, postCode);
		System.out.println("insertÈ®ÀÎ"+check);
		if(check>0){
		int niceCount=postNicenessOutlineViewDAO.searchRecipeCount(postCode);
		System.out.println("niceCount"+niceCount);
			return postDAO.refreshNiceness(postCode,niceCount);
		}
		else{
			return 0;
		} 
		
	}
	public int deleteNiceness(String userCode,String postCode)
	{
		return nicenessDAO.deleteNiceness(userCode, postCode);
	}
	public NicenessVO searchNiceness(String userCode,String postCode)
	{
		return nicenessDAO.searchNiceness(userCode, postCode);
	}
}
