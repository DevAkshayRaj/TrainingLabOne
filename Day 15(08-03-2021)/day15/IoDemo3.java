package day15;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class IoDemo3 {
	public static void main(String[] args) throws Exception{
		String s="Whta is the score of the MAtch";
		PushbackInputStream pbs=new PushbackInputStream(new ByteArrayInputStream(s.getBytes()));
		int c=0;
		while((c=pbs.read())!=-1) {
			if((char)c=='h') {
				pbs.unread('H');
			}
			else {
				System.out.print((char)c);
			}
		}
	
	}
}
