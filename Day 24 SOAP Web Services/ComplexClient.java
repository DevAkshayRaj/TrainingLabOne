package day24;

import java.net.URL;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
public class ComplexClient {
	public static void main(String[] args) throws Exception{
		
		URL url=new URL("http://localhost:2030/ws/hello2?wsdl");
		
		QName qName=new QName("http://twentyfour/","ComplexServiceImplService");
		
		Service service=Service.create(url,qName);
		
		ComplexService hservice=service.getPort(ComplexService.class);
		
		Employee result=hservice.getEmployee("1");
		System.out.println("The result is..:"+result);
		List<Employee> list=hservice.getAllEmployees();
		System.out.println(list);
	}
}