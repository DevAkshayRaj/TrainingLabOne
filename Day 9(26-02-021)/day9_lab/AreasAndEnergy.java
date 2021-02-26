package day9_lab;

public class AreasAndEnergy {
	static void calculateArea(int r,int h) {
		double area;
		area=(3.14*r*r)+(2*r*3.14*h);
		System.out.println("Area : "+ area);
	}
	
	static void calculateEnergy(int a,int h,int v,int m) {
		double energy;
		energy=m*(a*h+((v*v)/2));
		System.out.println("Energy : "+ energy);
		
	}
	
	public static void main(String[] args) {
		
		int r=6,h=5;
		calculateArea(r, h);
		int ha=5,a=9,v=67,m=89;
		calculateEnergy(a, ha, v, m);
	}
}
