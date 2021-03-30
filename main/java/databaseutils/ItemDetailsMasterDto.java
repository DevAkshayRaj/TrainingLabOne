package databaseutils;

import java.io.Serializable;

public class ItemDetailsMasterDto implements Serializable{
	private int itemno;
	private String desc;
	private int units;
	private int price;
	private int shop;
	private String url;
	
	public synchronized final String getUrl() {
		return url;
	}
	public synchronized final void setUrl(String url) {
		this.url = url;
	}
	public synchronized final int getShop() {
		return shop;
	}
	public synchronized final void setShop(int shop) {
		this.shop = shop;
	}
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
				+ ", shop=" + shop + ", url=" + url + "]";
	}
	

	
	
}
