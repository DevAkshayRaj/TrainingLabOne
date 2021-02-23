package day6_concepts;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DogDemo {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp=br.readLine();
		Container2 cObj=new Container2();
		LabDog dog=cObj.getDog("day6_concepts."+inp);
		NaughtyChild.playWithDog(dog);
	}
}


class Container2{

	public LabDog getDog(String item) throws Exception {
		LabDog dog=new LabDog();
		dog.reaction=(Reactions)Class.forName(item).newInstance();
		return dog;
	}
}


class LabDog{
	Reactions reaction;
	public void getReactions() {
		reaction.react();
	}
}

abstract class Reactions{
	abstract public void react();
}
class Stick extends Reactions{
	@Override
	public void react() {
		System.out.println("You Beat me I'll Bite !!!");
		
	}
}

class Stone extends Reactions{
	@Override
	public void react() {
		System.out.println("You Hit me I'll Bark !!!");
	}
}
class NaughtyChild {
	public static void playWithDog(LabDog dog)throws Exception{
		dog.getReactions();
		
	}
}