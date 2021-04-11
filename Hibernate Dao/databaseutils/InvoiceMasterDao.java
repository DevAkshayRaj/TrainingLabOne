package databaseutils;

import java.util.List;

public interface InvoiceMasterDao {
	public boolean insertInvoiceDetails(InvoiceMasterDto InvoiceDetails);
	public boolean updateInvoiceDetails(InvoiceMasterDto InvoiceDetails);
	public boolean deleteInvoiceDetails(int invoiceId);
	//public List<InvoiceMasterDto> findByName(String name);
	public InvoiceMasterDto findInvoiceById(int  invoiceId);
	public List<InvoiceMasterDto> getAllInvoiceDetails();
}
