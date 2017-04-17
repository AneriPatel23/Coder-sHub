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









import DAO.DeveloperDAO;
import DAO.LoginDAO;
import VO.DeveloperVO;
import VO.LoginVO;
import VO.RegisteredUserVO;

/**
 * Servlet implementation class developer
 */
@WebServlet("/DeveloperController")
public class DeveloperController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeveloperController() {
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
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		
		if(flag.equals("insertDeveloper"))
		{
			insertDeveloper(request,response);
		}
		else if(flag.equals("updateDeveloper"))
		{
			updateDeveloper(request,response);
		}

}
	//methods
	
	protected void searchDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer loginId = (Integer) request.getSession().getAttribute("userId");
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(loginId);

		LoginDAO loginDAO = new LoginDAO();
		List ls = loginDAO.searchRegisteredUserDetails(loginVO);
		
		DeveloperVO developerVO= new DeveloperVO();
		developerVO.setLoginVO(loginVO);

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
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		/*int s3=Integer.parseInt(request.getParameter("cname2"));*/
		
		String startdate = request.getParameter("cname2");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d3 = null;
		try {
			d3 = sdf.parse(startdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s4=request.getParameter("cname3");
		String s5=request.getParameter("cemail");
		int s6=Integer.parseInt(request.getParameter("cname5"));
	
		DeveloperVO v=new DeveloperVO();
		v.setFirstName(s1);
		v.setLastName(s2);
		v.setDateOfBirth(d3);
		v.setAddress(s4);
		//v.setEmail(s5);
		v.setPhoneNumber(s6);
		
		DeveloperDAO d=new DeveloperDAO();
		d.insertDeveloper(v);
		
		response.sendRedirect("admin/addDeveloper.jsp");
	}
	
	protected void updateDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String startdate = request.getParameter("cname2");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d3 = null;
		try {
			d3 = sdf.parse(startdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s4=request.getParameter("cname3");
		String s5=request.getParameter("cemail");
		int s6=Integer.parseInt(request.getParameter("cname5"));
		int s7=Integer.parseInt(request.getParameter("developerId"));
	
		DeveloperVO v=new DeveloperVO();
		v.setFirstName(s1);
		v.setLastName(s2);
		v.setDateOfBirth(d3);
		v.setAddress(s4);
		v.setPhoneNumber(s6);
		v.setDeveloperId(s7);


		
		DeveloperDAO d=new DeveloperDAO();
		d.updateDeveloper(v);
		
		DeveloperDAO d1=new DeveloperDAO();
		List lsDevelopersearch=d1.searchDeveloper();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsDevelopersearch", lsDevelopersearch);
		
		response.sendRedirect("admin/searchDeveloper.jsp");
	}

}
