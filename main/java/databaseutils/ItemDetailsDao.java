package databaseutils;

import java.util.Set;

public interface ItemDetailsDao {
	public int insertItem(ItemDetails obj);
	public int deleteItem(long invno);
	public int updateInvoice(ItemDetails obj);
	public ItemDetails getItemDetails(long invno);
	public Set<ItemDetails> getItemDetailsAll(String invno);
}
