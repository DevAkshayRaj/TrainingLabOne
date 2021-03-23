package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionCount
 */
public class SessionCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(true);
		String count = (String) session.getAttribute("tracker.count");
		System.out.println(count);
		if (count == null)
			count =Integer.toString(1);
		else
			count =Integer.toString(Integer.parseInt(count)+1);
		session.setAttribute("tracker.count",count);
		System.out.println(count);
		out.println("<HTML><HEAD><TITLE>SessionTracker</TITLE></HEAD>");
		out.println("<BODY><H1>Session Tracking Demo</H1>");
		out.println("You've visited this page " + count + ((Integer.parseInt(count) == 1) ? " time." : " times."));
		out.println("<P>");
		out.println("<H2>Here is your session data:</H2>");
		Enumeration names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String temp=(String)names.nextElement();
			out.println( temp+ ": " + session.getAttribute(temp) + "<BR>");
		}
		out.println("</BODY></HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
