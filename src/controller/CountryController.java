package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CountryDAO;

import VO.CountryVO;


/**
 * Servlet implementation class country
 */
@WebServlet("/CountryController")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CountryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag = request.getParameter("flag");
		if (flag.equals("search")) 
		{
			search(request,response);
		}
		else if(flag.equals("deleteCountry"))
		{
			deleteCountry(request,response);
		}
		else if(flag.equals("editCountry"))
		{
			editCountry(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag = request.getParameter("flag");

		if (flag.equals("insertCountry"))
		{
			insertCountry(request,response);
		}
		else if(flag.equals("updateCountry"))
		{
			updateCountry(request,response);
		}


	}
	
	//methods
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CountryDAO d = new CountryDAO();
		List lsCountrysearch= d.search();

		HttpSession session = request.getSession();
		session.setAttribute("lsCountrysearch", lsCountrysearch);

		response.sendRedirect("admin/searchCountry.jsp");
	}
	
	protected void deleteCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int s1=Integer.parseInt(request.getParameter("countryId"));
		
		CountryVO v=new CountryVO();
		v.setCountryId(s1);
		
		CountryDAO d=new CountryDAO();
		d.deleteCountry(v);
		
		response.sendRedirect("admin/searchCountry.jsp");
	}
	
	protected void editCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("countryId"));
		
		CountryVO v=new CountryVO();
		v.setCountryId(s1);
		
		CountryDAO d=new CountryDAO();
		List lsCountryedit=d.editCountry(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCountryedit", lsCountryedit);
		
		response.sendRedirect("admin/editCountry.jsp");
	}
	
	protected void insertCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1 = request.getParameter("cname");
		String s2 = request.getParameter("cname1");

		CountryVO v = new CountryVO();

		v.setCountryName(s1);
		v.setDescription(s2);

		CountryDAO d = new CountryDAO();
		d.insertCountry(v);

		response.sendRedirect("admin/addCountry.jsp");
	}
	
	protected void updateCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1 = request.getParameter("cname");
		String s2 = request.getParameter("cname1");
		int s3=Integer.parseInt(request.getParameter("countryId"));
		
		CountryVO v=new CountryVO();
		v.setCountryName(s1);
		v.setDescription(s2);
		v.setCountryId(s3);
					
		CountryDAO d=new CountryDAO();
		d.updateCountry(v);
		
		CountryDAO d1=new CountryDAO();
		List lsCountrysearch=d1.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCountrysearch", lsCountrysearch);
		
		response.sendRedirect("admin/searchCountry.jsp");
	}
}
