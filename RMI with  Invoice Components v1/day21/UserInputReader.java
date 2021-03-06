package day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class UserInputReader {
	BufferedReader br;
	public ArrayList<Object> getInput() throws Exception{
		
		ArrayList<Object> ip=new ArrayList<Object>();
		
		br=new BufferedReader(new InputStreamReader(System.in));
		InvoiceMasterDto inv=new InvoiceMasterDto();
		System.out.println("Please Enter the Invoice Number");
		long invno=Long.parseLong(br.readLine());
		inv.setInvno(invno);
		System.out.println("Please Enter the Customer Number");
		Long custno=Long.parseLong(br.readLine());
		inv.setCustomerno(custno);		
		inv.setInvDate(LocalDate.now());
//		InvoiceMasterDaoImpl idb=new InvoiceMasterDaoImpl();
//		idb.insertInvoice(inv);
		ip.add(inv);
		
		CustomerDetialsDto cdt=new CustomerDetialsDto();
		cdt.setCustno(custno);
		System.out.println("Please Enter the Customer Name");
		cdt.setName(br.readLine());
		System.out.println("Please Enter the Customer Address");
		cdt.setAddress(br.readLine());
		System.out.println("Please Enter the Customer Email");
		cdt.setEmail(br.readLine());
		System.out.println("Please Enter the Customer Phone Number");
		cdt.setPhone(br.readLine());
		ip.add(cdt);
//		CustomerDetialsDaoImpl cdaop=new CustomerDetialsDaoImpl();
//		cdaop.insertCustomerDetials(cdt);
		
		char status='a';
		do{
			System.out.println("Please press 'a' to add item and 'q' to exit");
			status=br.readLine().charAt(0);
			if(status!='a') {
				break;
			}
			ItemDetails id=new ItemDetails();
			id.setInvno(invno);
			System.out.println("Please Enter Item Number : ");
			id.setItemno(Integer.parseInt(br.readLine()));
			System.out.println("Please Enter Item Quantity");
			id.setQty(Integer.parseInt(br.readLine()));
			ip.add(id);
//			ItemDetailsDaoImpl idao=new ItemDetailsDaoImpl();
//			idao.insertItem(id);
		}while(true);
		
		return ip;
	}
	
	public ArrayList<Object>  addItemInput() throws Exception{
		ArrayList<Object> ip=new ArrayList<Object>();
		br=new BufferedReader(new InputStreamReader(System.in));
		char status='a';
		do{
			System.out.println("Please press 'a' to add item and 'q' to exit");
			status=br.readLine().charAt(0);
			if(status!='a') {
				break;
			}
		ItemDetailsMasterDto item=new ItemDetailsMasterDto();
		System.out.println("Please Enter the Item Number");
		item.setItemno(Integer.parseInt(br.readLine()));
		System.out.println("Please Enter the Item Description");
		item.setDesc(br.readLine());
		System.out.println("Please Enter the Item units");
		item.setUnits(Integer.parseInt(br.readLine()));
		System.out.println("Please Enter the Item price");
		item.setPrice(Integer.parseInt(br.readLine()));
		ip.add(item);
		}while(true);
		return ip;
	}
	
	public static void main(String[] args) throws Exception{
		new UserInputReader().getInput();
	}
}
