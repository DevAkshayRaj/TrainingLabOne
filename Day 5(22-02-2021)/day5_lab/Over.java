package day5_lab;

class Base6{
 void amethod(int iBase){
System.out.println("Base.amethod");
}
}
class Over extends Base6{
public static void main(String argv[]){
Over o = new Over();
int iBase=0;
o.amethod(iBase);
}
public void amethod(int iOver){
System.out.println("Over.amethod");
}
}
// Output is "Over.amethod"