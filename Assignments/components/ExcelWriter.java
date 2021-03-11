package components;

import java.util.ArrayList;

public class ExcelWriter implements Convertable{
	@Override
	public void convert(Extractable xml,String filename,String opfilename) throws Exception {
		ExcelDataWriter excel=Container.getExcelDataWriter();
		ArrayList<ArrayList<String>> data=xml.getDataFromXml(filename);
		data.remove(data.size()-1);
		excel.putDataToExcel(data,opfilename);
		
	}
}
