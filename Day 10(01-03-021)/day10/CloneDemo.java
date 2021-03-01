package day10;

public class CloneDemo {
	public static void main(String[] args) throws Exception {
		
		//Multiton pattern waste of heap memmory not recomnded to use 
		Students a=new Students();
		Students b=new Students();
		
		//Singleton type one object is created and shared by multiple references
		
		Students c=new Students();
		Students d=c;
		
		
		//Prototype Pattern Create One Object of a class and clone it such that heap resource is shared while stack fields are unique for each clone
		Students s1=new Students();
		s1.name="Akshay";
		s1.dept="Information Technology";
		Students s2=s1.getStudentsClone();
		s2.name="Raj";
		s2.dept="Information Technology";	
		System.out.println(s1);
		System.out.println(s2);
	}
}

class Students implements Cloneable{
	String name;
	String dept;
	Students(){
		System.out.println("Students Object Created in Heap");
	}
	public Students getStudentsClone() throws Exception{
		return (Students)super.clone();
	}
	@Override
	public String toString() {
		return "Students [name=" + name + ", dept=" + dept + "]";
	}
	
}