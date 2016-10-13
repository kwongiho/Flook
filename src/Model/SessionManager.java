package Model;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class SessionManager {
	private static final SessionManager manager = new SessionManager();
	private HashMap<String, HttpSession> map;
	public SessionManager()
	{
		map=new HashMap<String, HttpSession>();
	}
	public static SessionManager getInstance()
	{
		return manager;
	}
	public HttpSession searchSession(String userCode)
	{
		return map.get(userCode);
	}
	public HttpSession insert(String userCode,HttpSession session)
	{
		return map.put(userCode, session);
	}  
}
