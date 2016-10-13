package Manager;

import java.util.LinkedList;

import DAO.ScrapDAO;
import ViewDAO.ScrapViewDAO;
import ViewVO.ScrapViewVO;

public class MyScrapManager {

	private ScrapViewDAO scrapViewDAO;
	private ScrapDAO scrapDAO;
	
	public MyScrapManager()
	{
		this.scrapViewDAO=ScrapViewDAO.getInstance();
	}
	public LinkedList<ScrapViewVO> requestMyScrapList(String userCode)
	{
		return scrapViewDAO.requestMyScrapList(userCode);
	}
}
