package databaseutils;

import java.util.List;

public interface ItemDetailsMasterDao {
	public boolean insertItemDetails(ItemDetailsMasterDto itemDetails);
	public boolean updateItemDetails(ItemDetailsMasterDto itemDetails);
	public boolean deleteItemDetails(int itemId);
	public List<ItemDetailsMasterDto> findItemByName(String itemName);
	public ItemDetailsMasterDto findItemById(int  itemId);
	public List<ItemDetailsMasterDto> getAllItemDetails();
}
