package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface Invoice extends Remote{
	public void startInvoiceApp()throws RemoteException;
	public void createInvoice(ArrayList<Object> d)throws RemoteException;
	public void addNewItem(ArrayList<Object> d)throws RemoteException;
	public byte[] getInvoiceDataasPdf(String invno,String fname)throws RemoteException;
	public byte[] getInvoiceDataasExcel(String invno,String fname)throws RemoteException;
}