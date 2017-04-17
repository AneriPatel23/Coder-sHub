package controller;

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

import DAO.DatabaseDAO;

import VO.DatabaseVO;


/**
 * Servlet implementation class project
 */
@WebServlet("/DatabaseController")
public class DatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchDatabase"))
		{
			searchDatabase(request,response);
		}
		/*else if(flag.equals("delete"))
		{
			delete(request,response);
		}
		else if(flag.equals("edit"))
		{
			edit(request,response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		
		if(flag.equals("insertDatabase"))
		{
			insertDatabase(request,response);
		}
	/*	else if(flag.equals("update"))
		{
			update(request,response);	
		}*/
	}
		//methods
		
		protected void searchDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			DatabaseDAO d=new DatabaseDAO();
			List lsDatabasesearch=d.searchDatabase();
			
			HttpSession session=request.getSession();
			session.setAttribute("lsDatabasesearch", lsDatabasesearch);
			
			response.sendRedirect("admin/searchDatabase.jsp");
		}
		
		/*  protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			int s1=Integer.parseInt(request.getParameter("databaseId"));
			
			DatabaseVO v=new DatabaseVO();
			v.setDatabaseId(s1);
			
			DatabaseDAO d=new DatabaseDAO();
			d.delete(v);
			
			response.sendRedirect("admin/searchDatabase.jsp");
		}
		
		protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			int s1=Integer.parseInt(request.getParameter("databaseId"));
			
			DatabaseVO v=new DatabaseVO();
			v.setDatabaseId(s1);
			
			DatabaseDAO d=new DatabaseDAO();
			List l=d.edit(v);
			
			HttpSession session=request.getSession();
			session.setAttribute("pqr", l);
			
			response.sendRedirect("admin/editDatabase.jsp");
		}  */

		protected void insertDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String s1=request.getParameter("cname1");
			
			DatabaseVO v=new DatabaseVO();
			v.setDatabaseName(s1);
			
			DatabaseDAO d=new DatabaseDAO();
			d.insertDatabase(v);
			
			response.sendRedirect("admin/addDatabase.jsp");
		}
		
	/*	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String s1=request.getParameter("cname1");
			
			int s2=Integer.parseInt(request.getParameter("databaseId"));
		
			DatabaseVO v=new DatabaseVO();
			v.setDatabaseName(s1);
			v.setDatabaseId(s2);
			
			
			DatabaseDAO d=new DatabaseDAO();
			d.update(v);
			
			DatabaseDAO d1=new DatabaseDAO();
			List l=d1.search();
			
			HttpSession session=request.getSession();
			session.setAttribute("abc", l);
			
			response.sendRedirect("admin/searchDatabase.jsp");
		}  */
	}

