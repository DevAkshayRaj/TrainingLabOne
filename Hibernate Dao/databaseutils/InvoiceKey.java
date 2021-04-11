package databaseutils;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InvoiceKey implements Serializable{
	private long invno;
	private int itemno;
	public long getInvno() {
		return invno;
	}
	public void setInvno(long invno) {
		this.invno = invno;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	@Override
	public String toString() {
		return "InvoiceKey [invno=" + invno + ", itemno=" + itemno + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (invno ^ (invno >>> 32));
		result = prime * result + itemno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceKey other = (InvoiceKey) obj;
		if (invno != other.invno)
			return false;
		if (itemno != other.itemno)
			return false;
		return true;
	}
	
}
