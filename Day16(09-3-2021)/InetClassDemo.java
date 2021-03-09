package day16;

import java.net.InetAddress;

public class InetClassDemo {
	public static void main(String[] args) throws Exception {
		InetAddress obj = InetAddress.getByName("cricbuzz.com");
		System.out.println(obj.getHostAddress());
		InetAddress []o=InetAddress.getAllByName("irctc.co.in");
		for(InetAddress a:o) {
			System.out.println(a.getHostAddress());
		}
		
		System.out.println();
	}

}
