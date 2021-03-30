package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ExcelWriter.ExcelWriter;
import databaseutils.InvoiceGenerator;
import email.SendEmail;
import pdfutil.RmiPdfWriterNew;
import service.LoginServiceImpl;
import sms.SendSms;

public class DownloadAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	try {
		String sms=request.getParameter("sms");
		String email=request.getParameter("email");
		String pdf=request.getParameter("pdf");
		String excel=request.getParameter("excel");
		HttpSession session=request.getSession();
		int invno=Integer.parseInt((String)session.getAttribute("invno"));
		Properties ps=(Properties)request.getServletContext().getAttribute("properties");
		if(pdf!=null) {
			InvoiceGenerator ig=InvoiceGenerator.getObj(ps);
			RmiPdfWriterNew createpdf=new RmiPdfWriterNew();
			createpdf.convert(ig.getInvoice(invno), "invoice"+Integer.toString(invno)+"PDF");
		}
		if(excel!=null) {
			InvoiceGenerator ig=InvoiceGenerator.getObj(ps);
			ExcelWriter ew= new ExcelWriter();
			ew.convert(ig.getInvoice(invno),"invoice"+Integer.toString(invno)+"Excel");
		}
		if(email!=null) {
			InvoiceGenerator ig=InvoiceGenerator.getObj(ps);
			int a=(Integer)session.getAttribute("id");
			LoginServiceImpl ll=LoginServiceImpl.getObject(ps);
			System.out.println("Now"+a);
			System.out.println("Now "+ll.getEmail(a));
			SendEmail.send(ig.getInvoice(invno), "Akshay@1999",ll.getEmail(a));
		}if(sms!=null) {
			InvoiceGenerator ig=InvoiceGenerator.getObj(ps);
			int a=(Integer)session.getAttribute("id");
			LoginServiceImpl ll=LoginServiceImpl.getObject(ps);
			SendSms.SendMessage(ig.getInvoice(invno), ll.getPhone(a));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return "print.table";
}
}
