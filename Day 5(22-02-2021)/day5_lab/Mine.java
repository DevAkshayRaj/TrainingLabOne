package day5_lab;

abstract class MineBase {
abstract void amethod();
static int i;
}
public class Mine extends MineBase { // Here class Mine must implement all the methods of MineBase since it is abstract class
public static void main(String argv[]){
int[] ar=new int[5];
for(i=0;i < ar.length;i++)
System.out.println(ar[i]);
}
}