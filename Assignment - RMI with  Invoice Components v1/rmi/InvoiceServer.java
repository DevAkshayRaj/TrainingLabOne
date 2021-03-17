package rmi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import day21.InvoiceGenerator;
import day21.CustomerDetialsDaoImpl;
import day21.CustomerDetialsDto;
import day21.InvoiceMasterDaoImpl;
import day21.InvoiceMasterDto;
import day21.ItemDetails;
import day21.ItemDetailsDaoImpl;
import day21.ItemDetailsMasterDaoImpl;
import day21.ItemDetailsMasterDto;
import rmi.ExcelWriter.ExcelWriter;
import rmi.pdfutil.*;

public class InvoiceServer extends UnicastRemoteObject implements Invoice {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Override
	public void startInvoiceApp() throws RemoteException {

		try {
			// createInvoice();
		} catch (Exception e) {
			e.printStackTrace();
		}

		calculateDate();

	}

	public InvoiceServer() throws RemoteException {

	}

	public void createInvoice() throws Exception {
		System.out.println("create invoice logic executed.....");

	}

	public void calculateDate() {
		System.out.println("delivery date is so and so....");
	}

	@Override
	public void createInvoice(ArrayList<Object> d) throws RemoteException {
		// TODO Auto-generated method stub
		InvoiceMasterDto a1 = (InvoiceMasterDto) d.get(0);
		CustomerDetialsDto a2 = (CustomerDetialsDto) d.get(1);
		ItemDetails a3 = (ItemDetails) d.get(2);
		System.out.println(a1 + "\n" + a2 + "\n" + a3);

		InvoiceMasterDaoImpl idb = new InvoiceMasterDaoImpl();
		idb.insertInvoice(a1);

		CustomerDetialsDaoImpl cdaop = new CustomerDetialsDaoImpl();
		cdaop.insertCustomerDetials(a2);

		ItemDetailsDaoImpl idao = new ItemDetailsDaoImpl();
		for (int i = 2; i < d.size(); i++) {
			idao.insertItem((ItemDetails) d.get(i));
		}
	}

	@Override
	public void addNewItem(ArrayList<Object> d) throws RemoteException {
		ItemDetailsMasterDaoImpl db = new ItemDetailsMasterDaoImpl();
		for (int i = 0; i < d.size(); i++) {
			db.insertItemDetailsMaster((ItemDetailsMasterDto) d.get(i));
		}

	}

	@Override
	public byte[] getInvoiceDataasPdf(String invno, String fname) throws RemoteException {
		byte[] file;
		ByteArrayOutputStream baos;
		try {
			new RmiPdfWriterNew().convert(InvoiceGenerator.getInvoice(Long.parseLong(invno)), fname);
			FileInputStream fs = new FileInputStream(fname + ".pdf");
			int b = 0;
			file = new byte[8192];
			baos = new ByteArrayOutputStream();
			while ((b = fs.read(file)) != -1) {
				baos.write(file, 0, b);
			}
			File ff=new File(fname + ".pdf");
			fs.close();
			ff.delete();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return baos.toByteArray();
	}

	@Override
	public byte[] getInvoiceDataasExcel(String invno, String fname) throws RemoteException {
		byte[] file;
		ByteArrayOutputStream baos;
		try {
			new ExcelWriter().convert(InvoiceGenerator.getInvoice(Long.parseLong(invno)), fname);
			FileInputStream fs = new FileInputStream(fname + ".xls");
			int b = 0;
			file = new byte[8192];
			baos = new ByteArrayOutputStream();
			while ((b = fs.read(file)) != -1) {
				baos.write(file, 0, b);
			}
			File ff=new File(fname + ".xls");
			fs.close();
			ff.delete();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return baos.toByteArray();
	}
}