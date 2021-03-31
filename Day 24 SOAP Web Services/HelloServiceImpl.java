package day24;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "twentyfour.HelloService")
@HandlerChain(file = "twentyfour/handler-chain.xml")
public class HelloServiceImpl implements HelloService {
	@WebMethod
	@Override
	public String sayHello(String name) {
		return "Welcome to Web Service"+name;
	}
}
