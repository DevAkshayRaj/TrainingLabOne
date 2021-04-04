package rmiconfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.Scanner;


public class ServiceClient {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		RmiService serverobj=(RmiService)Naming.lookup("rmi://localhost:4010/ServicesApp");
		Scanner scan=new Scanner(System.in);
		while(true) {
		System.out.println("Please select your choice...");
		System.out.println("1-Generate PDF From XML File");
		System.out.println("2-Generate EXCEL From XML File");
		System.out.println("3-Send Email From XML File");
		System.out.println("4-Send SMS From XML File");
		System.out.println("6-Press 9 to Exit ");
		int choice=scan.nextInt();
		if(choice==9) {
			break;
		}
		switch(choice) {
		case 1:{
			System.out.println("Please Enter The Xml File path :");
			String fname=br.readLine();
			File ip=new File(fname);
			File op=serverobj.getPdfFromXml(ip);
			System.out.println(op);
			break;
		}
		case 2:{
			System.out.println("Please Enter The Xml File path :");
			String fname=br.readLine();
			File ip=new File(fname);
			File op=serverobj.getExcelFromXml(ip);
			System.out.println(op);
			break;
		}
		case 3:{
			System.out.println("Please Enter The Xml File path :");
			String fname=br.readLine();
			File ip=new File(fname);
			String op=serverobj.sendEmailFromXml(ip);
			System.out.println(op);
	
			break;
		}
		case 4:{
			System.out.println("Please Enter The Xml File path :");
			String fname=br.readLine();
			File ip=new File(fname);
			String op=serverobj.sendSmsFromXml(ip);
			System.out.println(op);
	
			break;			
		}

		default:
			System.out.println("wrong choice...");
		}
		
		}
		scan.close();
	}
}


