package Manager;

import java.util.ArrayList;
import java.util.LinkedList;

import DAO.FollowDAO;
import VO.FollowVO;
import ViewDAO.FollowerViewDAO;
import ViewDAO.FollowingViewDAO;
import ViewVO.FollowerViewVO;
import ViewVO.FollowerViewWithFollowingOrNotVO;
import ViewVO.FollowingViewVO;

//여기서 팔로잉/팔로워 목록 다 보여주자
public class FollowManager {
	private FollowerViewDAO followerViewDAO;
	private FollowingViewDAO followingViewDAO;
	private FollowDAO followDAO;
	
	public FollowManager()
	{
		this.followerViewDAO = FollowerViewDAO.getInstance();
		this.followingViewDAO = FollowingViewDAO.getInsatance();
		this.followDAO=FollowDAO.getInstance();
	}
	
	//내가 팔로우 하는 사람들(팔로잉)
	public ArrayList<FollowingViewVO> requestFollowingList(String userCode)
	{
		ArrayList<FollowingViewVO> followingArray = this.followingViewDAO.requestFollowingList(userCode);
		return followingArray;
	}
	
	//나를 팔로잉(따르는) 하는 사람들(팔로워)
	public ArrayList<FollowerViewVO> requestFollowerList(String userCode)
	{
		ArrayList<FollowerViewVO> followerArray = this.followerViewDAO.requestFollowerList(userCode);
		return followerArray;
	}

	//새로 추가
	public ArrayList<FollowerViewWithFollowingOrNotVO> requestFollowerListWithFollowingOrNot(String userCode)
	{
		ArrayList<FollowerViewWithFollowingOrNotVO> array = this.followerViewDAO.requestFollowerListWithFollowingOrNot(userCode);
		return array;
	}
	public static void main(String[]args)
	{
		FollowManager man  =new FollowManager();
		System.out.println(man.requestFollowerList("code1").get(0).getFollowCode());
		System.out.println(man.requestFollowingList("code1").get(0).getFollowerCode());
	}
	
	public int insertFollow(String targetUserCode,String myUserCode)
	{ 
		return followDAO.insertFollow(targetUserCode, myUserCode);
	}
	public int deleteFollow(String targetUserCode,String myUserCode)
	{
		return followDAO.deleteFollow(targetUserCode, myUserCode);
	} 
	public int deleteFollowByFollowCode(String followCode)
	{
		return followDAO.deleteFollowByFollowCode(followCode);
	}
	public FollowVO searchFollow(String targetUserCode,String myUserCode)
	{
		return followDAO.searchFollow(targetUserCode, myUserCode);
	}
	public LinkedList<FollowVO> searchFollowList(String userCode)
	{
		return followDAO.searchFollowList(userCode);
	} 
}
