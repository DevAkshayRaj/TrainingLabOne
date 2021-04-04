package soapexcel;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface ExcelService {
	@WebMethod
	public File getExcel(File ip);
}
