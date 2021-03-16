package components;

import java.util.ArrayList;

public class ExcelWriter implements Convertable{
	@Override
	public void convert(ArrayList<ArrayList<String>> data,String opfilename) throws Exception {
		ExcelDataWriter excel=Container.getExcelDataWriter();
		data.remove(data.size()-1);
		excel.putDataToExcel(data,opfilename);
		
	}
}
