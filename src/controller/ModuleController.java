package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ModuleDAO;
import DAO.ProjectDAO;
import VO.LoginVO;
import VO.ModuleVO;
import VO.ProjectVO;


/**
 * Servlet implementation class module
 */
@WebServlet("/ModuleController")
public class ModuleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleController() {
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
		else if(flag.equals("insertModule"))
		{
			insertModule(request,response);
			response.sendRedirect("userLayout/user.jsp");
		}
		else if(flag!=null && flag.equals("search1"))
		{
			search1(request,response);
		}

		else if(flag.equals("delete"))
		{
			delete(request,response);
		}
		else if(flag.equals("edit"))
		{
			edit(request,response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		
		if(flag.equals("insert"))
		{
			insert(request,response);
		}
		
		else if(flag.equals("update"))
		{
			update(request,response);
		}

	}
	
	//methods
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProjectDAO d=new ProjectDAO();
		List l=d.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("abc", l);
		
		response.sendRedirect("admin/addModule.jsp");
	}
	protected void search1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ModuleDAO d=new ModuleDAO();
		List l=d.search1();
		
		HttpSession session=request.getSession();
		session.setAttribute("abc", l);
		
		response.sendRedirect("admin/searchModule.jsp");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("moduleId"));
		
		ModuleVO v=new ModuleVO();
		v.setModuleId(s1);
		
		ModuleDAO d=new ModuleDAO();
		d.delete(v);
		
		response.sendRedirect("admin/searchModule.jsp");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("moduleId"));
		
		ModuleVO v=new ModuleVO();
		v.setModuleId(s1);
		
		ModuleDAO d=new ModuleDAO();
		List l=d.edit(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("pqr", l);
		
		ProjectDAO pDAO=new ProjectDAO();
		List projectList=pDAO.search();
		session.setAttribute("projectList", projectList);

		response.sendRedirect("admin/editModule.jsp");
	}
	protected void insertModule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname1");
		Integer i=Integer.parseInt(request.getParameter("projId"));
		System.out.print("ridhuuuuuu"+i+s1);
		
		HttpSession session=request.getSession();
			
		
				
		ProjectVO v1=new ProjectVO();
	
		v1.setProjectId(i);
		
		ModuleVO v=new ModuleVO();
		v.setModuleName(s1);
		v.setPv(v1);
		
		ModuleDAO d=new ModuleDAO();
		d.insert(v);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String s1=request.getParameter("cname1");
		Integer i1=Integer.parseInt(request.getParameter("projectDrop"));
		ProjectVO v1=new ProjectVO();
		v1.setProjectId(i1);
		
		ModuleVO v=new ModuleVO();
		v.setModuleName(s1);
		v.setPv(v1);
		
		ModuleDAO d=new ModuleDAO();
		d.insert(v);
		
		response.sendRedirect("admin/addModule.jsp");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname1");

		int s2=Integer.parseInt(request.getParameter("moduleId"));
		Integer i1=Integer.parseInt(request.getParameter("projectDrop"));
		ProjectVO v1=new ProjectVO();
		v1.setProjectId(i1);
	
		ModuleVO v=new ModuleVO();
		v.setModuleName(s1);
		v.setModuleId(s2);
		v.setPv(v1);
	
		ModuleDAO d=new ModuleDAO();
		d.update(v);
	
		ModuleDAO d1=new ModuleDAO();
		List l=d1.search1();
	
		HttpSession session=request.getSession();
		session.setAttribute("abc",l);
	
		response.sendRedirect("admin/searchModule.jsp");
	}
}

