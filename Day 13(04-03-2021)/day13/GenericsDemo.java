package day13;

public class GenericsDemo {
	public static void main(String[] args) {
		PaintBrush<RedPaint> p1=new PaintBrush<>();
		p1.setObj(new RedPaint());
		RedPaint rp=p1.getObj();
		System.out.println(rp);
		
		PaintBrush<Warnish> p2=new PaintBrush<>();
		p2.setObj(new Warnish());
		Warnish w=p2.getObj();
		System.out.println(w);
		
		PaintBrush<Water> p3=new PaintBrush<>();
		p3.setObj(new Water());
		Water wat=p3.getObj();
		System.out.println(wat);
		
		PaintBrush<BluePaint> p4=new PaintBrush<>();
		p4.setObj(new BluePaint());
		BluePaint bp=p4.getObj();
		System.out.println(bp);
		
	}
}

class PaintBrush<T>{
	T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
}

abstract class Paint{
	
}

class RedPaint extends Paint{
	
}

class BluePaint extends Paint{
	
}

class Warnish{
	
}

class Water{
	
}