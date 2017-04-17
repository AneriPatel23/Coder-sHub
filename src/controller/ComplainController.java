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

import DAO.ComplainDAO;
import DAO.LoginDAO;
import VO.ComplainVO;
import VO.LoginVO;


/**
 * Servlet implementation class project
 */
@WebServlet("/ComplainController")
public class ComplainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchComplain"))
		{
			searchComplain(request, response);
		}
		
		else if(flag.equals("deleteComplain"))
		{
			deleteComplain(request, response);
			
		}
		else if(flag.equals("searchAdmin"))
		{
			searchAdmin(request,response);
		}
		/*else if(flag.equals("edit"))
		{
			edit(request, response);
			
			
		}*/
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		
		if(flag.equals("insertComplain"))
		{
			insertComplain(request,response);
			response.sendRedirect("userLayout/index.jsp");
		}
		
	/*	else if(flag.equals("update"))
		{
			update(request,response);
				
		}*/
		
	}
	protected void searchAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LoginDAO d=new LoginDAO();
		List ls=d.complainAdmin();
		
		HttpSession session=request.getSession();
		session.setAttribute("adminlist", ls);
		
		response.sendRedirect("userLayout/addComplain.jsp");
	}

	//methods
	
	protected void searchComplain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ComplainDAO d=new ComplainDAO();
		List lsComplainsearch=d.searchComplain();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsComplainsearch", lsComplainsearch);
		
		response.sendRedirect("admin/searchComplain.jsp");
	}
	
	
	protected void deleteComplain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("complainId"));
		
		ComplainVO v=new ComplainVO();
		v.setComplainId(s1);
		
		ComplainDAO d=new ComplainDAO();
		d.deleteComplain(v);
		
		response.sendRedirect("admin/searchComplain.jsp");
	}
	
	/*protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("complainId"));
		
		ComplainVO v=new ComplainVO();
		v.setComplainId(s1);
		
		ComplainDAO d=new ComplainDAO();
		List l=d.edit(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("pqr", l);
		
		response.sendRedirect("admin/editComplain.jsp");
	}*/
	
	protected void insertComplain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s3=request.getParameter("cname2");
		int fromId=Integer.parseInt(request.getParameter("fromUser"));
		int toId=Integer.parseInt(request.getParameter("toUser"));
		
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(toId);
		
		LoginVO loginVO1=new LoginVO();
		loginVO1.setUserId(fromId);
		
		ComplainVO v=new ComplainVO();
		v.setSubject(s1);
		v.setDescription(s2);
		v.setOther(s3);
		v.setFromUserId(loginVO1);
		v.setToUserId(loginVO);
		
		ComplainDAO d=new ComplainDAO();
		d.insertComplain(v);
		
	
	}
	
	/*protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		String s3=request.getParameter("cname2");
		int s4=Integer.parseInt(request.getParameter("complainId"));
	
		ComplainVO v=new ComplainVO();
		v.setSubject(s1);
		v.setDescription(s2);
		v.setOther(s3);
		v.setComplainId(s4);
	
		ComplainDAO d=new ComplainDAO();
		d.update(v);
	
		ComplainDAO d1=new ComplainDAO();
		List l=d1.search();
	
		HttpSession session=request.getSession();
		session.setAttribute("abc", l);
	
		response.sendRedirect("admin/searchComplain.jsp");
	}*/
}
