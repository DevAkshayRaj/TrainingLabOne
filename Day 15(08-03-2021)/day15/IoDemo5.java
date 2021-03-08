package day15;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IoDemo5 {
	public static void main(String[] args) throws Exception {
		PipedReader pr = new PipedReader();
		PipedWriter pw = new PipedWriter(pr);

		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			try {
				int c=0;
				while((c=pr.read())!=-1) {
					System.out.print((char)c);
					
				}
				
			}catch(Exception e){
				
			}
		});

		es.execute(() -> {
			while(true) {
				try {
				pw.write("Hello World From PrintWriter".toCharArray());
				System.out.println();
				Thread.sleep(1000);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
