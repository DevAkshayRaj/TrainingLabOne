package databaseutils;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ItemDetailsMaster")
public class ItemDetailsMasterDto implements Serializable{
	@Id
	private int itemno;
	private String itemdescription;
	private int itemunits;
	private int itemprice;
	private int shopid;
	private String imageurl;
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public String getItemdescription() {
		return itemdescription;
	}
	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}
	public int getItemunits() {
		return itemunits;
	}
	public void setItemunits(int itemunits) {
		this.itemunits = itemunits;
	}
	public int getItemprice() {
		return itemprice;
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	@Override
	public String toString() {
		return "ItemDetailsMasterDto [itemno=" + itemno + ", itemdescription=" + itemdescription + ", itemunits="
				+ itemunits + ", itemprice=" + itemprice + ", shopid=" + shopid + ", imageurl=" + imageurl + "]";
	}
	


}
