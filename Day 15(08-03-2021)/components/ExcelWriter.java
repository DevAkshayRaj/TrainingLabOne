package components;

public class ExcelWriter implements Convertable{
	@Override
	public void convert(String filename) throws Exception {
		XMlParser xml=Container.getXMlParser();
		ExcelDataWriter excel=Container.getExcelDataWriter();
		excel.putDataToExcel(xml.getDataFromXml(filename));
		
	}
}
