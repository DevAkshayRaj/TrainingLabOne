package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validate.mysql.UsersMasterDaoImpl;
import validate.mysql.UsersMasterDto;

public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("uname");
		String pass=request.getParameter("upass");
		String reg=request.getParameter("register");
		String logout=request.getParameter("logout");
		UsersMasterDto obj=new UsersMasterDto();
		obj.setName(name);
		obj.setPwd(pass);
		UsersMasterDaoImpl validate=new UsersMasterDaoImpl();
		//System.out.println(obj);
		//System.out.println(validate.validateUser(obj));
		if(reg==null) {
		 if(validate.validateUser(obj)) {
			 if(validate.getUserStatus(obj)==1) {
				 response.sendRedirect("Busy.html");
			 }else {
				 validate.updateStatus(1, obj);
				 response.sendRedirect("Welcome.html");
			 }
		
		 }else {
			 response.sendRedirect("LoginAuth.html");
		 }}else if(reg!=null){
			 response.sendRedirect("Register.html");
		 }else if(logout!=null) {
			 validate.updateStatus(0, obj);
			 response.sendRedirect("LoginAuth.html");
		 }
		
	}
}
