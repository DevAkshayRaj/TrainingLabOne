package ExcelWriter;

import java.util.ArrayList;

public class ExcelWriter implements ConvertableNew{
	@Override
	public void convert(ArrayList<ArrayList<String>> data,String opfilename) throws Exception {
		ExcelDataWriter excel=ExcelDataWriter.getObj().getCLone();
		data.remove(data.size()-1);
		excel.putDataToExcel(data,"C:\\Users\\YQ425XM\\Downloads\\"+opfilename);
		
	}
	
}
