package day17;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;


@Retention(RetentionPolicy.RUNTIME)
@interface Din{
	String tubeClass();
}

public class AnnoDemo {
	
	public static void main(String[] args) throws Exception{
		Wheel w=Container.getWHeel();
		w.getTubeType();
	}
}

class Container{
	public static Wheel getWHeel() throws Exception{
		Wheel l=new Wheel();
		Field f=l.getClass().getDeclaredField("tube");
		f.setAccessible(true);
		Din s=f.getAnnotation(Din.class);
		if(s!=null) {
			String name=s.tubeClass();
			l.tube=(Tube)Class.forName(name).getConstructor().newInstance();
		}else {
			
		}
		//l.tube=new NormalRubberTube();
		return l;
	}
}


class Wheel{
	@Din(tubeClass="day17.NormalRubberTube")
	Tube tube;
	public void getTubeType() {
		System.out.println(tube);
	}
}

abstract class Tube{
	public Tube() {
		
	}
}

class NormalRubberTube extends Tube{
	public NormalRubberTube() {
		
	}
}

class HybridRubberTube extends Tube{
	public HybridRubberTube() {
		
	}
}