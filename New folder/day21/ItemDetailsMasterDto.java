package day21;

public class ItemDetailsMasterDto {
	private int itemno;
	private String desc;
	private int units;
	private int price;
	public synchronized final int getItemno() {
		return itemno;
	}
	public synchronized final void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public synchronized final String getDesc() {
		return desc;
	}
	public synchronized final void setDesc(String desc) {
		this.desc = desc;
	}
	public synchronized final int getUnits() {
		return units;
	}
	public synchronized final void setUnits(int units) {
		this.units = units;
	}
	public synchronized final int getPrice() {
		return price;
	}
	public synchronized final void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ItemDetailsMasterDto [itemno=" + itemno + ", desc=" + desc + ", units=" + units + ", price=" + price
				+ "]";
	}
	
	
}
