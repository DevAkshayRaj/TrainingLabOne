package day24;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class HelloClient {
public static void main(String[] args) throws Exception{
		
		URL url=new URL("http://localhost:2030/ws/hello2?wsdl");
		
		QName qName=new QName("http://twentyfour/","HelloServiceImplService");
		
		Service service=Service.create(url,qName);
		
		HelloService hservice=service.getPort(HelloService.class);
		
		String result=hservice.sayHello("SOAP Eg");
		System.out.println("The result is..:"+result);
	}
}
