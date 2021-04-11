package databaseutils;

import java.util.List;

public interface ItemTransactionDetailsDao {
	public boolean insertItemTransactionDetails(ItemTransactionDetailsDto ItemTransactionDetails);
	public boolean updateItemTransactionDetails(ItemTransactionDetailsDto ItemTransactionDetails);
	public boolean deleteItemTransactionDetails(int itemId,int invid);
	//public List<ItemTransactionDetailsDto> findTransactionByName(String name);
	public ItemTransactionDetailsDto findTransactionById(int itemId,int invid);
	public List<ItemTransactionDetailsDto> getAllItemTransactionDetails();
}
