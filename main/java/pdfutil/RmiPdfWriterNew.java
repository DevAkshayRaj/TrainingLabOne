package pdfutil;

import java.util.ArrayList;

public class RmiPdfWriterNew implements RmiConvertableNew{
	
	@Override
	public void convert(ArrayList<ArrayList<String>> data,String opfilename) throws Exception {
		RmiPdfDataWriter pd=RmiPdfDataWriter.getObj().getClone();
		ArrayList<String> a = data.remove((data.size() - 1));
		int h[] = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			h[i] = Integer.parseInt(a.get(i));
		}
		pd.putDataToPdf(h, data, "C:\\Users\\YQ425XM\\Downloads\\"+opfilename);
	}
//	
//	public static void main(String[] args) throws Exception{
//		new RmiPdfWriterNew().convert(InvoiceGenerator.getInvoice(1234567), "d:\\Rajaaa45");
//	}
	

}