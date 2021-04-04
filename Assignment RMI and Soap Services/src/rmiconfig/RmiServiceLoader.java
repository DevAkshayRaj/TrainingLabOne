package rmiconfig;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class RmiServiceLoader {
	public static void main(String[] args) throws Exception{
		
		ServiceServer ss=new ServiceServer();
		
		LocateRegistry.createRegistry(4010);
		
		System.out.println("Services app Loaded...!");
		
		Naming.bind("rmi://localhost:4010/ServicesApp", ss);
	}
}
