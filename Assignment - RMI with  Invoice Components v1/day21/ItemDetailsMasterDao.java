package day21;

import java.util.Set;

public interface ItemDetailsMasterDao {
	public int insertItemDetailsMaster(ItemDetailsMasterDto obj);
	public int updateItemDetailsMaster(ItemDetailsMasterDto obj);
	public int deleteItemDetailsMaster(int itemno);
	public ItemDetailsMasterDto getItemDetailsMaster(int itemno);
	public Set<ItemDetailsMasterDto> getItemDetailsMasterAll();
}
