package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAO.DeveloperDAO;
import DAO.LoginDAO;
import DAO.ProjectDAO;
import VO.DeveloperVO;
import VO.LoginVO;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpSession session =((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		String flag = request.getParameter("flag");
		System.out.println("registration flag===" + flag);
		//	int i = (Integer)session.getAttribute("userID");
		//System.out.println("id = = = = =" + i);
		String uri = ((HttpServletRequest)request).getRequestURI();

		System.out.println("link =  = = = = " + uri);

		if(uri.contains("add")||uri.contains("loadDeveloper.jsp")||uri.contains("index1.jsp")||uri.contains("index.html")||uri.contains("Registration")||uri.contains(".css")||uri.contains("forgotPassword.jsp")||uri.contains("ForgotPasswordController")||uri.contains("ProjectController")||uri.contains("ModuleController")||uri.contains("CompanyController")||uri.contains("ComplainController")||uri.contains("RegisterUserController")||uri.contains("RegisterDeveloperController")||uri.contains("registerDeveloper.jsp")||uri.contains("ProjectController")|| uri.contains(".js") && !uri.contains(".jsp")|| uri.contains("/img")|| uri.contains("/images")|| uri.contains("/fonts") || uri.contains("loadState.jsp")||uri.contains("loadFolder.jsp")||uri.contains("registerUser.jsp")||uri.contains("registerCompany.jsp")|| uri.contains("loadModule.jsp") || uri.contains("/icons"))
		{	System.out.println("PASS :::::::link =  = = = = " + uri);

			System.err.println("inside reg");
			chain.doFilter(request,response);
		}

		else if (flag!= null && flag.equals("logout")) {
			//session.removeAttribute("userID");
			System.out.println("logout in else if");

			session.invalidate();
			System.out.println("after session invalidates");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/admin/login.jsp");
			rd.forward(request, response);
		}
		else if(flag != null && flag.equals("login") )
		{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			PrintWriter out=response.getWriter();
			out.println(userName+""+password);

			LoginVO loginVO = new LoginVO();
			loginVO.setUserName(userName);
			loginVO.setPassword(password);

			LoginDAO loginDAO = new LoginDAO();
			List list =  loginDAO.authentication(loginVO);

			if(list != null && list.size()>=1){

				//while(itr.hasNext()){
				LoginVO user=(LoginVO) list.get(0);

				session.setAttribute("user", user);
				
				int y = (Integer)user.getUserId();
				session.setAttribute("userId",y);

				System.out.println(user.getUserType());
				System.out.println("user id : "+session.getAttribute("userId"));
				String type = user.getUserType();
				
				session.setAttribute("usertype",type);
				String uName=user.getUserName();
				session.setAttribute("userName",uName);
				System.out.println(y);
				
				if(type.equals("admin"))
				{
					LoginDAO loginDAO2=new LoginDAO();
					List listuser=loginDAO2.searchRegisteredUser();
					
					HttpSession session2=((HttpServletRequest)request).getSession();
					session2.setAttribute("registeredUserCountList", listuser.size());
					
					LoginDAO loginDAO3=new LoginDAO();
					List listdev=loginDAO3.searchDeveloper();
					
					HttpSession session3=((HttpServletRequest)request).getSession();
					session3.setAttribute("developerList", listdev.size());
					
					
					LoginDAO loginDAO4=new LoginDAO();
					List listcomp=loginDAO4.searchCompany();
					
					HttpSession session4=((HttpServletRequest)request).getSession();
					session4.setAttribute("companyList", listcomp.size());
					
					LoginDAO loginDAO5=new LoginDAO();
					List totalUser=loginDAO4.searchUser();
					
					HttpSession session5=((HttpServletRequest)request).getSession();
					session5.setAttribute("userList", totalUser.size());
					
					
					
					
					requestDispatcher = request.getRequestDispatcher("/admin/index.jsp");  
					requestDispatcher.forward(request,response);  
				}
				else if(type.equals("registereedUser"))
				{
					ProjectDAO projectDAO=new ProjectDAO();
					List projects=projectDAO.searchProjectFromUserId(loginVO);
					session.setAttribute("projects",projects);
					System.out.println("-----"+projects.size());
					requestDispatcher = request.getRequestDispatcher("/userLayout/index.jsp");  
					requestDispatcher.forward(request,response);  
				}
				else if(type.equals("company")){
					ProjectDAO projectDAO=new ProjectDAO();
					List projects=projectDAO.searchProjectFromUserId(loginVO);
					System.out.println("-----"+projects.size());
					session.setAttribute("projects",projects);
					
					requestDispatcher = request.getRequestDispatcher("/userLayout/indexCompany.jsp");  
					requestDispatcher.forward(request,response);  
				}
				else if(type.equals("developer")){
					
					

					Integer loginId1 = (Integer) ((HttpServletRequest) request).getSession()
							.getAttribute("userId");
					LoginVO loginVO3 = new LoginVO();
					loginVO3.setUserId(loginId1);
					
					DeveloperDAO developerDAO= new DeveloperDAO();
					List<DeveloperVO> list2=developerDAO.searchDeveloperDetails(loginVO3);
					
					HttpSession session5=((HttpServletRequest)request).getSession();
					session5.setAttribute("DeveloperList", list2);
					
					
					
					ProjectDAO projectDAO=new ProjectDAO();
					List projects=projectDAO.searchProjectFromUserId(loginVO);
					System.out.println("-----"+projects.size());
					session.setAttribute("projects",projects);
					requestDispatcher = request.getRequestDispatcher("/userLayout/index.jsp");  
					requestDispatcher.forward(request,response);  
				}
				else
				{

					requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");  
					requestDispatcher.forward(request,response);  
				}
			}

			else{
				requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");  
				requestDispatcher.forward(request,response);  		
			}	
		}

		else if(session.getAttribute("userId") != null)
		{
			String h = (String)session.getAttribute("usertype");
			System.out.println("type = = = " + h);

			if(h!=null && h.equals("admin")){	 /*&& uri.contains("/admin")*/

				System.out.println("chain");
				chain.doFilter(request,response);
			}
			else if(h!=null && h.equals("registereedUser")) 		/*&& uri.contains("/vendor")*/
			{
				System.out.println("chain");
				chain.doFilter(request, response);
			}
			else if(h!=null && h.equals("company")) 		/*&& uri.contains("/user")*/
			{
				System.out.println("chain");
				chain.doFilter(request, response);
			}
			else if(h!=null && h.equals("developer")) 		/*&& uri.contains("/user")*/
			{
				System.out.println("chain");
				chain.doFilter(request, response);
			}
			else{
				System.out.println("filter : error");
				RequestDispatcher rd = request.getRequestDispatcher("/userLayout/error.jsp");  
				rd.forward(request,response);  
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");  
			rd.forward(request,response);  
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
