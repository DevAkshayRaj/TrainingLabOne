package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseutils.CustomerDetialsDto;
import service.LoginServiceImpl;

public class RegisterAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String uname=request.getParameter("uname");
			String pwd=request.getParameter("upass");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			LoginServiceImpl register=LoginServiceImpl.getObject((Properties)request.getServletContext().getAttribute("properties"));
			CustomerDetialsDto cdat=new CustomerDetialsDto();
			cdat.setAddress(address);
			cdat.setEmail(email);
			cdat.setName(uname);
			cdat.setPhone(phone);
			if(register.registerUser(uname, pwd,cdat)!=-1) {
				return "register.success";
			}else {
				return "register.fail";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "register.fail";
	}

}
