package rmiconfig;

import java.io.File;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import soapemail.EmailService;


//An Update Was MAde here to test Git
public class Clinet {
	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://localhost:4002/ws/getEmail?wsdl");
		QName qname = new QName("http://soapemail/", "EmailServiceImplService");
		Service service = Service.create(url, qname);
		EmailService get = service.getPort(EmailService.class);
		File f=new File("Invoice.xml");
		System.out.println(get.sendEmail(f));
	}
}
