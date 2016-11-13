package Servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MailSend;
import Manager.FindPasswordManager;

/**
 * Servlet implementation class SendCode
 */
public class SendCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String email = request.getParameter("email");
		FindPasswordManager findPasswordManager = new FindPasswordManager();
		if(findPasswordManager.findEmail(email)!=null){
			System.out.println(email);
			
			String code = UUID.randomUUID().toString().substring(0,6);
			//e3wd3f
			//code = "e3wd3f";
			MailSend send = new MailSend(email, "rlgh9351@gmail.com", "인증코드는 입니다."+code+"정확히 입력해 주세요", "Flook 인증코드 입니다.");
			
			response.getOutputStream().print(code);
		} else {
			response.getOutputStream().print(email);
		}
		
		
	}

}
