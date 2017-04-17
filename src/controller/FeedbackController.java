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

import DAO.FeedbackDAO;
import DAO.LoginDAO;
import VO.FeedbackVO;
import VO.LoginVO;


/**
 * Servlet implementation class project
 */
@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchFeedback"))
		{
			searchFeedback(request,response);
		}
		else if(flag.equals("deleteFeedback"))
		{
			deleteFeedback(request,response);
		}
		else if(flag.equals("searchAdmin"))
		{
			searchAdmin(request, response);
		}
		/*else if(flag.equals("edit"))
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
		
		if(flag.equals("insertFeedback"))
		{
			insertFeedback(request,response);
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
		
		response.sendRedirect("userLayout/addFeedback.jsp");
	}

	//methods
	
	protected void searchFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		FeedbackDAO d=new FeedbackDAO();
		List lsFeedbacksearch=d.searchFeedback();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsFeedbacksearch", lsFeedbacksearch);
		
		response.sendRedirect("admin/searchFeedback.jsp");
	}
	
	protected void deleteFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("feedbackId"));
		
		FeedbackVO v=new FeedbackVO();
		v.setFeedbackId(s1);
		
		FeedbackDAO d=new FeedbackDAO();
		d.deleteFeedback(v);
		
		response.sendRedirect("searchFeedback.jsp");
	}
	
	/*protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("feedbackId"));
		
		FeedbackVO v=new FeedbackVO();
		v.setFeedbackId(s1);
		
		FeedbackDAO d=new FeedbackDAO();
		List l=d.edit(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("pqr", l);
		
		response.sendRedirect("admin/editFeedback.jsp");
	}*/
	
	protected void insertFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname");
		int fromId=Integer.parseInt(request.getParameter("fromUser"));
		int toId=Integer.parseInt(request.getParameter("toUser"));
		
		LoginVO loginVO = new LoginVO();
		loginVO.setUserId(toId);
		
		LoginVO loginVO1=new LoginVO();
		loginVO1.setUserId(fromId);
		
		FeedbackVO v=new FeedbackVO();
		v.setFeedback(s1);
		v.setFromUserId(loginVO1);
		v.setToUserId(loginVO);
		
		FeedbackDAO d=new FeedbackDAO();
		d.insertFeedback(v);
		
		response.sendRedirect("userLayout/index.jsp");
	}
	
	/*protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname");
		
		int s2=Integer.parseInt(request.getParameter("feedbackId"));
	
		FeedbackVO v=new FeedbackVO();
		v.setFeedback(s1);
		v.setFeedbackId(s2);
		
		FeedbackDAO d=new FeedbackDAO();
		d.update(v);
		
		FeedbackDAO d1=new FeedbackDAO();
		List l=d1.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("abc", l);
		
		response.sendRedirect("admin/searchFeedback.jsp");
	}*/
}
