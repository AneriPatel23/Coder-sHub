package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

import antlr.PrintWriterWithSMAP;
import DAO.DeveloperDAO;
import DAO.ProjectDAO;
import DAO.RegisteredUserDAO;
import VO.DeveloperVO;
import VO.LoginVO;
import VO.ProjectVO;
import VO.RegisteredUserVO;


/**
 * Servlet implementation class project
 */
@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag.equals("search"))
		{
			search(request,response);
		}
		if(flag.equals("searchUser"))
		{
			searchUser(request,response);
		}
		if(flag.equals("searchProject"))
		{
			searchProject(request,response);
		}
		if(flag.equals("loadFolder"))
		{
			loadFolder(request,response);

			response.sendRedirect("admin/JSON/loadFolder.jsp");
		}
		if(flag.equals("insertFolder"))
		{
			insert(request,response);
			response.sendRedirect("userLayout/user.jsp");
		}
		if(flag.equals("inside"))
		{
			inside(request,response);
			response.sendRedirect("userLayout/user.jsp");
		}
		if(flag.equals("insideDeveloper"))
		{
			insideDeveloper(request,response);
		}
		
		if (flag.equals("write"))
		{
			writefile(request, response);

			response.sendRedirect("userLayout/user.jsp");
     	}

	}

	private void insideDeveloper(HttpServletRequest request,
			HttpServletResponse response) throws IOException 
	{
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		int id=Integer.parseInt(request.getParameter("developerName"));
		
		
		/*Integer userId=(Integer)session.getAttribute("userId");
		System.out.println(userId);
		
		*/
		
		DeveloperVO developerVO=new DeveloperVO();
		developerVO.setDeveloperId(id);
		
		DeveloperDAO developerDAO=new DeveloperDAO();
		List<DeveloperVO> ls1=developerDAO.editDeveloper(developerVO);
		
		LoginVO loginVO1=new LoginVO();
		loginVO1.setUserId(ls1.get(0).getLoginVO().getUserId());
		
		int a=ls1.get(0).getLoginVO().getUserId();
		ProjectDAO projectDAO=new ProjectDAO();
		List ls=projectDAO.searchProject(a, loginVO1);
		
		System.out.println("-------"+ls.size());
		
		session.setAttribute("projectList",ls);
		response.sendRedirect("userLayout/indexDeveloper.jsp");
		
		
	}

	private void writefile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String content=request.getParameter("code");
		String path=request.getParameter("path");
		String folderpath = getServletContext().getRealPath(request.getServletPath());
		
		int path1 = path.lastIndexOf('\\');
		
		String filename=path.substring(path1);
		
		if(filename.contains("java"))
		{

			String folderpatha = getServletContext().getRealPath(request.getServletPath());
			System.out.println("+++++++++"+folderpatha);
			int path1a = folderpath.lastIndexOf('\\');
			String classes="classes";
			String controller="controller";
			
			String path2a = "C:/Users/VIDHI/workspace/codersHubFinl/src/Controller"+filename;
			
			File f=new File(path2a);
			FileWriter file=new FileWriter(f);
			PrintWriter pw=new PrintWriter(file);
			pw.println(content);
			pw.close();
		}
		System.out.println("----------"+folderpath+path);
		System.out.println("----------"+content);
		String[] s=folderpath.split("codersHubFinl");
		String s1=s[0]+path;
		System.out.println(s1);
		File f=new File(s1);
		FileWriter file=new FileWriter(f);
		PrintWriter pw=new PrintWriter(file);
		pw.println(content);
		pw.close();
	}

	private void inside(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String s3=(String)session.getAttribute("usertype");
		System.out.println("--------_______________"+s3);
		
		if(s3.equalsIgnoreCase("company"))
		{
			String folderPath = getServletContext().getRealPath(request.getServletPath());
			int path = folderPath.lastIndexOf('\\');
			
			System.out.println("******************"+path);
			String s1=request.getParameter("projectName");
			
			session.setAttribute("projectname",s1);
			String s2=(String)session.getAttribute("userName");
			
			String path1= folderPath.substring(0, path) +"\\userWorkspace\\";
			String sq=path1+s2+"\\"+s1;
			
			System.out.println("------"+sq);
			File f=new File(sq);
			RecursiveTraversal rt=new RecursiveTraversal();
			String tree=rt.traverse1(f);
			System.out.println(tree);
			
			session.setAttribute("tree",tree);
		}
		if(s3.equalsIgnoreCase("registereedUser"))
		{
			String folderPath = getServletContext().getRealPath(request.getServletPath());
			int path = folderPath.lastIndexOf('\\');
			System.out.println("zzz------"+path);
			String s1=request.getParameter("projectName");
			
			String s2=(String)session.getAttribute("userName");
			session.setAttribute("projectname",s1);
			
			String path1= folderPath.substring(0, path) +"\\userWorkspace\\";
			String sq=path1+s2+"\\"+s1;
			
			System.out.println("------"+sq);
			File f=new File(sq);
			RecursiveTraversal rt=new RecursiveTraversal();
			String tree=rt.traverse1(f);
			System.out.println(tree);

			session.setAttribute("tree",tree);
			session.setAttribute("path31",sq);
			
			session.setAttribute("projectname",s1);
		}
		else if(s3.equalsIgnoreCase("developer"))
		{
			Integer userId=(Integer)session.getAttribute("userId");
			System.out.println(userId);
			
			LoginVO loginVO1=new LoginVO();
			loginVO1.setUserId(userId);
			
			DeveloperVO developerVO=new DeveloperVO();
			developerVO.setLoginVO(loginVO1);
			
			DeveloperDAO developerDAO=new DeveloperDAO();
			List ls=developerDAO.editDeveloper1(developerVO);
			
			developerVO=(DeveloperVO)ls.get(0);
			String companyName=developerVO.getCompanyVO().getCompanyName();
			
			
			String folderPath = getServletContext().getRealPath(request.getServletPath());
			
			int path = folderPath.lastIndexOf('\\');
			String s1=request.getParameter("projectName");
			session.setAttribute("projectname",s1);
			session.setAttribute("companyname",companyName);
			
			String s2=(String)session.getAttribute("userName");
			
			String path1= folderPath.substring(0, path) +"\\userWorkspace\\"+companyName+"\\";
			
			String w1=folderPath.substring(0, path);
			int w2 = w1.lastIndexOf('\\');
			System.out.println("******************"+w1);
			
			String w3=w1.substring(0, w2);
			
			System.out.println("+++++++++++++++++++++++"+w3);
			session.setAttribute("pathreal",w3);
			
			String sq=path1+s2+"\\"+s1;
			//System.out.println("----------------"+sq);
			int x=(w3.length())+1;
			String fin=w1.substring(x,w1.length());
			System.out.println("loooooooooooooook hereeeeeeeeeeeeeee"+fin);
			String fin1 = fin+"\\"+"\\userWorkspace\\"+companyName+"\\"+s2+"\\"+s1;
			System.out.println("dis issss d path for zip......"+fin1);
			
			File f=new File(sq);
			RecursiveTraversal rt=new RecursiveTraversal();
			String tree=rt.traverse1(f);
			//System.out.println(tree);

			session.setAttribute("projectname",s1);
			session.setAttribute("path31",sq);
			session.setAttribute("tree",tree);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag= request.getParameter("flag");
		System.out.println(flag);
		if(flag.equals("insert"))
		{
			insert(request,response);
			response.sendRedirect("admin/addProject.jsp");
		}
		if(flag.equals("createProject"))
		{
			createProject(request, response);
			response.sendRedirect("userLayout/index.jsp");
		}
		if(flag.equals("foldername"))
		{
			createFolder(request, response);
			response.sendRedirect("userLayout/user.jsp");
		}
		if(flag.equals("filename"))
		{
			createFile(request, response);
			response.sendRedirect("userLayout/user.jsp");
		}
		if(flag.equals("deletefile"))
		{
			deleteFile(request, response);
			response.sendRedirect("userLayout/user.jsp");
		}

	}
	
	private void deleteFile(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path=request.getParameter("path1");
		
		String path2="C:\\Users\\VIDHI\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp4\\wtpwebapps";
		String path3=path2+path;
		System.out.println("ooooooooooooooooooo"+path3);
		File f1 = new File(path3);
		f1.delete();
		
		
		
	}

	private void createFile(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		
		String fileName=request.getParameter("fileName");
		System.out.println(fileName);
		String path=request.getParameter("path1");
		session.setAttribute("path1", path);
		String utype=(String) session.getAttribute("usertype");
	//	String path=request.getParameter("file");
		System.out.println(path);
		
		String s1=path+"\\";
		File f=new File(s1+fileName);
		
		if(!f.createNewFile())
		{
			f.createNewFile();
			System.out.println("done file created");
		}
		String companyname = (String) session.getAttribute("companyname");
		String username = (String) session.getAttribute("userName");
		String projectname=(String) session.getAttribute("projectname");
		System.out.println(companyname);
		System.out.println(username);
		System.out.println(projectname);
		 if(utype.equalsIgnoreCase("developer"))
		 {
		
		String folderpath = getServletContext().getRealPath(request.getServletPath());
		int path1 = folderpath.lastIndexOf('\\');
		String path2 = folderpath.substring(0, path1) + "\\userWorkspace\\" + companyname +"\\"+ username+"\\"+ projectname+"\\";
		File f1 = new File(path2);
		
	
		RecursiveTraversal rt=new RecursiveTraversal();
		String ls1=rt.traverse1(f1);
		
		
		session.setAttribute("tree", ls1);
		
		if(fileName.contains("java"))
		{
			String folderpatha = getServletContext().getRealPath(request.getServletPath());
			System.out.println("+++++++++"+folderpatha);
			int path1a = folderpath.lastIndexOf('\\');
			String classes="classes";
			String controller="controller";
			
			String path2a = "C:/Users/VIDHI/workspace/codersHubFinl/src/Controller";
			System.out.println("********"+path2a);
			
			
			String sCurrentLine;
			String store="";
			BufferedReader br = null;
			br = new BufferedReader(new FileReader("C:\\Users\\VIDHI\\workspace\\codersHubFinl\\src\\controller\\index.java"));

			System.err.println("-------"+path2a+"//"+fileName);
			int a=fileName.lastIndexOf(".");
			String a1=fileName.substring(0,a);
			while ((sCurrentLine = br.readLine()) != null) 
			{
				if(sCurrentLine.contains("@WebServlet"))
				{
					sCurrentLine="@WebServlet(\"/"+a1+"\")";
				}
				if(sCurrentLine.contains("index"))
				{
					sCurrentLine="public class "+a1+" extends HttpServlet {";
				}
				
				store=store+"\n"+sCurrentLine;
				System.out.println(sCurrentLine);
				String content = store;
				File fa=new File(path2a+"\\"+fileName);
				if(!fa.createNewFile())
				{
					fa.createNewFile();
				}
				if(!f.createNewFile())
				{
					f.createNewFile();
					System.out.println("done file created");
				}
				
				FileWriter fw = new FileWriter(fa.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content+"\n");
				bw.newLine();
				bw.close();
				
				FileWriter fw1 = new FileWriter(f.getAbsoluteFile());
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write(content+"\n");
				bw1.newLine();
				bw1.close();
			}
			
				
		}
		else
		{
			if(!f.createNewFile())
			{
				f.createNewFile();
				System.out.println("done file created");
			}
			
		}
		
		
		System.out.println("in developer..method called");
		 }
		 else if(utype.equalsIgnoreCase("registereeduser"))
		 {
			 String folderpath = getServletContext().getRealPath(request.getServletPath());
				int path1 = folderpath.lastIndexOf('\\');
				String path2 = folderpath.substring(0, path1) + "\\userWorkspace\\" + username +"\\"+ projectname+"\\";
				File f1 = new File(path2);
				
			
				RecursiveTraversal rt=new RecursiveTraversal();
				String ls1=rt.traverse1(f1);
				
				
				session.setAttribute("tree", ls1);
				
				System.out.println("in reg user...method called");
					 
		 }
	
	
		
	
		
	}
	private void createFolder(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{	
		System.out.println("hello");
		HttpSession session = request.getSession();
		
		String folderName=request.getParameter("folderName1");
		 
		String path=request.getParameter("path1");
		System.out.println(path);
		
		String s1=path+"\\";
		File f=new File(s1+folderName);
		if(!f.mkdir())
		{
			f.mkdir();
		}
		HttpSession session1=request.getSession();
		String companyname = (String) session.getAttribute("companyname");
		String username = (String) session.getAttribute("userName");
		String projectname=(String) session.getAttribute("projectname");
		System.out.println(companyname);
		System.out.println(username);
		System.out.println(projectname);
		String utype=(String) session1.getAttribute("usertype");
		
		if(utype.equalsIgnoreCase("developer"))
		{
		String folderpath = getServletContext().getRealPath(request.getServletPath());
		int path1 = folderpath.lastIndexOf('\\');
		String path2 = folderpath.substring(0, path1) + "\\userWorkspace\\" +companyname+"\\"+ username +"\\"+ projectname+"\\";
		File f1 = new File(path2);
		
		
		
		
	/*	String path3 = "C:\\Users\\VIDHI\\workspace\\codersHubFinl\\src\\";
		File f3 = new File(path3);*/
		System.out.println("metadata path---------9999999999999999"+path2);
		
		//System.out.println("src path---------888888888888"+path3);
	
		RecursiveTraversal rt=new RecursiveTraversal();
		String ls1=rt.traverse1(f1);
	
		session.setAttribute("tree", ls1);
		
		
		
		
		System.out.println("in developer...method called");
		}
		
		else if(utype.equalsIgnoreCase("registereeduser"))
		{
			String folderpath = getServletContext().getRealPath(request.getServletPath());
			int path1 = folderpath.lastIndexOf('\\');
			String path2 = folderpath.substring(0, path1) + "\\userWorkspace\\"+ username +"\\"+ projectname+"\\";
			File f1 = new File(path2);
			
			System.out.println("---------"+path2);
		
			RecursiveTraversal rt=new RecursiveTraversal();
			String ls1=rt.traverse1(f1);
			
			
			session.setAttribute("tree", ls1);
			
			System.out.println("in reg user...method called");
		}
		
	}
	private void createProject(HttpServletRequest request,
			HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Integer i=(Integer)session.getAttribute("userId");

		String s1=request.getParameter("cname");
		System.out.println("Folder Name :: "+s1);
		LoginVO loginVO= new LoginVO();
		loginVO.setUserId(i);
		
		ProjectVO v=new ProjectVO();
		v.setProjectName(s1);
		
		v.setLoginVO(loginVO);
		
		String s2=(String)session.getAttribute("userName");
		String s3=(String)session.getAttribute("usertype");
	
		
		ProjectDAO d=new ProjectDAO();
		d.insert(v);
		if(s3.equalsIgnoreCase("registereedUser"))
		{
		String folderPath = getServletContext().getRealPath(request.getServletPath());

		System.out.println(">> getServletContext : "+getServletContext());
		System.out.println(">> Servlet Path : "+getServletContext().getRealPath(request.getServletPath()));

		int path = folderPath.lastIndexOf('\\');
		System.out.println(">> path : "+path);

		String path1= folderPath.substring(0, path) +"\\userWorkspace\\";
		System.out.println(">> path1 : "+path1);
		String sq=path1+s2+"\\"+s1;
		System.out.println(sq);
		File targetFile = new File(path1+s2+"\\"+s1);
		System.out.println("===="+targetFile);

		if (!targetFile.exists()) {
			if (targetFile.mkdir()) {
				System.out.println("***********Proj namne Directory is created!************");
				File src=new File(path1+s2+"\\"+s1+"\\src");
				src.mkdir();
				File webcontent=new File(path1+s2+"\\"+s1+"\\webcontent");
				webcontent.mkdir();
			} else {
				System.out.println("************Proj Name Failed to create directory!**************");
			}
		}
		}
		else if(s3.equalsIgnoreCase("developer"))
		{
			Integer userId=(Integer)session.getAttribute("userId");
			System.out.println(userId);
			
			LoginVO loginVO1=new LoginVO();
			loginVO1.setUserId(userId);
			
			DeveloperVO developerVO=new DeveloperVO();
			developerVO.setLoginVO(loginVO1);
			
			DeveloperDAO developerDAO=new DeveloperDAO();
			List ls=developerDAO.editDeveloper1(developerVO);
			
			developerVO=(DeveloperVO)ls.get(0);
			String companyName=developerVO.getCompanyVO().getCompanyName();
			
			String folderPath = getServletContext().getRealPath(request.getServletPath());

			System.out.println(">> getServletContext : "+getServletContext());
			System.out.println(">> Servlet Path : "+getServletContext().getRealPath(request.getServletPath()));

			int path = folderPath.lastIndexOf('\\');
			System.out.println(">> path : "+path);

			String path1= folderPath.substring(0, path) +"\\userWorkspace\\"+companyName+"\\";
			System.out.println(">>> path1 : "+path1);
			String sq=path1+s2+"\\"+s1;
			System.out.println(sq);
			File targetFile = new File(path1+s2+"\\"+s1);
			System.out.println("===="+targetFile);

			if (!targetFile.exists()) {
				if (targetFile.mkdir()) {
					System.out.println("***********Proj namne Directory is created!************");
					try {
						File src=new File(path1+s2+"\\"+s1+"\\src");
						src.mkdir();
						File webcontent=new File(path1+s2+"\\"+s1+"\\webcontent");
						webcontent.mkdir();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("************Proj Name Failed to create directory!**************");
				}
			}

		}
	}

	//methods
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		LoginVO loginVO=new LoginVO();
		ProjectDAO d=new ProjectDAO();
		List l=d.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("abc", l);
		
		response.sendRedirect("admin/searchProject.jsp");
	}
	protected void searchProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		int s1=Integer.parseInt(request.getParameter("userId"));
		System.out.println("yesssssssssssss"+s1);
			
		HttpSession session = request.getSession();
	
		ProjectDAO d=new ProjectDAO();
		LoginVO loginVO=new LoginVO();
		List l=d.searchProject(s1,loginVO);			
		session.setAttribute("lsSearchProject", l);
		response.sendRedirect("admin/searchProject.jsp");
	}
	protected void searchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LoginVO loginVO=new LoginVO();
		ProjectDAO d=new ProjectDAO();
		List lsSearchUser=d.searchUser(loginVO);
		HttpSession session=request.getSession();
		session.setAttribute("lsSearchUser", lsSearchUser);
		
		response.sendRedirect("admin/searchWorkspace.jsp");
	}
	protected void loadFolder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		LoginVO user = (LoginVO) session.getAttribute("user");
		
		
		System.out.print("loaddd");
		ProjectDAO d=new ProjectDAO();
		List l=d.searchProjectFromUserId(user);
		
		session.setAttribute("lsLoadFolder", l);
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int s1=Integer.parseInt(request.getParameter("projectId"));
		
		ProjectVO v=new ProjectVO();
		v.setProjectId(s1);
		
		ProjectDAO d=new ProjectDAO();
		d.delete(v);
		
		response.sendRedirect("admin/searchProject.jsp");
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int s1=Integer.parseInt(request.getParameter("projectId"));
		
		ProjectVO v=new ProjectVO();
		v.setProjectId(s1);
		
		ProjectDAO d=new ProjectDAO();
		List l=d.edit(v);
		
		HttpSession session=request.getSession();
		session.setAttribute("pqr", l);
		
		response.sendRedirect("admin/editProject.jsp");
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session=request.getSession();
		Integer i=(Integer)session.getAttribute("userId");

		String s1=request.getParameter("cname");
		System.out.println("Folder Name :: "+s1);
		LoginVO loginVO= new LoginVO();
		loginVO.setUserId(i);
		
		ProjectVO v=new ProjectVO();
		v.setProjectName(s1);
		
		v.setLoginVO(loginVO);
		
		String s2=(String)session.getAttribute("userName");
		String s3=(String)session.getAttribute("usertype");
	
	System.out.println("usertypeeeeee"+s3);
	
	if(s3.equals("registereedUser"))
	
	{
	String folderPath = getServletContext().getRealPath(request.getServletPath());

	System.out.println(">> getServletContext : "+getServletContext());
	System.out.println(">> Servlet Path : "+getServletContext().getRealPath(request.getServletPath()));

	int path = folderPath.lastIndexOf('\\');
	System.out.println(">> path : "+path);

	String path1= folderPath.substring(0, path) +"\\userWorkspace\\";
	System.out.println(">> path1 : "+path1);
	String sq=path1+s2+"\\"+s1;
	System.out.println(sq);
	File targetFile = new File(path1+s2+"\\"+s1);
	System.out.println("===="+targetFile);

	if (!targetFile.exists()) {
		if (targetFile.mkdir()) {
			System.out.println("***********Proj namne Directory is created!************");
			File src=new File(path1+s2+"\\"+s1+"\\src");
			src.mkdir();
			File webcontent=new File(path1+s2+"\\"+s1+"\\webcontent");
			webcontent.mkdir();
		} else {
			System.out.println("************Proj Name Failed to create directory!**************");
		}
	}
	RecursiveTraversal rt=new RecursiveTraversal();
	String lt=rt.traverse1(targetFile);
	System.out.println("...."+lt);
	session.setAttribute("tree",lt);
	


	}
	else if(s3.equals("developer"))
	{
		System.out.println("in developerrrrrrrrrrr");
		
		Integer userId=(Integer)session.getAttribute("userId");
		System.out.println(userId);
		
		LoginVO loginVO1=new LoginVO();
		loginVO1.setUserId(userId);
		
		DeveloperVO developerVO=new DeveloperVO();
		developerVO.setLoginVO(loginVO1);
		
		DeveloperDAO developerDAO=new DeveloperDAO();
		List ls=developerDAO.editDeveloper1(developerVO);
		
		developerVO=(DeveloperVO)ls.get(0);
		String companyName=developerVO.getCompanyVO().getCompanyName();
		
		String folderPath = getServletContext().getRealPath(request.getServletPath());

		System.out.println(">> getServletContext : "+getServletContext());
		System.out.println(">> Servlet Path : "+getServletContext().getRealPath(request.getServletPath()));

		int path = folderPath.lastIndexOf('\\');
		System.out.println(">> path : "+path);

		String path1= folderPath.substring(0, path) +"\\userWorkspace\\" +companyName+"\\";
		System.out.println(">> path1 : "+path1+s2+"\\"+s1);

		File targetFile = new File(path1+s2+"\\"+s1);

		System.out.println("===="+targetFile);
		if (!targetFile.exists()) {
			if (targetFile.mkdir()) {
				System.out.println("***********Proj namne Directory is created!************");
				File src=new File(path1+s2+"\\"+s1+"\\src");
				src.mkdir();
				File webcontent=new File(path1+s2+"\\"+s1+"\\webcontent");
				webcontent.mkdir();
				
			} else {
				System.out.println("************Proj Name Failed to create directory!**************");
			}
		}
		
		RecursiveTraversal rt=new RecursiveTraversal();
		String lt=rt.traverse1(targetFile);
		System.out.println("...."+lt);
		
		session.setAttribute("tree",lt);
		

	}
	ProjectDAO d=new ProjectDAO();
	d.insert(v);
		
	}
	
	/*protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String s1=request.getParameter("cname");
		
		int s2=Integer.parseInt(request.getParameter("projectId"));
	
		ProjectVO v=new ProjectVO();
		v.setProjectId(s2);
		
		ProjectDAO d=new ProjectDAO();
		d.update(v);
		
		ProjectDAO d1=new ProjectDAO();
		List l=d1.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("abc", l);
		
		response.sendRedirect("admin/searchProject.jsp");
	}*/
	
	}

