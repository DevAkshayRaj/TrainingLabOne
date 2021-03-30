package databaseutils;

import java.util.Set;

public interface InvoiceMasterDao {
	public int insertInvoice(InvoiceMasterDto invMasterDTO);
	public int deleteInvoice(long invno);
	public int updateInvoice(InvoiceMasterDto invMasterDTO);
	public InvoiceMasterDto getInvoiceMaster(long invo);
	public Set<InvoiceMasterDto> getInvoiceMasterAll();
	public int getInvoiceNumber();
}
