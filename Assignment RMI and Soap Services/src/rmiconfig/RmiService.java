package rmiconfig;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiService extends Remote{
	public File getPdfFromXml(File f) throws RemoteException;
	public File getExcelFromXml(File f) throws RemoteException;
	public String sendEmailFromXml(File f)throws RemoteException;
	public String sendSmsFromXml(File f)throws RemoteException;
}
