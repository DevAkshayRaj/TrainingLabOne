package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ActionServlet extends HttpServlet {
	RequestProcessor rp;
	Properties props;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			String configFile=config.getInitParameter("config");
			String DBconfigFile=config.getInitParameter("dbconfig");
			String configpath=config.getServletContext().getRealPath(configFile);
			String dbconfigpath=config.getServletContext().getRealPath(DBconfigFile);
			config.getServletContext().setAttribute("path", configpath);
			props=new Properties();
			props.load(new FileInputStream(dbconfigpath));
			Class.forName(props.getProperty("driver"));
			config.getServletContext().setAttribute("properties", props);
			this.rp=new RequestProcessor();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getServletContext().getAttribute("properties"));
//		HttpSession session=request.getSession();
//		session.setAttribute("properties",request.getServletContext().getAttribute("properties"));
		this.rp.process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
