package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SqlDemo
 */
public class SqlDemo extends HttpServlet {
	Connection con;
	PreparedStatement st;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/ey?characterEncoding=utf8",
					"root","rohitsharma45");
			st=con.prepareStatement("Insert into empl values(?,?)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String s1 = req.getParameter("name");
        String s2 = req.getParameter("age");
       res.setContentType("text/html");
       PrintWriter pw = res.getWriter();
       pw.println("<H1> Inserting Record:  </H1>");
     
         try {
            st.setString(1,s1);
            st.setString(2,s2);
            st.executeUpdate();
           }catch(Exception e) { }
          pw.println("<h2> BYE  </h2>");
        }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
