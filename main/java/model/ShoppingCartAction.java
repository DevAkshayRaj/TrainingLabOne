package model;

import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseutils.ItemDetails;
import databaseutils.ItemDetailsMasterDto;
import service.ShopServiceImpl;

public class ShoppingCartAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Properties ps=(Properties)request.getServletContext().getAttribute("properties");
			ShopServiceImpl temp=ShopServiceImpl.getObject(ps);
			HttpSession session=request.getSession();
			if(session.getAttribute("invoice")==null) {
				ArrayList<ItemDetails> temp1=new ArrayList<ItemDetails>();
				session.setAttribute("invoice", temp1);
				session.setAttribute("invno",Integer.toString(temp.getInvoiceNumber()));
			}
		String shopid=request.getParameter("shopid");
		int step=Integer.parseInt(Character.toString(shopid.charAt(4)));
	
		ArrayList<ItemDetailsMasterDto>data=temp.getDetails(step);
		for(int i=0;i<data.size();i++) {
			ItemDetails itemdata= new ItemDetails();
			itemdata.setInvno(Long.parseLong((String)session.getAttribute("invno")));
			itemdata.setItemno(data.get(i).getItemno());
			itemdata.setQty(Integer.parseInt(request.getParameter(Integer.toString(data.get(i).getItemno()))));
			ArrayList<ItemDetails> te=(ArrayList<ItemDetails>)session.getAttribute("invoice");
			if(itemdata.getQty()==0) {
				continue;
			}
			te.add(itemdata);
			session.setAttribute("invoice", te);
		}
		ArrayList<ItemDetails> te=(ArrayList<ItemDetails>)session.getAttribute("invoice");
		System.out.println(te);
		return shopid;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
