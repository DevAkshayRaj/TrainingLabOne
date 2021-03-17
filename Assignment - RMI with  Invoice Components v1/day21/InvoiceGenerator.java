package day21;

import java.util.ArrayList;
import java.util.Set;

public class InvoiceGenerator {
	public static ArrayList<ArrayList<String>> getInvoice(long invno) {
		
		ArrayList<ArrayList<String>> fdata=new ArrayList<ArrayList<String>>();
		ArrayList<String> tdata=new ArrayList<String>();
		ArrayList<String> heading=new ArrayList<String>();
		try {
		InvoiceMasterDaoImpl db=new InvoiceMasterDaoImpl();
		InvoiceMasterDto master=db.getInvoiceMaster(invno);
		heading.add(Integer.toString(0));
		tdata.add("Invoice Number");
		tdata.add("Invoice Date");
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		tdata.add(Long.toString(master.getInvno()));
		tdata.add(master.getInvDate().toString());
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		CustomerDetialsDaoImpl cdb=new CustomerDetialsDaoImpl();
		CustomerDetialsDto data=cdb.getCustomerDetials(master.getCustomerno());
		heading.add(Integer.toString(2));
		tdata.add("Customer Name");
		tdata.add("Customer Address");
		tdata.add("Customer Email");
		tdata.add("Customer Phone");
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		tdata.add(data.getName());
		tdata.add(data.getAddress());
		tdata.add(data.getEmail());
		tdata.add(data.getPhone());
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		ItemDetailsDaoImpl idtl=new ItemDetailsDaoImpl();
		Set<ItemDetails> ss=idtl.getItemDetailsAll(Long.toString(invno));
		heading.add(Integer.toString(4));
		tdata.add("Item Number");
		tdata.add("Item Description");
		tdata.add("Item Units");
		tdata.add("Item price");
		tdata.add("Item Quantity");
		tdata.add("Amount");
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		ItemDetailsMasterDaoImpl idml =new ItemDetailsMasterDaoImpl();
		double total=0;
		int c=0;
		for(ItemDetails temp:ss) {
			ItemDetailsMasterDto test=idml.getItemDetailsMaster(temp.getItemno());
			tdata.add(Integer.toString(test.getItemno()));
			tdata.add(test.getDesc());
			tdata.add(Integer.toString(test.getUnits()));
			tdata.add(Integer.toString(test.getPrice()));
			tdata.add(Integer.toString(temp.getQty()));
			double amt=test.getUnits()*temp.getQty();
			total+=amt;
			tdata.add(Double.toString(amt));
			fdata.add(tdata);
			tdata=null;tdata=new ArrayList<String>();
			c++;
			
		}
		heading.add(Integer.toString(5+c));
		tdata.add("Total");
		fdata.add(tdata);
		tdata=null;tdata=new ArrayList<String>();
		tdata.add(Double.toString(total));
		fdata.add(tdata);
		fdata.add(heading);
		System.out.println(fdata);
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return fdata;
}
}
