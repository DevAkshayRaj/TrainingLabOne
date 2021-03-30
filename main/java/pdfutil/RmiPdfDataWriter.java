package pdfutil;


import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;

import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class RmiPdfDataWriter implements Cloneable {
	private static RmiPdfDataWriter obj = null;

	private RmiPdfDataWriter() {

	}

	public static RmiPdfDataWriter getObj() {
		if (obj == null) {
			obj = new RmiPdfDataWriter();
		}
		return obj;
	}

	public RmiPdfDataWriter getClone() throws Exception {
		return (RmiPdfDataWriter) super.clone();
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

	public void putDataToPdf(int[] heading, ArrayList<ArrayList<String>> data, String fname)
			throws Exception {
		Document document = new Document();
		PdfPTable table[] = new PdfPTable[heading.length];
		for (int i = 0; i < heading.length; i++) {
			table[i] = addTable(data.get(heading[i]));
		}
		int count = 0, flag = 1;
		for (int i = 0; i < data.size(); i++) {
			ArrayList<String> temp = data.get(i);
			for (int j = 0; j < temp.size(); j++) {
				if (count < heading.length) {
					if (i == heading[count]) {
						count++;
						flag = 0;
						continue;
					}
				}
				if (flag == 1)
					table[count - 1].addCell(temp.get(j));
			}
			if (flag == 0) {
				flag = 1;
				continue;
			}

		}

		PdfWriter.getInstance(document, new FileOutputStream(fname + ".pdf"));
		document.open();
		document.addTitle("Invoice for the list of items purchased ");
		document.addCreationDate();
		document.addSubject("Invoice for the list of items purchased ");
		for (PdfPTable t : table) {
			document.add(t);
		}
		document.close();
		
	}

}
