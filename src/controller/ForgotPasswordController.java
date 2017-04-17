package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.SendMailNoMain;

import org.hibernate.usertype.UserVersionType;

import DAO.CompanyDAO;
import DAO.DeveloperDAO;
import DAO.LoginDAO;
import DAO.RegisteredUserDAO;
import DAO.userDAO;
import VO.CompanyVO;
import VO.DeveloperVO;
import VO.LoginVO;
import VO.RegisteredUserVO;

@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ForgotPasswordController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("inside cont of fp");
 CompanyVO companyVO= new CompanyVO();
 CompanyDAO companyDAO=new CompanyDAO();
 DeveloperVO developerVO=new DeveloperVO();
 DeveloperDAO developerDAO=new DeveloperDAO();
 
 RegisteredUserVO registeredUserVO=new RegisteredUserVO();
 RegisteredUserDAO registeredUserDAO=new RegisteredUserDAO();
 
	LoginVO loginVO=new LoginVO();
	LoginDAO loginDAO=new LoginDAO();

 String email = request.getParameter("email");

	loginVO.setEmail(email);
	Boolean isRightMail = loginDAO.isRightEmail(loginVO);	
	
	if(isRightMail == true)
	 {
		
		
		
				SendMailNoMain sendMailNoMain = new SendMailNoMain();
				Boolean mailSendStatus = sendMailNoMain.sendMail(email);
				System.out.println("Mail Sent Status :: "+mailSendStatus);
				response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
		 }
			
		 else {
				System.out.println("Controller says, It's not a valid Email ID!");
				response.sendRedirect(request.getContextPath()+"/admin/forgotPassword.jsp");
			}
				 
	 	
	
		/*Boolean isRightMailUser = registeredUserDAO.isRightEmail(registeredUserVO);
		 if(isRightMailUser == false)
		 {
			 Boolean isRightMailCompany=CompanyDAO.isRightEmail(companyVO);
			 if(isRightMail == true)
			 {
					SendMailNoMain sendMailNoMain = new SendMailNoMain();
					Boolean mailSendStatus = sendMailNoMain.sendMail(email);
					System.out.println("Mail Sent Status :: "+mailSendStatus);
					response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			 }
				
			 else {
					System.out.println("Controller says, It's not a valid Email ID!");
					response.sendRedirect(request.getContextPath()+"/admin/forgotPassword.jsp");
				}
					 
		 	}
		
		else {
			SendMailNoMain sendMailNoMain = new SendMailNoMain();
			Boolean mailSendStatus = sendMailNoMain.sendMail(email);
			System.out.println("Mail Sent Status :: "+mailSendStatus);
			
			
			response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
		}*/
		
	
		
	/*	Boolean isRightMailUser = registeredUserDAO.isRightEmail(registeredUserVO);
		Boolean isRightMailCompany = companyDAO.isRightEmail(companyVO);
		Boolean isRightMailDeveloper =developerDAO.isRightEmail(developerVO);
		
		
		
		 if(isRightMailUser == true)
		 {
			 System.out.println("you are in reg userrrrr....");
				SendMailNoMain sendMailNoMain = new SendMailNoMain();
				Boolean mailSendStatus = sendMailNoMain.sendMail(email);
				System.out.println("Mail Sent Status :: "+mailSendStatus);
				response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			
		 }
		 
		 else if(isRightMailCompany == true)
		 {	
			 System.out.println("you are in companyy....");
				SendMailNoMain sendMailNoMain = new SendMailNoMain();
				Boolean mailSendStatus = sendMailNoMain.sendMail(email);
				System.out.println("Mail Sent Status :: "+mailSendStatus);
				response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
		  
		 } 
		 else if(isRightMailDeveloper == true)
		 {	
			 System.out.println("you are in developer....");
				SendMailNoMain sendMailNoMain = new SendMailNoMain();
				Boolean mailSendStatus = sendMailNoMain.sendMail(email);
				System.out.println("Mail Sent Status :: "+mailSendStatus);
				response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
		  
		 }
		 else
		 {
			 System.out.println("Controller says, It's not a valid Email ID!");
			response.sendRedirect(request.getContextPath()+"/admin/forgotPassword.jsp");
		 }
	*/	/*
		Boolean isRightMailUser = registeredUserDAO.isRightEmail(registeredUserVO);
		if(isRightMailUser == false)
		{
			
			Boolean isRightMailCompany = companyDAO.isRightEmail(companyVO);
			
			if(isRightMailCompany == false)
			
			{
				
				
				if(isRightMailDeveloper == true)
				{
					SendMailNoMain sendMailNoMain = new SendMailNoMain();
					Boolean mailSendStatus = sendMailNoMain.sendMail(email);
					System.out.println("Mail Sent Status :: "+mailSendStatus);
					response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
				}
				else
				{
					 System.out.println("Controller says, It's not a valid Email ID!");
						response.sendRedirect(request.getContextPath()+"/admin/forgotPassword.jsp");
				}
			}
			else
					{
					SendMailNoMain sendMailNoMain = new SendMailNoMain();
					Boolean mailSendStatus = sendMailNoMain.sendMail(email);
					System.out.println("Mail Sent Status :: "+mailSendStatus);
					response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
					}
		}
				else
				{
			SendMailNoMain sendMailNoMain = new SendMailNoMain();
			Boolean mailSendStatus = sendMailNoMain.sendMail(email);
			System.out.println("Mail Sent Status :: "+mailSendStatus);
			response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
			}
	
	
		}
*/	
	
	

	}
}
