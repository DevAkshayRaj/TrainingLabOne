package day16;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringClassDemo {
	public static void main(String[] args) {
		String a=new String("Test Variable");//both and heap and stack gets occupied so memory heavy
		
		String temp=a;//Not pass by reference. Two different objects
		
		a+=" Next Time";
		
		System.out.println(temp);
		
		System.out.println(a);
		
		StringBuffer sb=new StringBuffer("BufferTest object");//Synchronized(Thread Safe) But Slow
		System.out.println(sb);
		StringBuffer sa=sb;
		System.out.println(sa);
		sb.append(" Reference Test");
		System.out.println(sb);
		System.out.println(sa);
		
		StringBuilder sbs=new StringBuilder("BuilderTest Object");//Non Synchronized But fast
		System.out.println(sbs);
		StringBuilder sas=sbs;
		System.out.println(sas);
		sbs.append(" Reference Test");
		System.out.println(sbs);
		System.out.println(sas);
		
		
		StringJoiner sj=new StringJoiner("'");
		sj.add("Human");
		sj.add("s");
		System.out.println(sj);
		
		sj=new StringJoiner("'","(",")");
		sj.add("Human");
		sj.add("s");
		sj.add("sasas");
		System.out.println(sj);
		
		StringTokenizer sToken=new StringTokenizer(sj.toString(),"'");//like split()
		while(sToken.hasMoreTokens()) {
			System.out.println(sToken.nextToken());
		}
	}

}
