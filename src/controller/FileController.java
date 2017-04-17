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
import DAO.FileDAO;
import DAO.ModuleDAO;
import DAO.ProjectDAO;
import VO.CountryVO;
import VO.FileVO;
import VO.ModuleVO;
import VO.ProjectVO;


/**
 * Servlet implementation class module
 */
@WebServlet("/FileController")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileController() {
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
		else if(flag!=null && flag.equals("search2"))
		{
			search2(request,response);
		}

		else if(flag.equals("delete"))
		{
			delete(request,response);
		}
		else if(flag!=null && flag.equals("loadModule"))
		{
			loadModule(request,response);
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
		response.sendRedirect("admin/addFile.jsp");
		
		
	}
	
	protected void search2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		FileDAO d=new FileDAO();
		List l=d.search2();
		
		HttpSession session=request.getSession();
		session.setAttribute("abc", l);
		
		response.sendRedirect("admin/searchFile.jsp");
	}
	
	protected void loadModule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer projectId=Integer.parseInt(request.getParameter("projectId"));
		ProjectVO projectVO=new ProjectVO();
		projectVO.setProjectId(projectId);
		
		FileDAO d=new FileDAO();
		List lsLoadModule=d.loadModule(projectVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("lsLoadModule", lsLoadModule);
		
		response.sendRedirect("admin/JSON/loadModule.jsp");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("fileId"));
		
		FileVO v=new FileVO();
		v.setFileId(s1);
		
		FileDAO d=new FileDAO();
		d.delete(v);
		
		response.sendRedirect("admin/searchFile.jsp");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int s1=Integer.parseInt(request.getParameter("fileId"));
		
		FileVO v=new FileVO();
		v.setFileId(s1);
		
		FileDAO d=new FileDAO();
		List l=d.edit(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("pqr", l);
		
		ProjectDAO pDAO=new ProjectDAO();
		List projectList=pDAO.search();
		session.setAttribute("projectList", projectList);
		
		ModuleDAO mDAO=new ModuleDAO();
		List moduleList=mDAO.search1();
		session.setAttribute("moduleList", moduleList);

		response.sendRedirect("admin/editFile.jsp");
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname2");
		Integer i1=Integer.parseInt(request.getParameter("projectDrop"));
		Integer i2=Integer.parseInt(request.getParameter("moduleDrop"));
		
		ProjectVO v1=new ProjectVO();
		v1.setProjectId(i1);
		
		ModuleVO v2=new ModuleVO();
		v2.setModuleId(i2);
		
		FileVO f=new FileVO();
		f.setFileName(s1);
		f.setPv(v1);
		f.setMv(v2);
		
		FileDAO d=new FileDAO();
		d.insert(f);
		
		response.sendRedirect("admin/addFile.jsp");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname2");

		int s2=Integer.parseInt(request.getParameter("fileId"));
		Integer i1=Integer.parseInt(request.getParameter("projectDrop"));
		Integer i2=Integer.parseInt(request.getParameter("moduleDrop"));
		
		ProjectVO v1=new ProjectVO();
		v1.setProjectId(i1);
		
		ModuleVO v2=new ModuleVO();
		v2.setModuleId(i2);
		
		FileVO f=new FileVO();
		f.setFileName(s1);
		f.setFileId(s2);
		f.setPv(v1);
		f.setMv(v2);
	
		FileDAO d=new FileDAO();
		d.update(f);
	
		FileDAO d1=new FileDAO();
		List l=d1.search2();
	
		HttpSession session=request.getSession();
		session.setAttribute("abc",l);
	
		response.sendRedirect("admin/searchFile.jsp");
	}
}

