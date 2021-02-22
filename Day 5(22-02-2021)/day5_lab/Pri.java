package day5_lab;

private class Base123{ // a class cannot be private
Base123(){
int i = 100;
System.out.println(i);
}
}
public class Pri extends Base123{
static int i = 200;
public static void main(String argv[]){
Pri p = new Pri();
System.out.println(i);
}
}