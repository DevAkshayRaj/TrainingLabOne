package service;

import java.util.ArrayList;

import databaseutils.ItemDetails;
import databaseutils.ItemDetailsMasterDto;

public interface ShopService {
	public ArrayList<ItemDetailsMasterDto> getDetails(int shopid);
	public int addIteminInvoice(ItemDetails itm);
	public int getInvoiceNumber();
	public int addInvoiceMaster(long invno,long custno);
	
}
