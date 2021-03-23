package assignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validate.mysql.UsersMasterDaoImpl;
import validate.mysql.UsersMasterDto;


public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String name=request.getParameter("uname");
		String pass=request.getParameter("upass");
		
		UsersMasterDto obj=new UsersMasterDto();
		obj.setName(name);
		obj.setPwd(pass);
		UsersMasterDaoImpl validate=new UsersMasterDaoImpl();
		int sta=validate.addUsers(obj);
		if(sta==1){
			 response.sendRedirect("LoginAuth.html");
		 }else {
			 response.sendRedirect("Register.html");
		 }
	}

}
