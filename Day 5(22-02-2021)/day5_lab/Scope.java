package day5_lab;

public class Scope{
private int i;
public static void main(String argv[]){
Scope s = new Scope();
s.amethod();
}//End of main
public static void amethod(){
System.out.println(i); //A compile time error variable i should either be static or accessed via Scope object
}//end of amethod
}//End of class