package day16;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
	Socket s;
	PrintWriter pw;
	BufferedReader br;
	public Client() {
		
		try {
			s = new Socket("localhost", 5023);
			System.out.println(s);
			
			br=new BufferedReader(new java.io.InputStreamReader(s.getInputStream()));
			String maa=br.readLine();
			System.out.println("Message From Server : "+maa);
			
			pw=new PrintWriter(s.getOutputStream(),true);
			System.out.println("Enter a Message for Server : ");
			br=new BufferedReader(new java.io.InputStreamReader(System.in));
			String msg=br.readLine();
			pw.println("Message From Client" + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Client();
	}

}
