package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import databaseutils.InvoiceMasterDaoImpl;
import databaseutils.InvoiceMasterDto;
import databaseutils.ItemDetails;
import databaseutils.ItemDetailsDaoImpl;
import databaseutils.ItemDetailsMasterDaoImpl;
import databaseutils.ItemDetailsMasterDto;

public class ShopServiceImpl implements ShopService,Cloneable{
	private static Properties prop=null;
	private static ShopServiceImpl obj=null;
	private ShopServiceImpl(Properties prop) {
		this.prop=prop;
	}
	public static ShopServiceImpl getObject(Properties ps) throws Exception{
		if(obj==null) {
			obj =new ShopServiceImpl(ps);
			return obj;
		}
		return obj.getClone();
	}
	private ShopServiceImpl getClone() throws Exception{
		return (ShopServiceImpl)super.clone();
	}
	@Override
	public int getInvoiceNumber() {
		try {
			InvoiceMasterDaoImpl getdata=InvoiceMasterDaoImpl.getObject(this.prop);
			return getdata.getInvoiceNumber()+1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	@Override
	public ArrayList<ItemDetailsMasterDto> getDetails(int shopid) {
		try {
			ItemDetailsMasterDaoImpl getdata=ItemDetailsMasterDaoImpl.getObject(this.prop);
			return getdata.getItemDetailsMasterAll(shopid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int addIteminInvoice(ItemDetails itm) {
		int status=-1;
		try {
			ItemDetailsDaoImpl additems=ItemDetailsDaoImpl.getObject(this.prop);
			status=additems.insertItem(itm);
			return status;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public int addInvoiceMaster(long invno, long custno) {
		try {
			InvoiceMasterDto obj=new InvoiceMasterDto();
			obj.setCustomerno(custno);
			obj.setInvno(invno);
			obj.setInvDate(LocalDate.now());
			InvoiceMasterDaoImpl getdata=InvoiceMasterDaoImpl.getObject(this.prop);
			return getdata.insertInvoice(obj);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
