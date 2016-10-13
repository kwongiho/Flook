package service;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * mail을 보내기 위한 클래스이다.
 * @author GHKwon
 *
 */
public class MailSend  {
	/**
	 * 발송할 이메일 주소들
	 */
	private String[] sendAddress;
	/**
	 * 메일 보내는사람.
	 */
	private String emailFromAddress;
	/**
	 * 메일 보낼 내용.
	 */
	private String emailMsgTxt;
	/**
	 * 메일 제목.
	 */
	private String emailSubjectTxt;
	
	/**
	 * 한명의 이메일을 발송할 때 호출되는 생성자이다. 
	 * @param sendAddress 받을사람 한명의 이메일주소.
	 * @param emailFromAddress 이메일 발송하는사람.
	 * @param emailMsgTxt 이메일 내용
	 * @param emailSubjectTxt 이메일 제목.
	 */
	public MailSend(String sendAddress, String emailFromAddress, String emailMsgTxt,String emailSubjectTxt) {
		this(new String[]{sendAddress},emailFromAddress,emailMsgTxt,emailSubjectTxt);
	}
	/**
	 * 여러명에게 이메일을 발송할 때 호출되는 생성자이다.
	 * @param sendAddress 받을사람 여러명의 이메일주소.
	 * @param emailFromAddress 이메일 발송하는사람.
	 * @param emailMsgTxt 이메일 내용.
	 * @param emailSubjectTxt 이메일 제목.
	 */
	public MailSend(String sendAddress[], String emailFromAddress, String emailMsgTxt,String emailSubjectTxt) {
		this.sendAddress=sendAddress;
		this.emailFromAddress=emailFromAddress;
		this.emailMsgTxt=emailMsgTxt;
		this.emailSubjectTxt=emailSubjectTxt;
		testMailSend();
	}
	/**
	 * 메일을 보내는 메소드.
	 * 내부에서 private인, postMail메소드를 호출한다.
	 */
	public void testMailSend(){
		try {
			// 메일보내기 
			postMail( sendAddress , emailSubjectTxt, emailMsgTxt, emailFromAddress);
			/*System.out.println("모든 사용자에게 메일이 성공적으로 보내졌음~~");*/
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 이메일을 보내주는 메소드.
	 * @param recipients 받는사람(n)명 주소.
	 * @param subject 이메일 제목
	 * @param message 이메일 내용.
	 * @param from 이메일 보내는사람.
	 * @throws MessagingException 메시지 전송에 필요한 메소드들이 이에 해당하는 익셉션을 발생한다.
	 */
	private void postMail(String recipients[], String subject, String message, String from) throws MessagingException {
		boolean debug = false;
		java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		String SMTP_HOST_NAME = "gmail-smtp.l.google.com";
		// Properties 설정
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
 
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);
 
		session.setDebug(debug);
 
		// create a message
		Message msg = new MimeMessage(session);
		
		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);
 
		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);
 
		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain; charset=utf-8");

		Transport.send(msg);
	}
	/**
	 * 구글 사용자 메일 계정 아이디/패스 정보
	 * userName은  권기호가 인증한 권기호 아이디이고.
	 * password는 권기호가 발급받은 password이다.
	 */
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username =  "rlgh9351@gmail.com"; // gmail 사용자;
			String password = "nhmcgqairfplgwvl"; // 패스워드;
			return new PasswordAuthentication(username, password);
		}
	}
	/*
	 * 단위테스트
	 */
	public static void main(String []args) {
		new MailSend("rlgh9351@gmail.com","rlgh9351@gmail.com","asdf한글","메일제목");
	}
}
