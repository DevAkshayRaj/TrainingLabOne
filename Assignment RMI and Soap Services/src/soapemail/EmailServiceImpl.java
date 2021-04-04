package soapemail;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;

import components.Extractable;
import components.XmlSaxParser;
import components.email.SendEmail;

@WebService(endpointInterface = "soapemail.EmailService")
public class EmailServiceImpl implements EmailService{

	@WebMethod
	@Override
	public String sendEmail(File ip) {
		try {
			Extractable xml=XmlSaxParser.getObj().getClone();
			SendEmail.send(xml.getDataFromXml(ip), "Akshay@1999");
			return "Email Was Successfully Sent !";
		}
		catch(Exception e){
			e.printStackTrace();
			return "Email Was Not Successfully Sent !";
		}
	}
}
