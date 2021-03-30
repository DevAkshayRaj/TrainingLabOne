package ExcelWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelDataWriter implements Cloneable{
	private static ExcelDataWriter obj=null;
	private ExcelDataWriter() {
		
	}
	
	public static ExcelDataWriter getObj() {
		if(obj==null) {
			obj=new ExcelDataWriter();
		}
		return obj;
	}
	
	public ExcelDataWriter getCLone() throws Exception{
		return (ExcelDataWriter)super.clone();
	}
	
	public void putDataToExcel(ArrayList<ArrayList<String>> data,String fname) {
		// 1. Create an Excel file
		WritableWorkbook myFirstWbook = null;
		try {

			myFirstWbook = Workbook.createWorkbook(new File(fname+".xls"));

			// create an Excel sheet
			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

			for (int i = 0; i < data.size(); i++) {
				ArrayList<String> temp = data.get(i);
				for (int j = 0; j < temp.size(); j++) {
					Label label = new Label(j, i, temp.get(j));
					excelSheet.addCell(label);
				}

			}
			myFirstWbook.write();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally {

			if (myFirstWbook != null) {
				try {
					myFirstWbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
