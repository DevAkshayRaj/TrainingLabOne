package day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class URLDemo {
	public static void main(String[] args) throws Exception{
		URL url=new URL("https://google.com/index.html");
		URLConnection con=url.openConnection();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		FileOutputStream bw=new FileOutputStream("google.html");
		
		int c=0;
		while((c=br.read())!=-1) {
			bw.write(c);
		}
	}

}
