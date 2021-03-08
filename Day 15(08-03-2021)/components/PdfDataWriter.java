package components;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfDataWriter implements Cloneable {
	private static PdfDataWriter obj=null;
	private PdfDataWriter() {
		
	}
	public static PdfDataWriter getObj() {
		if(obj==null) {
			obj=new PdfDataWriter();
		}
		return obj;
	}
	public PdfDataWriter getClone() throws Exception{
		return (PdfDataWriter)super.clone();
	}
	public PdfPTable addTable(ArrayList<String> temp) {
		int n = temp.size();
		float f[] = new float[n];
		for (int i = 0; i < n; i++) {
			f[i] = 3;
		}
		PdfPTable table = new PdfPTable(f);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		for (int i = 0; i < n; i++) {
			table.addCell(temp.get(i));
		}
		table.setHeaderRows(1);
		PdfPCell[] cells = table.getRow(0).getCells();
		for (int j = 0; j < cells.length; j++) {
			cells[j].setBackgroundColor(BaseColor.GRAY);
		}
		return table;
	}

	public void putDataToPdf(String filename, ArrayList<ArrayList<String>> data)
			throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfPTable table = addTable(data.get(0));
		PdfPTable table2 = addTable(data.get(2));
		for (int i = 1; i < data.size(); i++) {
			ArrayList<String> temp = data.get(i);
			for (int j = 0; j < temp.size(); j++) {
				if (i == 2) {
					continue;
				} else if (i > 2) {
					table2.addCell(temp.get(j));
				} else
					table.addCell(temp.get(j));

			}
		}

		PdfWriter.getInstance(document, new FileOutputStream(filename));
		document.open();
		document.add(table);
		document.add(table2);
		document.close();
		//System.out.println("Done");
	}

}
