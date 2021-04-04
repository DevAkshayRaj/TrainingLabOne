package rmiconfig;

import java.io.File;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import soapemail.EmailService;
import soapexcel.ExcelService;
import soappdf.PdfService;
import soapsms.SmsService;

public class ServiceServer  extends UnicastRemoteObject implements RmiService {
	
	public ServiceServer() throws Exception{
	
	}
	
	@Override
	public File getPdfFromXml(File f) throws RemoteException {
		try {
			URL url = new URL("http://localhost:4000/ws/getPDf?wsdl");
			QName qname = new QName("http://soappdf/", "PdfServiceImplService");
			Service service = Service.create(url, qname);
			PdfService get = service.getPort(PdfService.class);
			return get.getPdf(f);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public File getExcelFromXml(File f) throws RemoteException {
		try {
			URL url = new URL("http://localhost:4001/ws/getExcel?wsdl");
			QName qname = new QName("http://soapexcel/", "ExcelServiceImplService");
			Service service = Service.create(url, qname);
			ExcelService get = service.getPort(ExcelService.class);
			return get.getExcel(f);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String sendEmailFromXml(File f) throws RemoteException {
		try {
			URL url = new URL("http://localhost:4002/ws/getEmail?wsdl");
			QName qname = new QName("http://soapemail/", "EmailServiceImplService");
			Service service = Service.create(url, qname);
			EmailService send = service.getPort(EmailService.class);
			return send.sendEmail(f);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String sendSmsFromXml(File f) throws RemoteException {
		try {
			URL url = new URL("http://localhost:4003/ws/getSMS?wsdl");
			QName qname = new QName("http://soapsms/", "SmsServiceImplService");
			Service service = Service.create(url, qname);
			SmsService get = service.getPort(SmsService.class);
			return get.sendSms(f);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
