package components;

public class Driver {
	public static void main(String[] args) throws Exception{
		Convertable ew=new ExcelWriter();
		ew.convert("Items.xml");
		Convertable pw=new PdfWriter();
		pw.convert("Items.xml");
	}
}
