package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInvalid extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "login.again";
	}
}
