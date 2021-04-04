package soapconfig;

import javax.xml.ws.Endpoint;

import soapemail.EmailServiceImpl;
import soapexcel.ExcelServiceImpl;
import soappdf.PdfServiceImpl;
import soapsms.SmsServiceImpl;


public class PublishServices {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:4000/ws/getPDf", new PdfServiceImpl());
		System.out.println("Pdf Service Published");
		
		
		Endpoint.publish("http://localhost:4001/ws/getExcel", new ExcelServiceImpl());
		System.out.println("Excel Service Published");
		
		
		Endpoint.publish("http://localhost:4002/ws/getEmail", new EmailServiceImpl());
		System.out.println("Email Service Published");
		
		
		Endpoint.publish("http://localhost:4003/ws/getSMS", new SmsServiceImpl());
		System.out.println("Sms Service Published");
	}
}
