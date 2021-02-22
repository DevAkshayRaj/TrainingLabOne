package day5_lab;

class Background implements Runnable{// run method of runnable interface does not have a return type
int i=0;
public int run(){
while(true){
i++;
System.out.println("i="+i);
} //End while
return 1;
}//End run
}//End class