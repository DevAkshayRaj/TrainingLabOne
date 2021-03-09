package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	Socket s;
	ServerSocket ss;
	PrintWriter out;
	BufferedReader br;
	public Server() {
		// TODO Auto-generated constructor stub
		
		try {
			ss = new ServerSocket(5023);
			System.out.println("server Ready !");
			while(true){
			s=ss.accept();
			System.out.println(s);
			out=new PrintWriter(s.getOutputStream(),true);
			System.out.println("Enter a Message for Client : ");
			String ip=new BufferedReader(new InputStreamReader(System.in)).readLine();
			out.println("Message from Client : " +ip);
			br=new BufferedReader(new java.io.InputStreamReader(s.getInputStream()));
			String sa=br.readLine();
			System.out.println("Client Says : "+sa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new Server();
	}

}
