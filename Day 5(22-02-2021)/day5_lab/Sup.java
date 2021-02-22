package day5_lab;

class Base11{
Base11(int i){
System.out.println("base constructor");
}
Base11(){
}
}

public class Sup extends Base11{
public static void main(String argv[]){
Sup s= new Sup();
//One
}
Sup()
{
//Two
	super(10); //On the line After //Two put super(10);
}
public void derived()
{
//Three
}
}