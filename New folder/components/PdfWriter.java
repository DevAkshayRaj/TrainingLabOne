package components;

import java.util.ArrayList;

public class PdfWriter implements Convertable{
	
	@Override
	public void convert(ArrayList<ArrayList<String>> data,String opfilename) throws Exception {
		PdfDataWriter pd=Container.getPdfDataWriter();
		ArrayList<String> a = data.remove((data.size() - 1));
		int h[] = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			h[i] = Integer.parseInt(a.get(i));
		}
		pd.putDataToPdf(h, data, opfilename);
	}
}
