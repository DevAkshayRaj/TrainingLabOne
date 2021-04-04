package soappdf;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;

import components.Convertable;
import components.Extractable;
import components.PdfWriter;
import components.XmlSaxParser;

@WebService(endpointInterface = "soappdf.PdfService")
public class PdfServiceImpl implements PdfService{
	
	@WebMethod
	@Override
	public File getPdf(File ip) {
		try {
			Extractable xml=XmlSaxParser.getObj().getClone();
			Convertable pw = new PdfWriter();
			pw.convert(xml.getDataFromXml(ip),"C:\\Users\\YQ425XM\\Downloads\\soaptest\\Invoice-Pdf-from-new-test");
			File ff=new File("C:\\Users\\YQ425XM\\Downloads\\soaptest\\Invoice-Pdf-from-new-test.pdf");
			return ff;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
}
