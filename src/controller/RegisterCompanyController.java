package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CompanyDAO;
import DAO.CountryDAO;
import DAO.DeveloperDAO;
import DAO.LoginDAO;
import DAO.ProjectDAO;
import DAO.RegisteredUserDAO;
import DAO.StateDAO;
import VO.CompanyVO;
import VO.CountryVO;
import VO.DeveloperVO;
import VO.LoginVO;
import VO.RegisteredUserVO;
import VO.StateVO;



/**
 * Servlet implementation class company
 */
@WebServlet("/RegisterCompanyController")
public class RegisterCompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCompanyController() {
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
		else if(flag!=null && flag.equals("searchCompany"))
		{
			searchCompany(request,response);
		}
		else if(flag!=null && flag.equals("searchEditCompany"))
		{
			searchEditCompany(request,response);
		}
		else if(flag!=null && flag.equals("searchDeveloperFromCompany"))
		{
			searchDeveloperFromCompany(request,response);
		}
		else if(flag!=null && flag.equals("loadState"))
		{
			loadState(request,response);
		}
		else if(flag.equals("deleteCompany"))
		{
			deleteCompany(request,response);
		}
		else if(flag.equals("editCompany"))
		{
			editCompany(request,response);
		}
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		
		if(flag.equals("insertCompany"))
		{
			insertCompany(request, response);
		}
		else if(flag.equals("updateCompany"))
		{
			updateCompany(request, response);
		}

	}
	
	//methods
	protected void searchEditCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer loginId = (Integer) request.getSession()
				.getAttribute("userId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.searchRegisteredUserDetails(loginVO);
		
		CompanyVO companyVO= new CompanyVO();
		companyVO.setLoginVO(loginVO);

		CompanyDAO companyDAO = new CompanyDAO();
		List list = companyDAO.searchCompanyDetails(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("CompanyUserNameList", ls);
		HttpSession session1 = request.getSession();
		session1.setAttribute("CompanyUserProfileList", list);
		
		CountryDAO cDAO=new CountryDAO();
		List countryList=cDAO.search();
		session.setAttribute("countryList", countryList);
		
		StateDAO sDAO=new StateDAO();
		List stateList=sDAO.search1();
		session.setAttribute("stateList", stateList);
		
		response.sendRedirect("userLayout/editCompany.jsp");

	

	
		
		
	}
	protected void searchDeveloperFromCompany(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int user = (Integer) session.getAttribute("userId");
		LoginVO loginVO=new LoginVO();
		loginVO.setUserId(user);
		CompanyVO companyVO=new CompanyVO();
		companyVO.setLoginVO(loginVO);
		CompanyDAO companyDAO= new CompanyDAO();
		List<CompanyVO> ls=companyDAO.searchCompany(companyVO);
		System.out.println("---------"+ls.size());
		
		System.out.println("+++++++++"+ls.get(0).getCompanyId());
		int companyId=ls.get(0).getCompanyId();
		CompanyVO companyVO1=new CompanyVO();
		companyVO1.setCompanyId(companyId);
		
		DeveloperVO developerVO=new DeveloperVO();
		developerVO.setCompanyVO(companyVO1);
		
		DeveloperDAO d=new DeveloperDAO();
		List ls1=d.searchDeveloperFromCompany(developerVO);
		
		session.setAttribute("lsLoadDeveloper", ls1);
		
		response.sendRedirect("admin/JSON/loadDeveloper.jsp");
		
	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		CountryDAO d=new CountryDAO();
		List lsCountryComp=d.search();
		
		System.out.println(lsCountryComp.size());
		HttpSession session=request.getSession();
		session.setAttribute("lsCountryComp", lsCountryComp);
		
		/*StateDAO sd=new StateDAO();
		List ls=sd.search1();
		
		
		session.setAttribute("abc1", ls);*/
		
		response.sendRedirect("admin/registerCompany.jsp");
	}
	protected void searchCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	
		CompanyDAO d=new CompanyDAO();
		List lsCompanysearch=d.searchCompany();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCompanysearch",lsCompanysearch);
		
	
		
		response.sendRedirect("admin/searchCompany.jsp");
	}
	
	protected void loadState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		/*
		 long countryId=Long.parseLong(request.getParameter("countryId"));
		
		CountryVO countryVO=new CountryVO();
		countryVO.setCountryId(countryId);
		
		CityDAO cityDAO=new CityDAO();
		List list = cityDAO.loadState(countryVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("state_list", list);
		
		response.sendRedirect("Admin/JSON/loadState.jsp");
		 */
		
		Integer countryId=Integer.parseInt(request.getParameter("countryId"));
		CountryVO countryVO=new CountryVO();
		countryVO.setCountryId(countryId);
		
		CompanyDAO d=new CompanyDAO();
		List lsLoadState=d.loadState(countryVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("lsLoadState", lsLoadState);
		
		response.sendRedirect("admin/JSON/loadState.jsp");
	}
	
	protected void deleteCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		int s1=Integer.parseInt(request.getParameter("companyId"));
		
		CompanyVO v=new CompanyVO();
		v.setCompanyId(s1);
		
		CompanyDAO d=new CompanyDAO();
		d.deleteCompany(v);
		
		response.sendRedirect("admin/searchCompany.jsp");
	}
	
	protected void editCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		int s1=Integer.parseInt(request.getParameter("companyId"));
		
		CompanyVO v=new CompanyVO();
		v.setCompanyId(s1);
		
		CompanyDAO d=new CompanyDAO();
		List lsCompanyedit=d.editCompany(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCompanyedit", lsCompanyedit);
		
		CountryDAO cDAO=new CountryDAO();
		List countryList=cDAO.search();
		session.setAttribute("countryList", countryList);
		
		StateDAO sDAO=new StateDAO();
		List stateList=sDAO.search1();
		session.setAttribute("stateList", stateList);
		
		response.sendRedirect("admin/editCompany.jsp");
	
	}
	
	protected void insertCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s3=request.getParameter("cname2");
		String s4=request.getParameter("cname3");
		String s5=request.getParameter("cname5");
		
		String s6="company";
		
		Integer i1= Integer.parseInt(request.getParameter("countryDrop"));
		Integer i2= Integer.parseInt(request.getParameter("stateDrop"));
		
		CountryVO v1=new CountryVO();
		v1.setCountryId(i1);
		StateVO v2=new StateVO();
		v2.setStateId(i2);
		
		LoginVO loginVO= new LoginVO();
		loginVO.setUserName(s3);
		loginVO.setPassword(s4);
		loginVO.setUserType(s6);
		loginVO.setEmail(s5);
		
		CompanyDAO companyDAO=new CompanyDAO();
		companyDAO.insertUserPassword(loginVO);
		
		
		CompanyVO v=new CompanyVO();
		v.setCompanyName(s1);
		v.setAddress(s2);
		/*v.setEmail(s5);*/
		v.setCv(v1);
		v.setSv(v2);
		v.setLoginVO(loginVO);
		
		companyDAO.insertCompany(v);
		
		
		String folderPath = getServletContext().getRealPath(request.getServletPath());

		System.out.println(">> getServletContext : "+getServletContext());
		System.out.println(">> Servlet Path : "+getServletContext().getRealPath(request.getServletPath()));

		int path = folderPath.lastIndexOf('\\');
		System.out.println(">> path : "+path);

		String path1= folderPath.substring(0, path) +"\\userWorkspace\\";
		System.out.println(">> path1 : "+path1);

		File targetFile = new File(path1+s1);

		if (!targetFile.exists()) {
			if (targetFile.mkdir()) {
				System.out.println("***********Proj namne Directory is created!************");
			} else {
				System.out.println("************Proj Name Failed to create directory!**************");
			}
		}

		
		
		response.sendRedirect("admin/login.jsp");
	}
	
	protected void updateCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer loginId = (Integer) request.getSession()
				.getAttribute("userId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);
		
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s3=request.getParameter("cname2");
		String s4=request.getParameter("cname3");
		String s5=request.getParameter("cemail");
		String stype="company";
		
		int s6=Integer.parseInt(request.getParameter("companyId"));
		
		Integer i1= Integer.parseInt(request.getParameter("countryDrop"));
		CountryVO v1=new CountryVO();
		v1.setCountryId(i1);
		
		Integer i2= Integer.parseInt(request.getParameter("stateDrop"));
		StateVO v2=new StateVO();
		v2.setStateId(i2);
	
		int s10=Integer.parseInt(request.getParameter("companyId"));
		
		LoginVO loginVO2 = new LoginVO();
		loginVO2.setUserType(stype);
		loginVO2.setEmail(s5);
		loginVO2.setPassword(s4);
		loginVO2.setUserId(loginId);
		loginVO2.setUserName(s3);
		
		
		CompanyVO v=new CompanyVO();
		v.setCompanyName(s1);
		v.setAddress(s2);
		v.setCompanyId(s6);
		
		v.setCv(v1);
		v.setSv(v2);
		v.setCompanyId(s10);
		v.setLoginVO(loginVO2);
		
		
		CompanyDAO d=new CompanyDAO();
		d.updateCompany(v);
		
		/*CompanyDAO d1=new CompanyDAO();
		List lsCompanysearch=d1.searchCompany();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCompanysearch", lsCompanysearch);*/
		
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.update(loginVO2);
		
		response.sendRedirect("userLayout/index.jsp");
	}
	
}
