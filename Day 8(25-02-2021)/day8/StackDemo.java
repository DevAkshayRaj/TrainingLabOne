package day8;
import java.util.*;

public class StackDemo {
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(5);
		stack.push(15);
		stack.push(56);
		stack.push(85);
		stack.push(51);
		
		System.out.println("Initial Stack");
		System.out.println(stack);
		
		stack.pop();
		stack.pop();
		
		System.out.println("Stack After popping the top two");
		System.out.println(stack);
	}

}
