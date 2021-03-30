package model;

import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseutils.InvoiceGenerator;
import databaseutils.ItemDetails;
import pdfutil.RmiPdfWriterNew;
import service.ShopServiceImpl;

public class InvoiceAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Properties ps=(Properties)request.getServletContext().getAttribute("properties");
			ShopServiceImpl shoputil=ShopServiceImpl.getObject(ps);
			HttpSession session=request.getSession();
			int invno=Integer.parseInt((String)session.getAttribute("invno"));
			shoputil.addInvoiceMaster(invno,(Integer)session.getAttribute("id"));
			ArrayList<ItemDetails> data=(ArrayList<ItemDetails>)session.getAttribute("invoice");
			for(int i=0;i<data.size();i++) {
				shoputil.addIteminInvoice(data.get(i));
			}
			InvoiceGenerator ig=InvoiceGenerator.getObj(ps);
//			RmiPdfWriterNew pdf=new RmiPdfWriterNew();
//			pdf.convert(ig.getInvoice(invno), "invoice"+Integer.toString(invno));
			return "print.table";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
