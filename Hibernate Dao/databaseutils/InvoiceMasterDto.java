package databaseutils;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="InvoiceMaster")
public class InvoiceMasterDto implements Serializable {
	@Id
	private int invno;
	private LocalDate invDate;
	private long customerno;
	
	public synchronized final int getInvno() {
		return invno;
	}
	public synchronized final void setInvno(int invno) {
		this.invno = invno;
	}
	public synchronized final LocalDate getInvDate() {
		return invDate;
	}
	public synchronized final void setInvDate(LocalDate invDate) {
		this.invDate = invDate;
	}
	public synchronized final long getCustomerno() {
		return customerno;
	}
	public synchronized final void setCustomerno(long customerno) {
		this.customerno = customerno;
	}
	
	@Override
	public String toString() {
		return "InvoiceMasterDto [invno=" + invno + ", invDate=" + invDate + ", customerno=" + customerno + "]";
	}
}
