package rmi;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.rmi.Naming;
import day21.UserInputReader;

import java.util.ArrayList;
import java.util.Scanner;

import consignmentTracker.CalculateDays;
import consignmentTracker.InputData;
import consignmentTracker.InputDataReader;

public class InvoiceClient {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Invoice inv=(Invoice)Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		Scanner scan=new Scanner(System.in);
		while(true) {
		System.out.println("Please select your choice...");
		System.out.println("1-Create new Invoice");
		System.out.println("2-Calculate Delivery date and time");
		System.out.println("3-Generate PDF using Invoice Number");
		System.out.println("4-Generate EXCEL using Invoice Number");
		System.out.println("5-Add New Item to Inventory ");
		System.out.println("6-Press 9 to Exit ");
		int choice=scan.nextInt();
		if(choice==9) {
			break;
		}
		switch(choice) {
		case 1:{
			ArrayList<Object> data=new UserInputReader().getInput();
			inv.createInvoice(data);
			break;
		}
		case 2:{
			InputData ip=InputDataReader.getObj().getClone().getInput();
			CalculateDays cd=new CalculateDays(ip);
			cd.printInput();
			System.out.println();
			cd.getDeliverTime();
			break;
		}
		case 3:{
			System.out.println("Please Enter The Invoice Number :");
			String invno=br.readLine();
			System.out.println("Please Enter The Invoice File Name :");
			String fname=br.readLine();
			byte[] bArray=inv.getInvoiceDataasPdf(invno,fname);
			FileOutputStream out = new FileOutputStream("d://OutputRmiFiles//"+fname+".pdf");
			if(bArray!=null) {
				out.write(bArray);
			}
			out.close();
			break;
		}
		case 4:{
			System.out.println("Please Enter The Invoice Number :");
			String invno=br.readLine();
			System.out.println("Please Enter The Invoice File Name :");
			String fname=br.readLine();
			byte[] bArray=inv.getInvoiceDataasExcel(invno,fname);
			FileOutputStream out = new FileOutputStream("d://OutputRmiFiles//"+fname+".xls");
			if(bArray!=null) {
				out.write(bArray);
			}
			out.close();
			break;			
		}
		case 5:{
			ArrayList<Object> data=new UserInputReader().addItemInput();
			inv.addNewItem(data);
			break;
		}
		default:
			System.out.println("wrong choice...");
		}
		
		}
		scan.close();
	}
}

