package day8;

public class DriverMain {
	public static void main(String[] args) {
		Harris arr[]=new Harris[3];
		Harris h1=new HarrisInfotech();
		Harris h2=new HarrisPharma();
		Harris h3=new HarrisTechnologies();
		arr[0]=h1;
		arr[1]=h2;
		arr[2]=h3;
		arr[0].bannerName();
		arr[1].bannerName();
		arr[2].bannerName();
	}
}

abstract class Harris{
	abstract void bannerName();
}

 class HarrisInfotech extends Harris{
	@Override
	void bannerName() {
		System.out.println("Harris bannerName for HarrisInfotech");
		
	}
 }
 
 class HarrisTechnologies extends Harris{
	  @Override
	void bannerName() {
		  System.out.println("Harris bannerName for HarrisTechnologies");
			
		
	}
 }
 
 class HarrisPharma extends Harris{
	 @Override
	void bannerName() {
		 System.out.println("Harris bannerName for HarrisPharma");	
		
	}
 }