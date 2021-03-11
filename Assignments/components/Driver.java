package components;

import components.email.SendEmail;

public class Driver {
	public static void main(String[] args) throws Exception {
		
//		Extractable xml=XmlSaxParser.getObj().getClone();
//		Convertable ew = new ExcelWriter();
//		ew.convert(xml,"Invoice.xml","Invoice-Excel");
//		Convertable pw = new PdfWriter();
//		pw.convert(xml,"Invoice.xml","Invoice-Pdf");
//		
//		Extractable xml=XMlParser.getObj().getClone();
//		Convertable ew = new ExcelWriter();
//		ew.convert(xml,"Items1.xml","Invoice-Excel45");
//		Convertable pw = new PdfWriter();
//		pw.convert(xml,"Items1.xml","Invoice-Pdf45");
		
		Extractable xml=XmlSaxParser.getObj().getClone();
		SendEmail.send(xml.getDataFromXml("Invoice.xml"),"Akshay@1999");

	}
}
