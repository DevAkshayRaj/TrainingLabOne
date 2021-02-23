package day6_concepts;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaintBrushExecute {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter the Colour : ");
		String input=br.readLine();
		PaintBrush brush=Container.getPaint("day6_concepts."+input);
		brush.doPaint();
	}
}


class Container{
	public static PaintBrush getPaint(String colour) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		PaintBrush brush=new PaintBrush();
		brush.paint=(Paint)Class.forName(colour).newInstance();
		return brush;
	}
}


class PaintBrush{
	Paint paint;
	public void doPaint() {
		paint.colour();
	}

}

abstract class Paint{
	abstract void colour();
}

class RedPaint extends Paint{

	@Override
	void colour() {
		System.out.println("Red Paint Has Been Taken !");
		
	}
}

class BluePaint extends Paint{

	@Override
	void colour() {
		System.out.println("Blue Paint Has Been Taken !");
		
	}
	
}
class GreenPaint extends Paint{

	@Override
	void colour() {
		System.out.println("Green Paint Has Been Taken !");
		
	}
}
class OrangePaint extends Paint{

	@Override
	void colour() {
		System.out.println("Orange Paint Has Been Taken !");
		
	}
}

