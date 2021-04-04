package soapexcel;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;

import components.Convertable;
import components.ExcelWriter;
import components.Extractable;
import components.XmlSaxParser;

@WebService(endpointInterface = "soapexcel.ExcelService")
public class ExcelServiceImpl implements ExcelService{
	@WebMethod
	@Override
	public File getExcel(File ip) {
		try {
			Extractable xml=XmlSaxParser.getObj().getClone();
			Convertable pw = new ExcelWriter();
			pw.convert(xml.getDataFromXml(ip),"C:\\Users\\YQ425XM\\Downloads\\soaptest\\Invoice-Excel-from-new-test");
			File ff=new File("C:\\Users\\YQ425XM\\Downloads\\soaptest\\Invoice-Pdf-from-new-test.xls");
			return ff;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
