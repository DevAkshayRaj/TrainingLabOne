package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "shopping.success";
	}
}
