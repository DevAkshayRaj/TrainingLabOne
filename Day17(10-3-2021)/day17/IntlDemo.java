package day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class IntlDemo {
	public static void main(String[] args) throws Exception{
		BufferedReader br;
		BufferedWriter bw;
		
		br=new BufferedReader(new InputStreamReader(new FileInputStream("abs.properties"),Charset.forName("UTF-8")));
		
		bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Cope.properties"),Charset.forName("UTF-8")));
		
		int i=0;
		char c[]=new char[8];
		while((i=br.read(c))!=-1) {
			bw.write(c,0,i);
		}
		
		br.close();
		bw.close();
	}

}
