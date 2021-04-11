package databaseutils;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ItemTransactionDetails")
public class ItemTransactionDetailsDto implements Serializable{
	@EmbeddedId
	private InvoiceKey invkey;
	private int qty;
	public synchronized final int getQty() {
		return qty;
	}
	public synchronized final void setQty(int qty) {
		this.qty = qty;
	}
	public InvoiceKey getInvkey() {
		return invkey;
	}
	public void setInvkey(InvoiceKey invkey) {
		this.invkey = invkey;
	}
	@Override
	public String toString() {
		return "ItemTransactionDetailsDto [invkey=" + invkey + ", qty=" + qty + "]";
	}
	
}
