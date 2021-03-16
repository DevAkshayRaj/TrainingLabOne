package components;

public class Container {
	public static ExcelDataWriter getExcelDataWriter() throws Exception{
		ExcelDataWriter obj;
		obj=ExcelDataWriter.getObj().getCLone();
		return obj;
	}
	public static PdfDataWriter getPdfDataWriter() throws Exception{
		PdfDataWriter obj;
		obj=PdfDataWriter.getObj().getClone();
		return obj;
	}
	public static XMlParser getXMlParser() throws Exception{
		XMlParser obj;
		obj=XMlParser.getObj().getClone();
		return obj;
	}
	public static XmlSaxParser getXmlSaxParser() throws Exception{
		XmlSaxParser obj;
		obj=XmlSaxParser.getObj().getClone();
		return obj;
	}
}
