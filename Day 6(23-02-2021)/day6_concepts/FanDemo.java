package day6_concepts;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FanDemo {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter the Speed Level : ");
		
		SpeedControl controller=Container1.getSpeedControl("day6_concepts.TurnOn");
		String input="ak";
		while(!input.equals("Akshay")) {
			input=br.readLine();
			controller.selectSpeed();
		}
		//SpeedControl controller=Container1.getSpeedControl("day6_concepts."+input);
		//controller.selectSpeed();
	}
	
}
 

class Container1{
	public static SpeedControl getSpeedControl(String level) throws Exception{
		SpeedControl control=new SpeedControl();
		control.speed=(AirSpeed)Class.forName(level).newInstance();
		return control;
	}
}


class SpeedControl{
	AirSpeed speed;
	public void selectSpeed(){
		speed.setSpeed(this);
	}
}

abstract class AirSpeed{
	abstract public void setSpeed(SpeedControl c);
}
class TurnOn extends AirSpeed{
	@Override
	public void setSpeed(SpeedControl c) {
		System.out.println("Fan Speed Has Been Turned ON !!");
		c.speed=new SpeedOne();
		
	}
}

class SpeedZero extends AirSpeed{

	@Override
	public void setSpeed(SpeedControl c) {
		System.out.println("Fan Speed Has Been Turned OFF !!");
		c.speed=new TurnOn();
	}
	
}

class SpeedOne extends AirSpeed{

	@Override
	public void setSpeed(SpeedControl c) {
		System.out.println("Fan Speed Has Been Set To ONE !!");
		c.speed=new SpeedTwo();
	}
	
}

class SpeedTwo extends AirSpeed{

	@Override
	public void setSpeed(SpeedControl c) {
		System.out.println("Fan Speed Has Been Set To TWO !!");	
		c.speed=new SpeedThree();
	}
	
}

class SpeedThree extends AirSpeed{

	@Override
	public void setSpeed(SpeedControl c) {
		System.out.println("Fan Speed Has Been Set To THREE !!");
		c.speed=new SpeedZero();
	}
	
}