package day10;

public class CloneTest {
	public static void main(String[] args) throws Exception{
		Runtime r=Runtime.getRuntime();
		System.out.println(r.freeMemory());
		Pen a=Pen.getPen();
		a.colour="Red";
		Pen b=(Pen)Pen.getPen().getClone();
		b.colour="Blue";
		a.doWrite();
		b.doWrite();
		Paper c=Paper.getPaper();
		c.value="A4";
		Paper d=(Paper)Paper.getPaper().getClone();
		d.value="A5";
		c.paperType();
		d.paperType();
		Dummy da=new Dummy();
		da.doGet();
		System.out.println(r.freeMemory());
		System.gc();
		System.out.println(r.totalMemory());
	}
	
}

abstract class SuperClone implements Cloneable{
	public Object getClone() throws Exception{
		return super.clone();
	}
}

class Pen extends SuperClone{
	String colour;
	private static Pen pen;
	public void doWrite() {
		System.out.println("Written using "+colour+" Colour Pen");
	}
	
	private Pen() {
		System.out.println("Pen Object has been created !");
	}
	
	public static Pen getPen() {
		if(pen==null) {
			pen=new Pen();
		}
		return pen;
	}
}

class Paper extends SuperClone{
	private static Paper paper;
	String value;
	private Paper() {
		System.out.println("Paper Object Created !!");
	}
	public void paperType() {
		System.out.println("Written using "+value+" Colour Pen");
	}
	public static Paper getPaper() {
		if(paper==null) {
			paper=new Paper();
		}
		return paper;
	}
}

class Dummy{
	String d="sddsdssd";
	String a="";
	public void doGet() {
		for(int i=0;i<10000;i++) {
			a+=" ";
		}
	}
}