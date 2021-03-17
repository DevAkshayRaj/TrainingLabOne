package day21;

import java.io.Serializable;
import java.time.LocalDate;

public class InvoiceMasterDto implements Serializable {
	
	private long invno;
	private LocalDate invDate;
	private long customerno;
	
	public synchronized final long getInvno() {
		return invno;
	}
	public synchronized final void setInvno(long invno) {
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
