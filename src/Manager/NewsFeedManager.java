package Manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import ViewDAO.FollowCommentRecipeViewDAO;
import ViewDAO.FollowLikeRecipeViewDAO;
import ViewDAO.FollowScrapViewDAO;
import ViewDAO.FollowWrittenRecipeViewDAO;
import ViewDAO.NewsfeedLatestOrderViewDAO;
import ViewVO.FollowCommentRecipeViewVO;
import ViewVO.FollowLikeRecipeViewVO;
import ViewVO.FollowScrapViewVO;
import ViewVO.FollowWrittenRecipeViewVO;
import ViewVO.NewsfeedLatestOrderViewVO;

public class NewsFeedManager {
	private NewsfeedLatestOrderViewDAO newsFeedLatestOrderViewDAO;
	private FollowLikeRecipeViewDAO followLikeRecipeViewDAO;
	private FollowWrittenRecipeViewDAO followWrittenRecipeViewDAO;
	private FollowScrapViewDAO followScrapViewDAO;
	private FollowCommentRecipeViewDAO followCommentRecipeViewDAO;

	public NewsFeedManager() {
		this.newsFeedLatestOrderViewDAO = NewsfeedLatestOrderViewDAO.getInstance();
		this.followLikeRecipeViewDAO = FollowLikeRecipeViewDAO.getInstance();
	}

	// public requestNewsFeedList(){}
	public ArrayList<NewsfeedLatestOrderViewVO> requestLatestOrder(String userCode) {
		ArrayList<NewsfeedLatestOrderViewVO> array = this.newsFeedLatestOrderViewDAO.searchNewsfeedInLatestOrder(0);
		return array; 
	}

	public ArrayList<FollowLikeRecipeViewVO> requestPopularOrder(String userCode) {
		/*HashMap<String, FollowLikeRecipeViewVO> likeMap = followLikeRecipeViewDAO.searchNewsFeedPopularOrder(null);
		HashMap<String, FollowWrittenRecipeViewVO> writtenMap = followWrittenRecipeViewDAO
				.searchFollowWrittenRecipe(null);
		HashMap<String, FollowScrapViewVO> scrapMap = followScrapViewDAO.searchFollowScrap(null);
		HashMap<String, FollowCommentRecipeViewVO> commentMap = followCommentRecipeViewDAO
				.searchFollowCommentRecipe(null);

		ArrayList<Object> popularPosts = sort(likeMap, writtenMap, scrapMap, commentMap);
		return popularPosts;*/
		ArrayList<FollowLikeRecipeViewVO> likeMap = this.followLikeRecipeViewDAO.searchNewsFeedPopularOrder(userCode);
		return likeMap;
	}

	/*private ArrayList<Object> sort(HashMap<String, FollowLikeRecipeViewVO> likeMap,
			HashMap<String, FollowWrittenRecipeViewVO> writtenMap, HashMap<String, FollowScrapViewVO> scrapMap,
			HashMap<String, FollowCommentRecipeViewVO> commentMap) {
		ArrayList<Object> popularPosts = new ArrayList<Object>();

		for (int i = 0; i < likeMap.size(); i++) {
			popularPosts.add(likeMap.get(i + 1 + ""));
		}
		for (int i = 0; i < writtenMap.size(); i++) {
			popularPosts.add(writtenMap.get(i + 1 + ""));
		}
		for (int i = 0; i < scrapMap.size(); i++) {
			popularPosts.add(scrapMap.get(i + 1 + ""));
		}
		for (int i = 0; i < commentMap.size(); i++) {
			popularPosts.add(commentMap.get(i + 1 + ""));
		}

		
		//확인
		for(int i=0; i<popularPosts.size(); i++)
		{
			popularPosts.get(i).getClass().
			
		}
		return radixsort(popularPosts);
	}
*/
	/*
	 * StringTokenizer stok = new
	 * StringTokenizer(map.get(1+"").getNicenessDate(),"-:.");
	 * while(stok.hasMoreTokens()) { String str = stok.nextToken();
	 * System.out.println(str); }
	 */

