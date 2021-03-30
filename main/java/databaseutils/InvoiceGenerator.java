package databaseutils;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class InvoiceGenerator implements Cloneable{
	private static Properties ps;
	private static InvoiceGenerator ig=null;
	private InvoiceGenerator(Properties ps) {
		this.ps=ps;
	}
	public static InvoiceGenerator getObj(Properties p) throws Exception{
		if(ig==null) {
			ig=new InvoiceGenerator(p);
			return ig;
		}
		return ig.getClone();
	}
	private InvoiceGenerator getClone() throws Exception{
		return (InvoiceGenerator)super.clone();
	}
	public ArrayList<ArrayList<String>> getInvoice(long invno) {
		
		ArrayList<ArrayList<String>> fdata=new ArrayList<ArrayList<String>>();
		ArrayList<String> tdata=new ArrayList<String>();
		ArrayList<String> heading=new ArrayList<String>();
		try {
		InvoiceMasterDaoImpl db=InvoiceMasterDaoImpl.getObject(this.ps);
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
		CustomerDetialsDaoImpl cdb=CustomerDetialsDaoImpl.getObject(this.ps);
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
		ItemDetailsDaoImpl idtl=ItemDetailsDaoImpl.getObject(this.ps);
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
		ItemDetailsMasterDaoImpl idml =ItemDetailsMasterDaoImpl.getObject(this.ps);
		double total=0;
		int c=0;
		for(ItemDetails temp:ss) {
			ItemDetailsMasterDto test=idml.getItemDetailsMaster(temp.getItemno());
			tdata.add(Integer.toString(test.getItemno()));
			tdata.add(test.getDesc());
			tdata.add(Integer.toString(test.getUnits()));
			tdata.add(Integer.toString(test.getPrice()));
			tdata.add(Integer.toString(temp.getQty()));
			double unitprice=test.getPrice()/test.getUnits();
			double amt=unitprice*temp.getQty();
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
