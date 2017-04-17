package mail;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.CompanyDAO;
import DAO.LoginDAO;
import DAO.RegisteredUserDAO;
import VO.CompanyVO;
import VO.LoginVO;
import VO.RegisteredUserVO;

import java.security.SecureRandom;
import java.math.BigInteger;

public class SendMailNoMain {

	
	public boolean sendMail(String to) {
		SessionIdentifierGenerator sig=new SessionIdentifierGenerator();
		String pwd=sig.nextSessionId();
		
		RegisteredUserVO registeredUserVO=new RegisteredUserVO();
		//registeredUserVO.setEmail(to);
			
		LoginVO loginVO=new LoginVO();
		loginVO.setEmail(to);
		
		LoginDAO loginDAO=new LoginDAO();
		
		RegisteredUserDAO registeredUserDAO=new RegisteredUserDAO();
		
		List<LoginVO> emailList= loginDAO.searchByEmail(to);
		System.out.println("##### List Email "+emailList.size());
	/*	registeredUserVO.setEmail(emailList.get(0).getEmail());
		registeredUserVO.setFirstName(emailList.get(0).getFirstName());
		registeredUserVO.setLastName(emailList.get(0).getLastName());
		registeredUserVO.setAddress(emailList.get(0).getAddress());
		registeredUserVO.setCv(emailList.get(0).getCv());
		registeredUserVO.setSv(emailList.get(0).getSv());
		registeredUserVO.setDateOfBirth(emailList.get(0).getDateOfBirth());
		registeredUserVO.setPhoneNumber(emailList.get(0).getPhoneNumber());
		registeredUserVO.setRegisteredUserId(emailList.get(0).getRegisteredUserId());
		registeredUserVO.setLoginVO(emailList.get(0).getLoginVO()());
	*/	
		loginVO.setEmail((emailList.get(0).getEmail()));
		loginVO.setPassword((emailList.get(0).getPassword()));
		loginVO.setUserName((emailList.get(0).getUserName()));
		loginVO.setUserType((emailList.get(0).getUserType()));
		loginVO.setUserId((emailList.get(0).getUserId()));
		
		
		//	loginVO=emailList.get(0).getLoginVO();
		
			loginVO.setPassword(pwd);
		
		//registeredUserVO.setLoginVO(loginVO);		
			//loginDAO.update(loginVO);		
			LoginDAO ld=new LoginDAO();
			ld.update(loginVO);
			
			
		/*	CompanyVO companyVO= new CompanyVO();
			companyVO.setEmail(to);
				
			CompanyDAO companyDAO=new CompanyDAO();
			
			List<CompanyVO> emailList1= companyDAO.searchByEmail(to);
			System.out.println("##### List Email "+emailList1.size());
			companyVO.setEmail(emailList.get(0).getEmail());
			companyVO.setCompanyId(emailList1.get(0).getCompanyId());
			companyVO.setCompanyName(emailList1.get(0).getCompanyName());
			companyVO.setAddress(emailList1.get(0).getAddress());
			companyVO.setCv(emailList1.get(0).getCv());
			companyVO.setSv(emailList1.get(0).getSv());
			
			LoginVO loginVO1=new LoginVO();
				loginVO1=emailList.get(0).getLoginVO();
			
				loginVO1.setPassword(pwd);
			
				companyVO.setLoginVO(loginVO1);		
				companyDAO.updateCompany(companyVO);
			
				LoginDAO ld1=new LoginDAO();
				ld1.update(loginVO1);
*/
		final String from = "aishashah535@gmail.com";
		final String password = "aishashah323";
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("ForgotPassword");
			//String s="patel";
			
			System.out.println("hiiiiiiiiiiiii");
			message.setText(" >> " + "New Password :: "+ " << "+pwd);
			Transport.send(message);
			
			

			System.out.println("Sent message successfully....");

		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
}



