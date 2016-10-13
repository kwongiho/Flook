package Manager;

import DAO.PostDAO;
import ViewDAO.PostNicenessOutlineViewDAO;
import ViewDAO.ProfileNicenessCountViewDAO;
import ViewVO.PostNicenessOutlineViewVO;

public class NicenessPostManager {
	private ProfileNicenessCountViewDAO profileNicenessCountViewDAO;
	//private ProfileWriteOutlineViewDAO profileWriteOutlineViewDAO;
	private PostDAO postDAO;
	private PostNicenessOutlineViewDAO postNicenessOutlineViewDAO;
	
	public NicenessPostManager() {
		// TODO Auto-generated constructor stub
		profileNicenessCountViewDAO=ProfileNicenessCountViewDAO.getInstance();
		postDAO=PostDAO.getInstance();
		postNicenessOutlineViewDAO=PostNicenessOutlineViewDAO.getInstance();
	}
	public NicenessPostManager(
			ProfileNicenessCountViewDAO profileNicenessCountViewDAO,
			PostDAO postDAO,
			PostNicenessOutlineViewDAO postNicenessOutlineViewDAO) {
		this.profileNicenessCountViewDAO = profileNicenessCountViewDAO;
		this.postDAO = postDAO;
		this.postNicenessOutlineViewDAO = postNicenessOutlineViewDAO;
	}
	
	public int searchProfileNicenessCount(String userCode)
	{
		return profileNicenessCountViewDAO.searchProfileNicenessCount(userCode);
	}
	public int searchRecipeCount(String userCode)
	{
		return postDAO.searchRecipeCount(userCode);
	}
	/*public PostNicenessOutlineViewVO searchPostNicenessCount(String postCode)
	{
		return postNicenessOutlineViewDAO.searchRecipeCount(postCode);
	}*/

}
