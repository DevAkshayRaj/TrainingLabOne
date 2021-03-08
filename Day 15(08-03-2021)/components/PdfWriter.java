package components;

public class PdfWriter implements Convertable{
	@Override
	public void convert(String filename) throws Exception {
		PdfDataWriter pd=Container.getPdfDataWriter();
		XMlParser xp=Container.getXMlParser();
		pd.putDataToPdf(filename, xp.getDataFromXml(filename));
		
	}
}
