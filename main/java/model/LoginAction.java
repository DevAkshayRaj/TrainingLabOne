package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginServiceImpl;
import service.ShopServiceImpl;

public class LoginAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String uname=request.getParameter("uname");
			String upass=request.getParameter("upass");
			//System.out.println(request.getServletContext().getAttribute("properties"));
			Properties ps=(Properties)request.getServletContext().getAttribute("properties");
			//System.out.println("wssdfsfffffffffffff"+ps.getProperty("driver"));
			HttpSession session=request.getSession();
			LoginServiceImpl validate=LoginServiceImpl.getObject(ps);
			
			if(validate.checkUser(uname, upass)) {
				if(validate.checkFLag(uname, upass)) {
					return "login.already";
				}
				else {
					session.setAttribute("username", uname);
					session.setAttribute("password", upass);
					session.setAttribute("id", validate.getId(uname, upass));
					validate.updateFLag(uname, upass, 1);
					return "login.success";
				}
			}else {
				return "login.failure";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "login.failure";
	}
}
