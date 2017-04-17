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

import DAO.StateDAO;
import VO.CountryVO;

import VO.StateVO;

/**
 * Servlet implementation class state
 */
@WebServlet("/StateController")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		if(flag!=null && flag.equals("search"))
		{
			search(request,response);
		}
		else if(flag!=null && flag.equals("search1"))
		{
			search1(request,response);
		}
		else if(flag.equals("deleteState"))
		{
			deleteState(request,response);
		}
		else if(flag.equals("editState"))
		{
			editState(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		
		
		if(flag.equals("insertState"))
		{
			insertState(request,response);
		}
		else if(flag.equals("updateState"))
		{
			updateState(request,response);
		}

	
	}
	
	//methods
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CountryDAO d=new CountryDAO();
		List lsCountrysearch=d.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsCountrysearch", lsCountrysearch);
		
		response.sendRedirect("admin/addState.jsp");
	}
	
	protected void search1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StateDAO d=new StateDAO();
		List lsStatesearch=d.search1();
	
		HttpSession session=request.getSession();
		session.setAttribute("lsStatesearch", lsStatesearch);
	
		response.sendRedirect("admin/searchState.jsp");

	}
	
	protected void deleteState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("stateId"));
		
		StateVO v=new StateVO();
		v.setStateId(s1);
		
		StateDAO d=new StateDAO();
		d.deleteState(v);
		
		response.sendRedirect("admin/searchState.jsp");
	}
	
	protected void editState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int s1=Integer.parseInt(request.getParameter("stateId"));
		
		StateVO v=new StateVO();
		v.setStateId(s1);
		
		StateDAO d=new StateDAO();
		List lsStateedit=d.editState(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("lsStateedit", lsStateedit);
		
		CountryDAO cDAO = new CountryDAO();
		List countryList=cDAO.search();
		
		session.setAttribute("countryList", countryList);
		
		response.sendRedirect("admin/editState.jsp");
	}
	
	protected void insertState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String s1=request.getParameter("cname");
		String s2=request.getParameter("cname1");
		
		Integer i1= Integer.parseInt(request.getParameter("countryDrop"));
		
		
		CountryVO v1=new CountryVO();
		v1.setCountryId(i1);
		
		StateVO v=new StateVO();
		v.setStateName(s1);
		v.setDescription(s2);
		v.setCv(v1);
		
		
		StateDAO d=new StateDAO();
		d.insertState(v);
		
		
		response.sendRedirect("admin/addState.jsp");
	}
	
	protected void updateState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1 = request.getParameter("cname");
		String s2 = request.getParameter("cname1");
		int s3=Integer.parseInt(request.getParameter("stateId"));
		
		Integer i1= Integer.parseInt(request.getParameter("countryDrop"));
		
		CountryVO v1=new CountryVO();
		v1.setCountryId(i1);
		
		StateVO v=new StateVO();
		v.setStateName(s1);
		v.setDescription(s2);
		v.setStateId(s3);
		v.setCv(v1);
		
		
		StateDAO d=new StateDAO();
		d.updateState(v);
		
		StateDAO d1=new StateDAO();
		List lsStatesearch=d1.search1();
		
		HttpSession session=request.getSession();
		session.setAttribute("lsStatesearch", lsStatesearch);
		
		response.sendRedirect("admin/searchState.jsp");
	}

}
