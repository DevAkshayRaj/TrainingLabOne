package day18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreationalDemo {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			try {
			CloneDemo d=CloneDemo.getObjClone();
			d.setA(34);
			System.out.println(d);
			}
			catch(Exception e) {
				
			}
		});
		es.execute(()->{
			try {
			CloneDemo da=CloneDemo.getObjClone();
			da.setA(3454);
			System.out.println(da);
			}
			catch(Exception e) {
				
			}
		});
		es.shutdown();
	}

}

//The get Object and get Clone Method SHould be Synchronized (Double dip problem) else if two threads try to access then two objects might be created
class CloneDemo implements Cloneable{
	private static CloneDemo obj=null;
	private int a;
	private CloneDemo() {
		System.out.println("CLoneDemo Object is Created");
	}
	
	synchronized public static CloneDemo getObj() {
		if(obj==null) {
			obj=new CloneDemo();
		}
		return obj;
	}
	
	synchronized public static CloneDemo getObjClone() {
		try {
			if(obj==null) {
				obj=new CloneDemo();
			}
			CloneDemo temp=obj.getClone();
			return temp;
		}catch(Exception e){
			e.printStackTrace();
			return null;
			
		}
	}
	
	synchronized private CloneDemo getClone() throws Exception{
		return (CloneDemo)super.clone();
	}

	public final int getA() {
		return a;
	}

	public final void setA(int a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "CloneDemo [a=" + a + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CloneDemo other = (CloneDemo) obj;
		if (a != other.a)
			return false;
		return true;
	}
	
	
	
}