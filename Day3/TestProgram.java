package second_session;

//A Java Program to check if a final variable can be modified and improper definition of constructore.
public class TestProgram {
	static int classId=5;
	
	TestProgram(int arg){
		this.classId=arg;
	}
	public static void main(String[] args) {
		final int finalVariable=5;
		finalVariable=5;/*The final local variable finalVariable cannot be assigned. It must be blank and not using a 
		 compound assignment*/
		TestProgram obj=new TestProgram();
		//The Constructor TestProgram() is not defined. 
		//obj.accessVariable();
		System.out.println(classId);
	}
	void accessVariable() {
		classId=5;
	}
}