	/*private ArrayList<Object> radixsort(ArrayList<Object> arrayPosts)
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		ArrayList<Object> linedUpArray = new ArrayList<Object>();*/
		
		/*
		 * 초기값 세팅
		 */
		/*Date minDate = null;
		HashMap<Date, Object> map = new HashMap<Date, Object>();
		
		if(arrayPosts.get(0) instanceof FollowLikeRecipeViewVO)
		{
			try {
				minDate = formatter.parse(((FollowLikeRecipeViewVO)arrayPosts.get(0)).getNicenessDate());
				map.put(minDate, arrayPosts.get(0));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(arrayPosts.get(0) instanceof FollowWrittenRecipeViewVO)
		{
			try {
				minDate = formatter.parse(((FollowWrittenRecipeViewVO)arrayPosts.get(0)).getFollowPostDate());
				map.put(minDate, arrayPosts.get(0));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(arrayPosts.get(0) instanceof FollowScrapViewVO)
		{
			try {
				minDate = formatter.parse(((FollowScrapViewVO)arrayPosts.get(0)).getScrapDate());
				map.put(minDate, arrayPosts.get(0));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(arrayPosts.get(0) instanceof FollowCommentRecipeViewVO)
		{
			try {
				minDate = formatter.parse(((FollowCommentRecipeViewVO)arrayPosts.get(0)).getCommentDate());
				map.put(minDate, arrayPosts.get(0));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		
		/*
		 * 값 비교
		 */
		/*for(int j=1; j<arrayPosts.size(); j++)
		{
			for(int i=j; i<arrayPosts.size(); i++)
			{
				Date date = null;
				if(arrayPosts.get(i) instanceof FollowLikeRecipeViewVO)
				{
					try {
						date = formatter.parse(((FollowLikeRecipeViewVO)arrayPosts.get(i)).getNicenessDate());
						if(date.compareTo(minDate)<0)
						{
							minDate = date;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(arrayPosts.get(i) instanceof FollowWrittenRecipeViewVO)
				{
					try {
						date = formatter.parse(((FollowWrittenRecipeViewVO)arrayPosts.get(i)).getFollowPostDate());
						if(date.compareTo(minDate)<0)
						{
							minDate = date;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(arrayPosts.get(i) instanceof FollowScrapViewVO)
				{
					try {
						date = formatter.parse(((FollowScrapViewVO)arrayPosts.get(i)).getScrapDate());
						if(date.compareTo(minDate)<0)
						{
							minDate = date;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(arrayPosts.get(i) instanceof FollowCommentRecipeViewVO)
				{
					try {
						date = formatter.parse(((FollowCommentRecipeViewVO)arrayPosts.get(i)).getCommentDate());
						if(date.compareTo(minDate)<0)
						{
							minDate = date;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			linedUpArray.add(minDate);
		}
		return linedUpArray;*/
		
		
		
		
		
		
		
		
		/*for(int i=0; i<arrayPosts.size(); i++)
		{
			int cnt=1;
			if(arrayPosts.get(i) instanceof FollowLikeRecipeViewVO)
			{
				((FollowLikeRecipeViewVO)arrayPosts.get(i)).getNicenessDate();
			}
			else if(arrayPosts.get(i) instanceof FollowWrittenRecipeViewVO)
			{
				
			}
			else if(arrayPosts.get(i) instanceof FollowScrapViewVO)
			{
				
			}
			else if(arrayPosts.get(i) instanceof FollowCommentRecipeViewVO)
			{
				
			}
		}
	}*/

	public static void main(String[] args) {
		NewsFeedManager manager = new NewsFeedManager();
		ArrayList<FollowLikeRecipeViewVO> map = manager.requestPopularOrder(null);
		for (int i = 0; i < map.size(); i++) {
			System.out.println(map.get(i).getNicenessDate());
		}
	}
}
