package webfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LogoutFilter implements Filter {

 
    public LogoutFilter() {
       
    }


	public void destroy() {
		System.out.println("Filter Destroyed");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("DoFilter Called");
		HttpServletRequest hreq=(HttpServletRequest)request;
		HttpServletResponse hres=(HttpServletResponse)response;
		HttpSession session=hreq.getSession();
		String indexPage=hreq.getParameter("formid");
		
		if(session.isNew()) {
			if(indexPage.equalsIgnoreCase("login")) {
				chain.doFilter(request, response);
			}else {
				hres.sendRedirect("sessionexpired.jsp");
			}
			
		}else {
			System.out.println("The Session is OLD");
			chain.doFilter(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter Created");
	}

}
