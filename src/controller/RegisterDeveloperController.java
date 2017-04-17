
package controller;

import java.io.File;
import java.io.IOException;
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






















import DAO.CompanyDAO;
import DAO.CountryDAO;
import DAO.DeveloperDAO;
import DAO.LoginDAO;
import DAO.RegisteredUserDAO;
import DAO.StateDAO;
import VO.CompanyVO;
import VO.CountryVO;
import VO.DeveloperVO;
import VO.LoginVO;

/**
 * Servlet implementation class developer
 */
@WebServlet("/RegisterDeveloperController")
public class RegisterDeveloperController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDeveloperController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchDeveloper"))
		{
			searchDeveloper(request,response);
		}
		else if(flag.equals("searchEditDeveloper"))
		{
			searchEditDeveloper(request,response);
		}
		else if(flag.equals("deleteDeveloper"))
		{
			deleteDeveloper(request,response);
		}
		else if(flag.equals("editDeveloper"))
		{
			editDeveloper(request,response);
		}
		else if(flag.equals("createWorkspace"))
		{
	//		System.out.print("hhh");
			String s1=request.getParameter("cname");
			System.out.print(s1);
			 File dir = new File("C:\\apache-tomcat-7.0.52\\webapps\\"+s1);	   
			 dir.mkdir();
			
		}
		else if(flag.equals("searchCompany1"))
		{
			searchCompany1(request,response);
		}

		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		
		if(flag.equals("insertDeveloper"))
		{
			System.out.println("hiii insert flag");
			insertDeveloper(request,response);
		}
		else if(flag.equals("updateDeveloper"))
		{
			updateDeveloper(request,response);
		}
		
}
	//methods

	protected void searchEditDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer loginId = (Integer) request.getSession()
				.getAttribute("userId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.searchRegisteredUserDetails(loginVO);
		
		DeveloperVO developerVO= new DeveloperVO();
		developerVO.setLoginVO(loginVO);

		DeveloperDAO developerDAO = new DeveloperDAO();
		List list = developerDAO.searchDeveloperDetails(loginVO);

		HttpSession session = request.getSession();
		session.setAttribute("DeveloperUserNameList", ls);
		
		HttpSession session1 = request.getSession();
		session1.setAttribute("DeveloperUserProfileList", list);
		
		CountryDAO cDAO=new CountryDAO();
		List countryList=cDAO.search();
		session.setAttribute("countryList", countryList);
		
		StateDAO sDAO=new StateDAO();
		List stateList=sDAO.search1();
		session.setAttribute("stateList", stateList);
		
		response.sendRedirect("userLayout/editDeveloper.jsp");
	}
	protected void searchCompany1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CompanyDAO d=new CompanyDAO();
		List lsCompany=d.searchCompany();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCompany", lsCompany);
		
		
		response.sendRedirect("admin/registerDeveloper.jsp");
	}
	
	protected void searchDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DeveloperDAO d=new DeveloperDAO();
		List lsDevelopersearch=d.searchDeveloper();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsDevelopersearch", lsDevelopersearch);
		
		response.sendRedirect("admin/searchDeveloper.jsp");
	}
	
	protected void deleteDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("developerId"));
		
		DeveloperVO v=new DeveloperVO();
		v.setDeveloperId(s1);
		
		DeveloperDAO d=new DeveloperDAO();
		d.deleteDeveloper(v);
		
		response.sendRedirect("admin/searchDeveloper.jsp");
	}
	
	protected void editDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("developerId"));
		
		DeveloperVO v=new DeveloperVO();
		v.setDeveloperId(s1);
		
		DeveloperDAO d=new DeveloperDAO();
		List lsDeveloperedit=d.editDeveloper(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("lsDeveloperedit", lsDeveloperedit);
		
		response.sendRedirect("admin/editDeveloper.jsp");
	}
	
	protected void insertDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("heyyyyy");
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s3=request.getParameter("cname2");
		String s4=request.getParameter("cname3");
		String s6=request.getParameter("cemail");
		/*int s3=Integer.parseInt(request.getParameter("cname2"));*/
		
		String startdate = request.getParameter("cname5");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d3 = null;
		try {
			d3 = sdf.parse(startdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		String s5=request.getParameter("cname7");
		int s7=Integer.parseInt(request.getParameter("cname6"));
		int i1=Integer.parseInt(request.getParameter("companyDrop"));
		CompanyVO v1=new CompanyVO();
		v1.setCompanyId(i1);

		String s10="developer";
		
		LoginVO loginVO= new LoginVO();
		loginVO.setUserName(s3);
		loginVO.setPassword(s4);
		loginVO.setUserType(s10);
		loginVO.setEmail(s6);
		
		DeveloperDAO developerDAO=new DeveloperDAO();
		developerDAO.insertUserPassword(loginVO);
		
		
		DeveloperVO v=new DeveloperVO();
		v.setFirstName(s1);
		v.setLastName(s2);
		
		v.setDateOfBirth(d3);
		v.setAddress(s5);
		v.setPhoneNumber(s7);
		v.setCompanyVO(v1);
		v.setLoginVO(loginVO);
		
		DeveloperDAO d=new DeveloperDAO();
		d.insertDeveloper(v);

		System.out.println("in developerrrrrrrrrrr");
		
		DeveloperDAO d1=new DeveloperDAO();
		DeveloperVO developerDetail = (DeveloperVO) d1.searchDeveloperFromid(i1).get(0);
		
		System.out.println("Company Name :: "+developerDetail.getCompanyVO().getCompanyName());
		String s20=developerDetail.getCompanyVO().getCompanyName();
		String folderPath = getServletContext().getRealPath(request.getServletPath());

		System.out.println(">> getServletContext : "+getServletContext());
		System.out.println(">> Servlet Path : "+getServletContext().getRealPath(request.getServletPath()));

		int path = folderPath.lastIndexOf('\\');
		System.out.println(">> path : "+path);

		String path1= folderPath.substring(0, path) +"\\userWorkspace\\";
		System.out.println(">> path1 : "+path1);

		File targetFile = new File(path1+s20+"\\"+s3);

		if (!targetFile.exists()) {
			if (targetFile.mkdir()) {
				System.out.println("***********Proj namne Directory is created!************");
			} else {
				System.out.println("************Proj Name Failed to create directory!**************");
			}
		}
		
		
		response.sendRedirect("admin/login.jsp");
	}
	
	protected void updateDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer loginId = (Integer) request.getSession()
				.getAttribute("userId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);
		
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s4=request.getParameter("cname3");
		String s5=request.getParameter("cemail");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		String stype="developer";
		
		String startdate = request.getParameter("cname2");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d3 = null;
		try {
			d3 = sdf.parse(startdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int s6=Integer.parseInt(request.getParameter("cname5"));
		int s7=Integer.parseInt(request.getParameter("developerId"));
	
	/*	Integer cId = (Integer) request.getSession()
				.getAttribute("companyId");		
		CompanyVO companyVO = new CompanyVO();
		companyVO.setCompanyId(cId);*/
		
		//System.out.println("ciddddd"+cId);
		
		CompanyVO companyVO=new CompanyVO();
	//	companyVO.setCompanyId(companyId);
		
		/*Integer loginId1 = (Integer) ((HttpServletRequest) request).getSession()
				.getAttribute("userId");
		LoginVO loginVO3 = new LoginVO();
		loginVO3.setUserId(loginId1);
		
		DeveloperDAO developerDAO= new DeveloperDAO();
		List<DeveloperVO> list2=developerDAO.searchDeveloperDetails(loginVO3);
		
		HttpSession session5=((HttpServletRequest)request).getSession();
		session5.setAttribute("DeveloperList", list2);*/
		
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		CompanyVO companyVO2=new CompanyVO();
		companyVO2.setCompanyId(cid);
		
		LoginVO loginVO2 = new LoginVO();
		loginVO2.setUserType(stype);
		loginVO2.setEmail(s5);
		loginVO2.setPassword(password);
		loginVO2.setUserId(loginId);
		loginVO2.setUserName(username);
		
		
		DeveloperVO v=new DeveloperVO();
		v.setFirstName(s1);
		v.setLastName(s2);
		v.setDateOfBirth(d3);
		v.setAddress(s4);
		v.setPhoneNumber(s6);
		v.setCompanyVO(companyVO2);
		v.setDeveloperId(s7);
		v.setLoginVO(loginVO2);
		

		
		DeveloperDAO d=new DeveloperDAO();
		d.updateDeveloper(v);
		
		DeveloperDAO d1=new DeveloperDAO();
		List lsDevelopersearch=d1.searchDeveloper();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsDevelopersearch", lsDevelopersearch);
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.update(loginVO2);
		
		response.sendRedirect("userLayout/index.jsp");
		
		
	}

}
