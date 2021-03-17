package day21;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> tdata=new ArrayList<>();
		tdata.add("asd");
		tdata.add("asd");
		tdata.add("asd");
		System.out.println(tdata);
		tdata.removeAll(tdata);
		System.out.println(tdata);
	}
}
