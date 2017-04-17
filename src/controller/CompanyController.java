package controller;

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
import DAO.StateDAO;
import VO.CompanyVO;
import VO.CountryVO;
import VO.LoginVO;
import VO.StateVO;



/**
 * Servlet implementation class company
 */
@WebServlet("/CompanyController")
public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyController() {
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
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		CountryDAO d=new CountryDAO();
		List lsCountryComp=d.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCountryComp", lsCountryComp);
		
		/*StateDAO sd=new StateDAO();
		List ls=sd.search1();
		
		
		session.setAttribute("abc1", ls);*/
		
		response.sendRedirect("admin/addCompany.jsp");
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
		
		CompanyDAO companyDAO=new CompanyDAO();
		companyDAO.insertUserPassword(loginVO);
		
		
		CompanyVO v=new CompanyVO();
		v.setCompanyName(s1);
		v.setAddress(s2);
		
		v.setCv(v1);
		v.setSv(v2);
		v.setLoginVO(loginVO);
		
		
		
		
		companyDAO.insertCompany(v);
		
		response.sendRedirect("admin/addCompany.jsp");
	}
	
	protected void updateCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s3=request.getParameter("cname2");
		String s4=request.getParameter("cname3");
		String s5=request.getParameter("cname4");
		int s6=Integer.parseInt(request.getParameter("companyId"));
		
		Integer i1= Integer.parseInt(request.getParameter("countryDrop"));
		CountryVO v1=new CountryVO();
		v1.setCountryId(i1);
		
		Integer i2= Integer.parseInt(request.getParameter("stateDrop"));
		StateVO v2=new StateVO();
		v2.setStateId(i2);
	
		CompanyVO v=new CompanyVO();
		v.setCompanyName(s1);
		v.setAddress(s2);
		
		v.setCompanyId(s6);
		v.setCv(v1);
		v.setSv(v2);

		CompanyDAO d=new CompanyDAO();
		d.updateCompany(v);
		
		CompanyDAO d1=new CompanyDAO();
		List lsCompanysearch=d1.searchCompany();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCompanysearch", lsCompanysearch);
		
		response.sendRedirect("admin/searchCompany.jsp");

	}
	
}
