package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginServiceImpl;

public class LogoutAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HttpSession session=request.getSession();
			String uname=(String)session.getAttribute("username");
			String upass=(String)session.getAttribute("password");
			Properties prop=(Properties)request.getServletContext().getAttribute("properties");
			System.out.println(uname+" "+upass);
			LoginServiceImpl update=LoginServiceImpl.getObject(prop);
			if(update.updateFLag(uname, upass, 0)!=-1) {
				session.removeAttribute("username");
				session.removeAttribute("password");
				session.invalidate();
				return "logout.success";
			}else {
				return "logout.fail";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "logout.fail";
	}
}
