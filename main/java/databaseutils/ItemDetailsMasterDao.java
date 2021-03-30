package databaseutils;

import java.util.ArrayList;

public interface ItemDetailsMasterDao {
	public int insertItemDetailsMaster(ItemDetailsMasterDto obj);
	public int updateItemDetailsMaster(ItemDetailsMasterDto obj);
	public int deleteItemDetailsMaster(int itemno);
	public ItemDetailsMasterDto getItemDetailsMaster(int itemno);
	public ArrayList<ItemDetailsMasterDto> getItemDetailsMasterAll(int shop);
}
