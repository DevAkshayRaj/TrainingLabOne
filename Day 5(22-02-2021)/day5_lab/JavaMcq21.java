package day5_lab;

public class JavaMcq21 {
	public static void main(String[] args) {
		JavaMcq21 c=new JavaMcq21();
		String s=new String("ello");
		c.amethod(s);
	}
	
	public void amethod(String s){
		char c='H';
		c+=s;// cannot concatinate string and character
		System.out.println(c);
	}
}
