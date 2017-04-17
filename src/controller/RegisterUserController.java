package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;







import DAO.CountryDAO;
import DAO.LoginDAO;
import DAO.RegisteredUserDAO;
import DAO.StateDAO;
import VO.CountryVO;
import VO.RegisteredUserVO;
import VO.StateVO;
import VO.LoginVO;

/**
 * Servlet implementation class registeredUser
 */
@WebServlet("/RegisterUserController")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag!=null && flag.equals("search"))
		{
			search(request,response);
		}
		
		else if(flag!=null && flag.equals("searchRegisteredUser"))
		{
			searchRegisteredUser(request,response);
		}
		else if(flag!=null && flag.equals("loadState"))
		{
			PrintWriter out=response.getWriter();
			
			loadState(request,response);
		}
		else if(flag.equals("deleteRegisteredUser"))
		{
			deleteRegisteredUser(request,response);
		}
		else if(flag.equals("editRegisteredUser"))
		{
			editRegisteredUser(request,response);
		}
		else if(flag.equals("searchRegisterUser"))
		{
			System.out.println("!!!!!!!!!!!");
			searchRegisterUser(request,response);
		}
		else if(flag.equals("createWorkspace"))
		{
	//		System.out.print("hhh");
			String s1=request.getParameter("cname");
			System.out.print(s1);
			 File dir = new File("C:\\apache-tomcat-7.0.52\\webapps\\workspace\\"+s1);	   
			 dir.mkdir();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertRegisteredUser"))
		{
			insertRegisteredUser(request,response);
		}
		else if(flag.equals("updateRegisteredUser"))
		{
			updateRegisteredUser(request,response);
		}
	}
	
		//methods
	protected void updateRegisteredUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		Integer loginId = (Integer) request.getSession()
				.getAttribute("userId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);
		
		int registeredUserId= Integer.parseInt(request.getParameter("registeredUserId"));
		

		
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s3=request.getParameter("cname2");
		String s4=request.getParameter("cname3");
		String s5=request.getParameter("cname4");
		String stype="registereedUser";
		/*
		String startdate = request.getParameter("cname5");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d3 = null;
		try {
			d3 = sdf.parse(startdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String s7=request.getParameter("cemail");
		int s8=Integer.parseInt(request.getParameter("cname6"));
	/*	String s9=request.getParameter("cname7");
		int s10=Integer.parseInt(request.getParameter("registeredUserId"));
		
		Integer i1= Integer.parseInt(request.getParameter("countryDrop"));
		
		CountryVO v1=new CountryVO();
		v1.setCountryId(i1);
		
		Integer i2= Integer.parseInt(request.getParameter("stateDrop"));
		StateVO v2=new StateVO();
		v2.setStateId(i2);*/
		
		
		
		LoginVO loginVO2 = new LoginVO();
		loginVO2.setUserType(stype);
		loginVO2.setEmail(s7);
		loginVO2.setPassword(s4);
		loginVO2.setUserId(loginId);
		loginVO2.setUserName(s3);
		
		RegisteredUserVO v=new RegisteredUserVO();
		v.setRegisteredUserId(registeredUserId);
		v.setFirstName(s1);
		v.setLastName(s2);
//		v.setDateOfBirth(d3);
		v.setPhoneNumber(s8);
	/*	v.setAddress(s9);*/
	/*	v.setRegisteredUserId(s10);*/
	/*	v.setCv(v1);
		v.setSv(v2);*/
		v.setLoginVO(loginVO2);
		
		
		
		RegisteredUserDAO d=new RegisteredUserDAO();
		d.updateRegisteredUser(v);
		
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.update(loginVO2);
		
		response.sendRedirect("userLayout/index.jsp");

	}

	protected void searchRegisterUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer loginId = (Integer) request.getSession()
				.getAttribute("userId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.searchRegisteredUserDetails(loginVO);
		
		RegisteredUserVO registeredUserVO= new RegisteredUserVO();
		registeredUserVO.setLoginVO(loginVO);

		RegisteredUserDAO registeredUserDAO = new RegisteredUserDAO();
		List list = registeredUserDAO.searchRegisteredUserDetails(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("RegisteredUserNameList", ls);

		session.setAttribute("RegisteredUserProfileList", list);
		System.out.println("---ls---"+ls.size());
		System.out.println("---listtttttttttt---"+list.size());
		
		CountryDAO cDAO=new CountryDAO();
		List countryList=cDAO.search();
		session.setAttribute("countryList", countryList);
		
		StateDAO sDAO=new StateDAO();
		List stateList=sDAO.search1();
		session.setAttribute("stateList", stateList);
		System.out.println("---listtttttttttt++stateeeeee---"+stateList.size());
		
		response.sendRedirect("userLayout/editRegisteredUser.jsp");

	
	/*	RegisteredUserDAO d=new RegisteredUserDAO();
		List lsRUsearch=d.searchRegisteredUser();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsRUsearch", lsRUsearch);*/
		
	
		
		
	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CountryDAO d=new CountryDAO();
		List lsCountryRU=d.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCountryRU", lsCountryRU);
		
	/*	StateDAO sd=new StateDAO();
		List ls=sd.search1();
		
		
		session.setAttribute("abcCountry1", ls);*/
		
		response.sendRedirect("admin/registerUser.jsp");
	}
	protected void searchRegisteredUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		RegisteredUserDAO d=new RegisteredUserDAO();
		List lsRUsearch=d.searchRegisteredUser();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsRUsearch", lsRUsearch);
		
		System.out.println("-------"+lsRUsearch.size());
		
		response.sendRedirect("admin/searchRegisteredUser.jsp");
	}
	protected void loadState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer countryId=Integer.parseInt(request.getParameter("countryId"));
		CountryVO countryVO=new CountryVO();
		countryVO.setCountryId(countryId);
		
		RegisteredUserDAO d=new RegisteredUserDAO();
		List lsLoadState=d.loadState(countryVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("lsLoadState", lsLoadState);
		
		response.sendRedirect("admin/JSON/loadState.jsp");
	}
	
	protected void deleteRegisteredUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("registeredUserId"));
		
		RegisteredUserVO v=new RegisteredUserVO();
		v.setRegisteredUserId(s1);
		
		RegisteredUserDAO d=new RegisteredUserDAO();
		d.deleteRegisteredUser(v);
		
		response.sendRedirect("admin/searchRegisteredUser.jsp");
	}
	
	protected void editRegisteredUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("registeredUserId"));
		
		RegisteredUserVO v=new RegisteredUserVO();
		v.setRegisteredUserId(s1);
		
		RegisteredUserDAO d=new RegisteredUserDAO();
		List lsRUedit=d.editRegisteredUser(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("lsRUedit",lsRUedit);
		
		System.out.println("---------"+lsRUedit.size());
		
		CountryDAO cDAO=new CountryDAO();
		List countryList=cDAO.search();
		session.setAttribute("countryList", countryList);
		
		StateDAO sDAO=new StateDAO();
		List stateList=sDAO.search1();
		session.setAttribute("stateList", stateList);
		
		response.sendRedirect("admin/editRegisteredUser.jsp");
	}
	
	protected void insertRegisteredUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("ayyyyy..");
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s3=request.getParameter("cname2");
		String s4=request.getParameter("cname3");
	/*	String s5=request.getParameter("cname4");*/
		String s6="registereedUser";
		
		/*String startdate = request.getParameter("cname5");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d3 = null;
		try {
			d3 = sdf.parse(startdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String s7=request.getParameter("cemail");
		int s8=Integer.parseInt(request.getParameter("cname6"));
	/*	String s9=request.getParameter("cname7");
		
		Integer i1= Integer.parseInt(request.getParameter("countryDrop"));
		Integer i2= Integer.parseInt(request.getParameter("stateDrop"));
		
		CountryVO v1=new CountryVO();
		v1.setCountryId(i1);
		
		StateVO v2=new StateVO();
		v2.setStateId(i2);*/
	
		LoginVO loginVO= new LoginVO();
		loginVO.setUserName(s3);
		loginVO.setPassword(s4);
		loginVO.setUserType(s6);
		loginVO.setEmail(s7);
		
		RegisteredUserDAO registeredUserDAO=new RegisteredUserDAO();
		registeredUserDAO.insertUserPassword(loginVO);
		
		RegisteredUserVO v=new RegisteredUserVO();
		v.setFirstName(s1);
		v.setLastName(s2);
	/*	v.setDateOfBirth(d3);*/
		
		v.setPhoneNumber(s8);
	/*	v.setAddress(s9);
		v.setCv(v1);
		v.setSv(v2);*/
		v.setLoginVO(loginVO);
		
		registeredUserDAO.insertRegisteredUser(v);
		
		String folderPath = getServletContext().getRealPath(request.getServletPath());

		System.out.println(">> getServletContext : "+getServletContext());
		System.out.println(">> Servlet Path : "+getServletContext().getRealPath(request.getServletPath()));

		int path = folderPath.lastIndexOf('\\');
		System.out.println(">> path : "+path);

		String path1= folderPath.substring(0, path) +"\\userWorkspace\\";
		System.out.println(">> path1 : "+path1);

		File targetFile = new File(path1+s3);

		if (!targetFile.exists()) {
			if (targetFile.mkdir()) {
				System.out.println("***********Proj namne Directory is created!************");
			} else {
				System.out.println("************Proj Name Failed to create directory!**************");
			}
		}
		
		
		/*RegisteredUserDAO d=new RegisteredUserDAO();
		d.insertRegisteredUser(v);
		d.insertUserPassword(loginVO);*/
		
		response.sendRedirect("admin/login.jsp");
	}
	
	/*protected void updateRegisteredUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s3=request.getParameter("cname2");
		String s4=request.getParameter("cname3");
		String s5=request.getParameter("cname4");
		
		String startdate = request.getParameter("cname5");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d3 = null;
		try {
			d3 = sdf.parse(startdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s7=request.getParameter("cemail");
		int s8=Integer.parseInt(request.getParameter("cname6"));
		String s9=request.getParameter("cname7");
		int s10=Integer.parseInt(request.getParameter("registeredUserId"));
		
		Integer i1= Integer.parseInt(request.getParameter("countryDrop"));
		CountryVO v1=new CountryVO();
		v1.setCountryId(i1);
		
		Integer i2= Integer.parseInt(request.getParameter("stateDrop"));
		StateVO v2=new StateVO();
		v2.setStateId(i2);
		
		RegisteredUserVO v=new RegisteredUserVO();
		v.setFirstName(s1);
		v.setLastName(s2);
		
		v.setDateOfBirth(d3);
		v.setEmail(s7);
		v.setPhoneNumber(s8);
		v.setAddress(s9);
		v.setRegisteredUserId(s10);
		v.setCv(v1);
		v.setSv(v2);
		
		RegisteredUserDAO d=new RegisteredUserDAO();
		d.updateRegisteredUser(v);
		
		RegisteredUserDAO d1=new RegisteredUserDAO();
		List lsRUsearch=d1.searchRegisteredUser();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsRUsearch",lsRUsearch);

		
		
		response.sendRedirect("admin/searchRegisteredUser.jsp");

	}*/

}
	


