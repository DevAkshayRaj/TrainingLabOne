package soapsms;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;

import components.Extractable;
import components.XmlSaxParser;
import components.sms.SendSms;

@WebService(endpointInterface = "soapsms.SmsService")
public class SmsServiceImpl implements SmsService{
	@WebMethod
	@Override
	public String sendSms(File ip) {
	try {
		Extractable xml=XmlSaxParser.getObj().getClone();
		SendSms.SendMessage(xml.getDataFromXml(ip),"9080700979");
		return "SMS was Sent SUccessfully !!"; 
	}catch(Exception e) {
		e.printStackTrace();
		return "SMS was Not Sent SUccessfully !!";
	}
	}
}
